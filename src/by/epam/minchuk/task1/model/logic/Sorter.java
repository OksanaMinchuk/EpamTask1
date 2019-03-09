package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.exception.SorterNullPointerException;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {

    private static Comparator<Employee> comparatorSalary = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o1.getSalaryPerHour(), o2.getSalaryPerHour());
        }
    };

    private static Comparator<Employee> comparatorSurname = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    };

    public static void sortBySalary(Employee [] employees) throws SorterNullPointerException {
        if (employees != null) {
            Arrays.sort(employees, comparatorSalary);
        } else {
            throw new SorterNullPointerException("Invoking a method \"sortBySalary\" for a null object, employees cannot be null");
        }
    }

    public static void sortBySurnameAndSalary(Employee [] employees) throws SorterNullPointerException {
        if (employees != null) {
            Arrays.sort(employees, comparatorSurname.thenComparing(comparatorSalary));
        } else {
            throw new SorterNullPointerException("Invoking a method \"sortBySurnameAndSalary\" for a null object, employees cannot be null");
        }
    }
}
