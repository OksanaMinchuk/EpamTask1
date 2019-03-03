package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.ITCompanyDataWrongException;
import by.epam.minchuk.task1.model.exception.ITCompanyNullPointerException;

import java.util.Arrays;

/**
 * Class {@code ITCompany} for adding and removing Employees to the ITCompany
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ITCompany {

    private Employee employees[];

    public ITCompany() {
        employees = new Employee[0];
    }

    public ITCompany(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) throws ITCompanyDataWrongException {
        if (employees != null) {
            this.employees = employees;
        } else {
            throw new ITCompanyDataWrongException("Wrong employees array value");
        }
    }

    public void addEmployeeToCompany (Employee employee) throws ITCompanyNullPointerException {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employees.length + 1];
            for (int i = 0; i < employees.length; i++) {
                newEmployees[i] = employees[i];
            }
            newEmployees[employees.length] = employee;
            employees = newEmployees;
        } else {
            throw new ITCompanyNullPointerException ("Invoking a method \"addEmployeeToCompany\" for a null object, employee cannot be null");
        }
    }

    public void removeEmployeeFromCompany(Employee employee) throws ITCompanyNullPointerException {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employees.length-1];
            for (int i = 0, j = 0; i < employees.length; i++, j++) {
                if (!employee.equals(employees[i])) {
                    newEmployees[j] = employees[i];
                } else {
                    j--;
                }
            }
            employees = newEmployees;
        } else {
            throw new ITCompanyNullPointerException ("Invoking a method \"removeEmployeeFromCompany\" for a null object, employee cannot be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ITCompany itCompany = (ITCompany) o;
        return Arrays.equals(employees, itCompany.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ITCompany\n");
        for (Employee employee : employees) {
            builder.append(employee).append("\n");
        }
        return builder + "";
    }


}
