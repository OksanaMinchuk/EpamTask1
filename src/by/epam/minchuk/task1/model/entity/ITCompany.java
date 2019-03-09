package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.ITCompanyDataWrongException;
import by.epam.minchuk.task1.model.exception.ITCompanyNullPointerException;

import java.util.Arrays;

/**
 * Class {@code ITCompany}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ITCompany {

    private static final int DEFAULT_LENGHT = 0;
    private Employee employeesArray[];
    private int lenght;

    public ITCompany() {
        lenght = DEFAULT_LENGHT;
        employeesArray = new Employee[lenght];
    }

    public ITCompany(Employee[] employeesArray) {
        this.employeesArray = employeesArray;
    }

    public int getLenght() {
        return lenght;
    }

    public Employee[] getEmployeesArray() {
        return employeesArray;
    }

    public Employee getEmployee(int index) throws ITCompanyDataWrongException {
        if (index >= 0 || index < lenght) {
            return employeesArray[index];
        } else {
            throw new ITCompanyDataWrongException("Wrong array index");
        }
    }

    public void setEmployee(int index, Employee newEmployee) throws ITCompanyDataWrongException {
        if (newEmployee != null && index >=0 && index < lenght) {
            this.employeesArray[index] = newEmployee;
        } else {
            throw new ITCompanyDataWrongException("Wrong array index or newEmployee value is null");
        }
    }

    public void addEmployeeToCompany (Employee employee) throws ITCompanyNullPointerException {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employeesArray.length + 1];
            for (int i = 0; i < employeesArray.length; i++) {
                newEmployees[i] = employeesArray[i];
            }
            newEmployees[employeesArray.length] = employee;
            employeesArray = newEmployees;
        } else {
            throw new ITCompanyNullPointerException ("Invoking a method \"addEmployeeToCompany\" for a null object, employee cannot be null");
        }
    }

    public void removeEmployeeFromCompany(Employee employee) throws ITCompanyNullPointerException {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employeesArray.length-1];
            for (int i = 0, j = 0; i < employeesArray.length; i++, j++) {
                if (!employee.equals(employeesArray[i])) {
                    newEmployees[j] = employeesArray[i];
                } else {
                    j--;
                }
            }
            employeesArray = newEmployees;
        } else {
            throw new ITCompanyNullPointerException ("Invoking a method \"removeEmployeeFromCompany\" for a null object, employee cannot be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ITCompany itCompany = (ITCompany) o;

        if (lenght != itCompany.lenght) return false;
        return Arrays.equals(employeesArray, itCompany.employeesArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(employeesArray);
        result = 31 * result + lenght;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ITCompany\n");
        for (Employee employee : employeesArray) {
            builder.append(employee).append("\n");
        }
        return builder + "";
    }


}
