package com.srikrutha.tms.tmsbackend.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import com.srikrutha.tms.tmsbackend.entity.Employee;
import com.srikrutha.tms.tmsbackend.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ✅ START PROCESS (ONLY ONCE)
    @PostMapping("/start")
    public String startProcess() {

        var processInstance = runtimeService.startProcessInstanceByKey("employee-onboarding");

        return processInstance.getId(); // VERY IMPORTANT
    }

    // ✅ SAVE EMPLOYEE DATA
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // ✅ COMPLETE TASK USING PROCESS ID
    @PostMapping("/complete-task")
    public String completeTask(@RequestParam String processInstanceId) {

        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .list();

        if (!tasks.isEmpty()) {
            Task task = tasks.get(0);

            System.out.println("Completing Task: " + task.getName());
            System.out.println("Process ID: " + processInstanceId);

            taskService.complete(task.getId());
            return "Task Completed";
        }

        return "No Task Found";
    }

    // GET ALL
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}