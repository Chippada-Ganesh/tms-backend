package com.srikrutha.tms.tmsbackend.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class SaveEmployeeService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        System.out.println("Camunda Service Task Executed");

        // Example: Get workflow variables
        String firstName = (String) execution.getVariable("firstName");
        String lastName = (String) execution.getVariable("lastName");

        System.out.println("Employee Name: " + firstName + " " + lastName);

        // Here you can call your existing service to save employee
    }
}