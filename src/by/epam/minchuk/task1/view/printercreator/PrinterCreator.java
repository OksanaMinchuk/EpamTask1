package by.epam.minchuk.task1.view.printercreator;

import by.epam.minchuk.task1.view.*;
import by.epam.minchuk.task1.view.exception.PrinterEnumConstantNotPresentException;

public class PrinterCreator {

    public enum PrinterType {
        CONSOLE, FILE, LOGGER, SOME
    }

    private PrinterCreator() {

    }

    public static Printable getPrinter(PrinterType printerType) throws PrinterEnumConstantNotPresentException {
        Printable printer;
            try {
                switch (printerType) {
                    case FILE:
                        printer = new FilePrinter();
                        break;
                    case LOGGER:
                        printer = new LoggerPrinter();
                        break;
                    case CONSOLE:
                        printer = new ConsolePrinter();
                        break;
                    default:
                        throw new EnumConstantNotPresentException(PrinterType.class, printerType.toString());
                }
            } catch (EnumConstantNotPresentException e) {
                throw new PrinterEnumConstantNotPresentException("Incorrect value in switch", e);
            }
        return printer;
    }
}
