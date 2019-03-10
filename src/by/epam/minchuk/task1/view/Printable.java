package by.epam.minchuk.task1.view;

import by.epam.minchuk.task1.model.entity.Employee;

import java.util.List;

public interface Printable {

    public void printMessage(String message);
    public void print(Employee[] ob);
    public void print(Object ob);
    public void print(List<Employee> employees);

}
