package by.epam.minchuk.task1.model.logic.finder;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.creator.TypeEmployee;
import by.epam.minchuk.task1.model.exception.FinderNullPointerException;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    /**
     * Returns an Arraylist containing all of the elements in existing array by surname
     */
    public static List<Employee> findAllEmployeeBySurname(Employee [] employees, String surnameValue) throws FinderNullPointerException {
        if (employees != null && surnameValue != null) {
            List<Employee> findEmployees = new ArrayList<>();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSurname().equals(surnameValue)) {
                    findEmployees.add(employees[i]);
                }
            }
            return findEmployees;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findAllEmployeeBySurname\" for a null object");
        }
    }

    /**
     * Returns employee with max salary
     */
    public static Employee findEmployeeByMaxSalary(Employee [] employees, int maxSalary) throws FinderNullPointerException {
        if (employees != null && maxSalary > 0) {
            Employee findEmployee = null;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalaryPerHour() == maxSalary) {
                    findEmployee = employees[i];
                }
            }
            return findEmployee;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findEmployeeByMaxSalary\" for a null object or wrong maxSalary value");
        }
    }

    /**
     * Returns max salary value
     */
    public static int findMaxSalary(Employee [] employees) throws FinderNullPointerException {
        if (employees != null) {
            int maxSalary = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalaryPerHour() > maxSalary) {
                    maxSalary = employees[i].getSalaryPerHour();
                }
            }
            return maxSalary;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findMaxSalary\" for a null object, employees cannot be null");
        }
    }

    /**
     * Returns an Arraylist containing all of the employees by typeEmployee
     */
    public static List<Employee> findEmployeeByType(Employee [] employees, TypeEmployee typeEmployee) throws FinderNullPointerException {
        if (employees != null && typeEmployee != null) {
            List<Employee> findEmployees = new ArrayList<>();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getClass().getSimpleName().equalsIgnoreCase(typeEmployee.toString())) {
                    findEmployees.add(employees[i]);
                }
            }
            return findEmployees;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findEmployeeByType\" for a null object");
        }
    }
}
