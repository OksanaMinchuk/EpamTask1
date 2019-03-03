package by.epam.minchuk.task1.view.creator;

import by.epam.minchuk.task1.view.*;

public class PrinterCreator {

    private static Printable printer = null;

    private PrinterCreator() {

    }

    public static Printable getPrinter(PrinterType printerType) {
        if (printer == null) {
            switch (printerType) {
                case FILE: printer = new PrinterFile(); break;
                case LOGGER: printer = new PrinterLogger(); break;
                case CONSOLE: printer = new PrinterConsole(); break;
            }
        }
        return printer;
    }
}
