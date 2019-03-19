package by.epam.minchuk.task1.controller;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.SorterNullPointerException;
import by.epam.minchuk.task1.model.logic.*;
import by.epam.minchuk.task1.util.ITCompanyCreator;
import by.epam.minchuk.task1.model.exception.technicalexeption.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.util.TeamCreator;
import by.epam.minchuk.task1.util.localizationConst.Constant;
import by.epam.minchuk.task1.view.Printable;
import by.epam.minchuk.task1.view.printercreator.PrinterCreator;
import by.epam.minchuk.task1.view.exception.PrinterEnumConstantNotPresentException;
import org.apache.log4j.Logger;

import java.util.Locale;

/**
 * Class {@code MainController}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class MainController {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) {

        //Locale locale  = new Locale("en", "UK");
        //Locale locale  = new Locale("de", "DE");
        Locale locale  = new Locale("ru", "RU");
        Constant.changeLocale(locale);

        Printable printer = null;
        try {
            printer = PrinterCreator.getPrinter(PrinterCreator.PrinterType.FILE);
        } catch (PrinterEnumConstantNotPresentException e) {
            e.printStackTrace();
        }

        ITCompanyCreator companyCreator = new ITCompanyCreator();
        TeamCreator teamCreator = new TeamCreator();
        ITCompany itCompany = new ITCompany();

        Employee[] employees = companyCreator.createCompany();
        try {
            itCompany.setEmployeesArray(employees);
        } catch (ITCompanyNullPointerException e) {
            e.printStackTrace();
            LOGGER.error("exception ", e);
        }

        Team team1 = null;
        Team team2 = null;
        try {
            team1 = teamCreator.createTeamOne(itCompany);
            team2 = teamCreator.createTeamTwo(itCompany);
            itCompany.addTeam(team1);
            itCompany.addTeam(team2);
            LOGGER.info("teams added");
        } catch (ITCompanyNullPointerException e) {
            LOGGER.error("exception ", e);
            e.printStackTrace();
        } catch (CompanyCreatorNullPointerException e) {
            LOGGER.error("exception ", e);
            e.printStackTrace();
        }

        double priceTeam1 = team1.getTeamPrice();
        double priceTeam2 = team2.getTeamPrice();

        printer.print("\tAll employees in ITCompany:");
        printer.print(itCompany);

        printer.print("\tTeam 1 total price " + priceTeam1 + "$ per hour");
        printer.print("\tTeam 2 total price " + priceTeam2 + "$ per hour");

        try {
            Sorter.sortBySalary(itCompany);
            printer.print("\n\tSorting employees by salary:");
            printer.print(itCompany);
            Sorter.sortBySurnameAndSalary(itCompany);
            printer.print("\tSorting employees by surname and salary:");
            printer.print(itCompany);
        } catch (SorterNullPointerException e) {
            LOGGER.error("exception ", e);
            e.printStackTrace();
        }

        try {
            printer.print("\tFind all employees by surname:");
            printer.print(FinderAllEmployeeBySurname.findAllEmployeeBySurname(itCompany, "Conor"));

            printer.print("\tMax salary is: " + FinderMaxSalary.findMaxSalary(itCompany));

            printer.print("\tEmployee with max salary is:");
            printer.print(FinderEmployeeByMaxSalary.findEmployeeByMaxSalary(itCompany, FinderMaxSalary.findMaxSalary(itCompany)));

            printer.print("\tEmployee by type TESTER:");
            printer.print(FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.TESTER));

            printer.print("\tEmployee by type PROJECT_MANAGER:");
            printer.print(FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.PROJECTMANAGER));

            printer.print("\tEmployee by type DEVELOPER:");
            printer.print(FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.DEVELOPER));
        } catch (FinderNullPointerException e) {
            LOGGER.error("exception ", e);
            e.printStackTrace();
        } catch (FinderEmployeeNotFoundException e) {
            LOGGER.error("exception ", e);
            e.printStackTrace();
        }
        LOGGER.info("the end");
    }
}
