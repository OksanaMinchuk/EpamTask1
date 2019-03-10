package by.epam.minchuk.task1.controller;


import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.entity.Team;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.util.CompanyCreator;
import by.epam.minchuk.task1.model.exception.technicalexeption.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.SorterNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.TeamNullPointerException;
import by.epam.minchuk.task1.model.logic.Sorter;
import by.epam.minchuk.task1.model.logic.Finder;
import by.epam.minchuk.task1.view.Printable;
import by.epam.minchuk.task1.view.PrinterType;
import by.epam.minchuk.task1.view.printercreator.PrinterCreator;
import by.epam.minchuk.task1.view.exception.PrinterEnumConstantNotPresentException;


public class MainController {
    public static void main(String[] args) {

        CompanyCreator companyCreator = new CompanyCreator();
        Employee employees [] = companyCreator.createCompany();
        ITCompany itCompany = new ITCompany(employees);

        Team team1 = null;
        Team team2 = null;
        try {
            team1 = companyCreator.createTeamNumberOne(itCompany);
            team2 = companyCreator.createTeamNumberTwo(itCompany);
        } catch (CompanyCreatorNullPointerException e) {
            e.printStackTrace();
        }

        double priceTeam1 = 0;
        double priceTeam2 = 0;

        try {
            priceTeam1 = team1.getTeamPrice();
            priceTeam2 = team1.getTeamPrice();
        } catch (TeamNullPointerException e) {
            e.printStackTrace();
        }

        Printable printer = null;

        try {
            printer = PrinterCreator.getPrinter(PrinterType.CONSOLE);
        } catch (PrinterEnumConstantNotPresentException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.err.println("The cause of this throwable is: " + e.getCause());
        }

        printer.printMessage("\tAll employees in ITCompany:");
        printer.print(employees);

        printer.printMessage("\tTeam 1 with total price " + priceTeam1 + "$ per hour is:");
        printer.print(team1);

        printer.printMessage("\tTeam 2 with total price " + priceTeam2 + "$ per hour is:");
        printer.print(team2);

        try {
            Sorter.sortBySalary(employees);
            printer.printMessage("\tSorting by salary:");
            printer.print(employees);
            Sorter.sortBySurnameAndSalary(employees);
            printer.printMessage("\tSorting by surname and salary:");
            printer.print(employees);
        } catch (SorterNullPointerException e) {
            e.printStackTrace();
        }

        try {
            printer.printMessage("\tFind all employees by surname:");
            printer.print(Finder.findAllEmployeeBySurname(employees, "Conor"));

            printer.printMessage("\tMax salary is: " + Finder.findMaxSalary(employees));

            printer.printMessage("\tEmployee with max salary is:");
            printer.print(Finder.findEmployeeByMaxSalary(employees, Finder.findMaxSalary(employees)));

            printer.printMessage("\tEmployee by type TESTER:");
            printer.print(Finder.findEmployeeByType(employees, Employee.EmployeeType.TESTER));

            printer.printMessage("\tEmployee by type PROJECT_MANAGER:");
            printer.print(Finder.findEmployeeByType(employees, Employee.EmployeeType.PROJECTMANAGER));

            printer.printMessage("\tEmployee by type DEVELOPER:");
            printer.print(Finder.findEmployeeByType(employees, Employee.EmployeeType.DEVELOPER));
        } catch (FinderNullPointerException finderNullPointerException) {
            finderNullPointerException.printStackTrace();
        } catch (FinderEmployeeNotFoundException e) {
            e.printStackTrace();
        }


    }
}
