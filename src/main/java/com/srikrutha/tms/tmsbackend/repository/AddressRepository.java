package com.srikrutha.tms.tmsbackend.repository;

import com.srikrutha.tms.tmsbackend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
