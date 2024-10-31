package com.hmall.gateway.routers;


import cn.hutool.json.JSONUtil;
import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@Component
@Slf4j
@RequiredArgsConstructor
public class DynamicRouteLoader {
    private final RouteDefinitionWriter write;

    private final NacosConfigManager nacosConfigManager;
    private final String dataId = "gateway-routes.json";
    private final String group = "DEFAULT_GROUP";
    private final Set<String> routeIds = new HashSet<>();

    @PostConstruct
    public void initRouteConfigListener() throws NacosException {
        String configInfo = nacosConfigManager.getConfigService()
                .getConfigAndSignListener(dataId, group, 5000, new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        updateConfigInfo(configInfo);
                    }
                });
        updateConfigInfo(configInfo);

    }

    public void updateConfigInfo(String configInfo) {
        log.debug("更新路由配置信息:{}", configInfo);
        List<RouteDefinition> routeDefinitions = JSONUtil.toList(configInfo, RouteDefinition.class);
        for (String routeId : routeIds) {
            write.delete(Mono.just(routeId)).subscribe();
        }
        routeIds.clear();
        for (RouteDefinition routeDefinition : routeDefinitions) {
            try {
                write.save(Mono.just(routeDefinition)).subscribe();
                routeIds.add(routeDefinition.getId());

            } catch (Exception e) {
                log.error("更新路由配置失败", e);
            }
        }
    }
}
