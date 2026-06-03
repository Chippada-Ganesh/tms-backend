package com.srikrutha.tms.tmsbackend.controller;

import com.srikrutha.tms.tmsbackend.entity.Address;
import com.srikrutha.tms.tmsbackend.entity.Employee;
import com.srikrutha.tms.tmsbackend.repository.AddressRepository;
import com.srikrutha.tms.tmsbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Address saveAddress(
            @RequestBody Address address,
            @RequestParam Long employeeId
    ) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        address.setEmployee(employee);
        return addressRepository.save(address);
    }
}
