package by.epam.minchuk.task1.logic;

import by.epam.minchuk.task1.entity.Employee;

public class CompanyCreator {

    public CompanyCreator() {
    }

    public Employee[] addEmployee(Employee employees[], Employee employee) {
        Employee newEmployees[] = new Employee[employees.length+1];
        System.arraycopy(employees, 0,newEmployees,0, employees.length);
        newEmployees[newEmployees.length-1] = employee;
        employees = newEmployees;
        return employees;
    }

}

