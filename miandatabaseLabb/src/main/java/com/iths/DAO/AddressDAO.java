package com.iths.DAO;

import com.iths.domain.pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Integer> {
}
