package by.epam.minchuk.task1.entity.creator;

import by.epam.minchuk.task1.entity.Developer;
import by.epam.minchuk.task1.entity.Employee;
import by.epam.minchuk.task1.entity.ProjectManager;
import by.epam.minchuk.task1.entity.Tester;
import by.epam.minchuk.task1.exception.MyNullPointerException;

import java.util.Arrays;

public class ITCompany {
    private Employee employees[] = new Employee[0];

    public ITCompany() {
    }

    public ITCompany(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Employee getEmployee(int numberElem) {
        int number = numberElem;
        return employees[number];
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public void addEmployeeToCompany (Employee employee) throws MyNullPointerException {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employees.length+1];
            for (int i = 0; i < employees.length; i++) {
                newEmployees[i] = employees[i];
            }
            newEmployees[employees.length] = employee;
            employees = newEmployees;
        } else throw new MyNullPointerException("Invoking a method for a null object");
    }

    public void removeEmployeeFromCompany(Employee employee) throws MyNullPointerException {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employees.length-1];
            int j = 0;
            for (int i = 0; i < employees.length; i++) {
                if (!employee.equals(employees[i])) {
                    newEmployees[j] = employees[i];
                } else {
                    j--;
                }
                j++;
            }
            employees = newEmployees;
        } else throw new MyNullPointerException("Invoking a method for a null object");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ITCompany itCompany = (ITCompany) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
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
