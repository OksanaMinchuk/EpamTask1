package by.epam.minchuk.task1.view;

public class PrintConsole implements Printable{
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void print(Object[] ob) {
        for (Object obj: ob) {
            System.out.println(obj);
        }
    }

    public void print(Object ob) {
        System.out.println(ob);
    }
}
