package com.srikrutha.tms.tmsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.srikrutha.tms.tmsbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
