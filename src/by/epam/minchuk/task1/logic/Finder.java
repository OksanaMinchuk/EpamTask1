package by.epam.minchuk.task1.logic;

import by.epam.minchuk.task1.entity.Employee;
import by.epam.minchuk.task1.entity.creator.TypeEmployee;
import by.epam.minchuk.task1.exception.MyNullPointerException;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    /**
    *Returns an Arraylist containing all of the elements in existing array by surname
    */
    public List<Employee> findAllEmployeeBySurname(Employee [] employees, String surnameValue) {
        List<Employee> findEmployees = new ArrayList<>();
        int j = 0;
        for (int i =0; i < employees.length; i++) {
            if (employees[i].getSurname().equals(surnameValue)){
                findEmployees.add(employees[i]);
            }
        }
        return findEmployees;
    }

    /**
     *Returns only one Employee by surname
     */
    public Employee findEmployeeBySurname(Employee [] employees, String surnameValue) {
        Employee findEmployee = null;
        int i = 0;
        for (Employee employee: employees) {
            if (employee.getSurname().equals(surnameValue)){
                findEmployee = employee;
            }
        }
        return findEmployee;
    }

    public Employee findEmployeeByMaxSalary(Employee [] employees, int maxSalary) {
        Employee findEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalaryPerHour() == maxSalary){
                findEmployee = employees[i];
            }
        }
        return findEmployee;
    }

    public int findMaxSalary(Employee [] employees) {
        int maxSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalaryPerHour() > maxSalary){
                maxSalary = employees[i].getSalaryPerHour();
            }
        }
        return maxSalary;
    }

    public List<Employee> findEmployeeByType(Employee [] employees, TypeEmployee typeEmployee) {
        List<Employee> findEmployees = new ArrayList<>();
        int j = 0;
        for (int i =0; i < employees.length; i++) {
            if (employees[i].getClass().getSimpleName().equalsIgnoreCase(typeEmployee.toString())){
                findEmployees.add(employees[i]);
            }
        }
        return findEmployees;
    }
}
