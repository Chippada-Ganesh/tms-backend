package com.srikrutha.tms.tmsbackend.repository;

import com.srikrutha.tms.tmsbackend.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
