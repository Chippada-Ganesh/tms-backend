package com.srikrutha.tms.tmsbackend.controller;

import com.srikrutha.tms.tmsbackend.entity.Bank;
import com.srikrutha.tms.tmsbackend.repository.BankRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

    private final BankRepository bankRepository;

    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @PostMapping
    public Bank saveBank(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }
}
