package by.epam.minchuk.task1.controller;


import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.Team;
import by.epam.minchuk.task1.model.creator.CompanyCreator;
import by.epam.minchuk.task1.model.creator.TypeEmployee;
import by.epam.minchuk.task1.model.exception.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.model.exception.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.SorterNullPointerException;
import by.epam.minchuk.task1.model.exception.TeamNullPointerException;
import by.epam.minchuk.task1.model.logic.sorter.Sorter;
import by.epam.minchuk.task1.model.logic.finder.Finder;
import by.epam.minchuk.task1.view.Printable;
import by.epam.minchuk.task1.view.PrinterType;
import by.epam.minchuk.task1.view.creator.PrinterCreator;


public class MainController {
    public static void main(String[] args) {

        CompanyCreator companyCreator = new CompanyCreator();
        Employee employees [] = companyCreator.createCompany();

        Team team1 = null;
        Team team2 = null;
        try {
            team1 = companyCreator.createTeamNumberOne(employees);
            team2 = companyCreator.createTeamNumberTwo(employees);
        } catch (CompanyCreatorNullPointerException e) {
            e.printStackTrace();
        }

        int priceTeam1 = 0;
        int priceTeam2 = 0;

        try {
            priceTeam1 = team1.getTeamPrice(team1.getManager(), team1.getTeamEmployees());
            priceTeam2 = team1.getTeamPrice(team2.getManager(), team2.getTeamEmployees());
        } catch (TeamNullPointerException e) {
            e.printStackTrace();
        }

        Printable printer = PrinterCreator.getPrinter(PrinterType.CONSOLE);
        printer.printMessage("\tAll employees in ITCompany:");
        printer.print(employees);

        printer.printMessage("\tTeam 1 with total price Team " + priceTeam1 + "$ per hour is:");
        printer.print(team1);

        printer.printMessage("\tTeam 2 with total price Team " + priceTeam2 + "$ per hour is:");
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
            printer.print(Finder.findEmployeeByType(employees, TypeEmployee.TESTER));

            printer.printMessage("\tEmployee by type PROJECT_MANAGER:");
            printer.print(Finder.findEmployeeByType(employees, TypeEmployee.PROJECTMANAGER));

            printer.printMessage("\tEmployee by type DEVELOPER:");
            printer.print(Finder.findEmployeeByType(employees, TypeEmployee.DEVELOPER));
        } catch (FinderNullPointerException finderNullPointerException) {
            finderNullPointerException.printStackTrace();
        }

    }
}
