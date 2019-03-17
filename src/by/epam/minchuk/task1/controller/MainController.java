package by.epam.minchuk.task1.controller;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.SorterNullPointerException;
import by.epam.minchuk.task1.model.logic.*;
import by.epam.minchuk.task1.util.CompanyCreator;
import by.epam.minchuk.task1.model.exception.technicalexeption.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.util.TeamCreator;
import by.epam.minchuk.task1.util.localizationConst.EmployeeConstant;
import by.epam.minchuk.task1.view.Printable;
import by.epam.minchuk.task1.view.printercreator.PrinterCreator;
import by.epam.minchuk.task1.view.exception.PrinterEnumConstantNotPresentException;

import java.util.Locale;

/**
 * Class {@code MainController}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class MainController {

    //private static final String INPUT_FILENAME = "inputData.txt";

    public static void main(String[] args) {

        Locale locale  = new Locale("en", "UK");
        //Locale locale  = new Locale("de", "DE");
        EmployeeConstant.changeLocale(locale);

        CompanyCreator companyCreator = new CompanyCreator();
        TeamCreator teamCreator = new TeamCreator();
        ITCompany itCompany = new ITCompany();

        Employee[] employees = companyCreator.createCompany();
        try {
            itCompany.setEmployeesArray(employees);
        } catch (ITCompanyNullPointerException e) {
            e.printStackTrace();
        }

        Team team1 = null;
        Team team2 = null;
        try {
            team1 = teamCreator.createTeamOne(itCompany);
            team2 = teamCreator.createTeamTwo(itCompany);
            itCompany.addTeam(team1);
            itCompany.addTeam(team2);
        } catch (ITCompanyNullPointerException e) {
            e.printStackTrace();
        } catch (CompanyCreatorNullPointerException e) {
            e.printStackTrace();
        }

        double priceTeam1 = team1.getTeamPrice();
        double priceTeam2 = team2.getTeamPrice();

        Printable printer = null;

        try {
            printer = PrinterCreator.getPrinter(PrinterCreator.PrinterType.CONSOLE);
            //printer = PrinterCreator.getPrinter(PrinterCreator.PrinterType.LOGGER);
        } catch (PrinterEnumConstantNotPresentException e) {
            e.printStackTrace();
        }

        printer.printMessage("\tAll employees in ITCompany:");
        printer.print(itCompany);

        printer.printMessage("\tTeam 1 total price " + priceTeam1 + "$ per hour");
        printer.printMessage("\tTeam 2 total price " + priceTeam2 + "$ per hour");

        try {
            Sorter.sortBySalary(itCompany);
            printer.printMessage("\n\tSorting employees by salary:");
            printer.print(itCompany);
            Sorter.sortBySurnameAndSalary(itCompany);
            printer.printMessage("\tSorting employees by surname and salary:");
            printer.print(itCompany);
        } catch (SorterNullPointerException e) {
            e.printStackTrace();
        }

        try {
            printer.printMessage("\tFind all employees by surname:");
            printer.print(FinderAllEmployeeBySurname.findAllEmployeeBySurname(itCompany, "Conor"));

            printer.printMessage("\tMax salary is: " + FinderMaxSalary.findMaxSalary(itCompany));

            printer.printMessage("\tEmployee with max salary is:");
            printer.print(FinderEmployeeByMaxSalary.findEmployeeByMaxSalary(itCompany, FinderMaxSalary.findMaxSalary(itCompany)));

            printer.printMessage("\tEmployee by type TESTER:");
            printer.print(FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.TESTER));

            printer.printMessage("\tEmployee by type PROJECT_MANAGER:");
            printer.print(FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.PROJECTMANAGER));

            printer.printMessage("\tEmployee by type DEVELOPER:");
            printer.print(FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.DEVELOPER));
        } catch (FinderNullPointerException e) {
            e.printStackTrace();
        } catch (FinderEmployeeNotFoundException e) {
            e.printStackTrace();
        }

    }
}
