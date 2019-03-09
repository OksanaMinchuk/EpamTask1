package by.epam.minchuk.task1.view;

import by.epam.minchuk.task1.model.entity.Employee;

import java.util.List;

public class ConsolePrinter implements Printable{
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void print(Employee[] ob) {
        for (Object obj: ob) {
            System.out.println(obj);
        }
    }

    @Override
    public void print(Object ob) {
        System.out.println(ob);
    }

    @Override
    public void print(List<Employee> employees) {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }
}
