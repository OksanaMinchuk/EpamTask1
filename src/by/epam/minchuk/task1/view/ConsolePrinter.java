package by.epam.minchuk.task1.view;

public class ConsolePrinter implements Printable{

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void print(Object ob) {
        System.out.println(ob);
    }

}
