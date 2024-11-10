package com.hamll.item.es;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.hmall.item.ItemApplication;
import com.hmall.item.domain.po.Item;
import com.hmall.item.domain.po.ItemDoc;
import com.hmall.item.service.IItemService;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
// TODO SOLVE PROBLEM OF UNABLE TO FIND A  SPRINGBOOTCONFIGURATION

@SpringBootTest(properties = "spring.profiles.active=local")
public class ElasticDocTest {

    private RestHighLevelClient client;

    @Autowired
    private IItemService itemService;

    @Test
    void testIndexes() throws IOException {
        Item byId = itemService.getById(100000011127L);
        ItemDoc itemDoc = BeanUtil.copyProperties(byId, ItemDoc.class);

        IndexRequest request = new IndexRequest("items").id(itemDoc.getId());
        request.source(JSONUtil.toJsonStr(itemDoc), XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }


}
