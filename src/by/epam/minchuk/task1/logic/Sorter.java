package by.epam.minchuk.task1.logic;

import by.epam.minchuk.task1.entity.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {

    private Comparator<Employee> comparatorSalary = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getSalaryPerHour(), o2.getSalaryPerHour());
        }
    };

    private Comparator<Employee> comparatorSurname = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    };

    public void sortBySalary(Employee [] employees) {
        Arrays.sort(employees, comparatorSalary);
    }

    public void sortBySurnameAndSalary(Employee [] employees) {
        Arrays.sort(employees, comparatorSurname.thenComparing(comparatorSalary));
    }
}
