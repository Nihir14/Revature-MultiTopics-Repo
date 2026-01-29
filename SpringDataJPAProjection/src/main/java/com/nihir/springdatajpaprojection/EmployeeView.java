package com.nihir.springdatajpaprojection;

public interface EmployeeView {

    String getName();   // from Employee

    DepartmentInfo getDepartment();

    interface DepartmentInfo {
        String getName();  // from Department
    }
}
