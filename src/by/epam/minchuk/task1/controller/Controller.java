package by.epam.minchuk.task1.controller;

import by.epam.minchuk.task1.entity.*;
import by.epam.minchuk.task1.entity.creator.ITCompany;
import by.epam.minchuk.task1.entity.creator.TypeEmployee;
import by.epam.minchuk.task1.exception.MyNullPointerException;
import by.epam.minchuk.task1.logic.Finder;
import by.epam.minchuk.task1.logic.Sorter;
import by.epam.minchuk.task1.view.PrintConsole;

public class Controller {

    PrintConsole printConsole = new PrintConsole();

    Developer developer1 = new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Java");
    Developer developer2 = new Developer("Donald", "Freeman", 46, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "C++");
    Developer developer3 = new Developer("Jack", "Gilbert", 52, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "HTML");
    Developer developer4 = new Developer("Jack", "Harrison", 37, Engineer.EngineerLevelType.JUNIOR,
            Developer.DeveloperType.FRONT_END, "CSS");
    Developer developer5 = new Developer("Carroll", "Anderson", 48, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "JavaScript");
    Developer developer6 = new Developer("Cris", "Norman", 42, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Python");

    Tester tester1 = new Tester("Tom", "Gibbs", 25,
            Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL);
    Tester tester2 = new Tester("Hailey", "Conor", 34,
            Tester.EngineerLevelType.SENIOR, Tester.TesterType.AUTOMATION);
    Tester tester3 = new Tester("Oliver", "Watson", 31,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.AUTOMATION);

    ProjectManager projectManager1 = new ProjectManager("Scott","Johnson",60, "Online-Store");
    ProjectManager projectManager2 = new ProjectManager("Martin","Thompson",62, "Game");

    public void createController()  {

    //creating company and adding Employee to ITCompany
        ITCompany itCompany = new ITCompany();
        try {
            itCompany.addEmployeeToCompany(developer1);
            itCompany.addEmployeeToCompany(developer2);
            itCompany.addEmployeeToCompany(developer3);
            itCompany.addEmployeeToCompany(developer4);
            itCompany.addEmployeeToCompany(developer5);
            itCompany.addEmployeeToCompany(developer6);
            itCompany.addEmployeeToCompany(tester1);
            itCompany.addEmployeeToCompany(tester2);
            itCompany.addEmployeeToCompany(tester3);
            itCompany.addEmployeeToCompany(projectManager1);
            itCompany.addEmployeeToCompany(projectManager2);
        } catch (MyNullPointerException e) {
            e.printStackTrace();
        }

        Employee employeeArr[] = itCompany.getEmployees();
        printConsole.printMessage("\tAll employees in ITCompany:");
        printConsole.print(employeeArr);

//**********************************************
    //creating teams and getting price team
        Team team1 = new Team();
        Team team2 = new Team();
        try {
            team1.setManager(projectManager1);
            team1.addEmployeeToTeam(developer1);
            team1.addEmployeeToTeam(developer4);
            team1.addEmployeeToTeam(developer5);
            team1.addEmployeeToTeam(tester1);

            team2.setManager(projectManager2);
            team2.addEmployeeToTeam(developer2);
            team2.addEmployeeToTeam(developer6);
            team2.addEmployeeToTeam(tester2);
            team2.addEmployeeToTeam(tester3);
        } catch (MyNullPointerException e) {
            e.printStackTrace();
        }
        int priceTeam1 = 0;
        int priceTeam2 = 0;
        try {
            priceTeam1 = team1.getTeamPrice(team1.getManager(), team1.getTeamEmployees());
            priceTeam2 = team2.getTeamPrice(team2.getManager(), team2.getTeamEmployees());
        } catch (MyNullPointerException e) {
            e.printStackTrace();
        }
        printConsole.printMessage("\tTeam 1 with total price Team " + priceTeam1 + " is:");
        printConsole.print(team1);

        printConsole.printMessage("\tTeam 2 with total price Team " + priceTeam2 + " is:");
        printConsole.print(team2);

//**********************************************
        Sorter sorter = new Sorter();
        sorter.sortBySalary(employeeArr);
        printConsole.printMessage("\tSorting By Salary:");
        printConsole.print(employeeArr);

        sorter.sortBySurnameAndSalary(employeeArr);
        printConsole.printMessage("\tSorting By Surname Salary:");
        printConsole.print(employeeArr);

//**********************************************
        Finder finder = new Finder();
        printConsole.printMessage("\tFind All Employee By Surname:");
        printConsole.print(finder.findAllEmployeeBySurname(employeeArr, "Conor"));

        printConsole.printMessage("\tMax Salary is:");
        printConsole.print(finder.findMaxSalary(employeeArr));

        printConsole.printMessage("\tEmployee with Max Salary is:");
        printConsole.print(finder.findEmployeeByMaxSalary(employeeArr, finder.findMaxSalary(employeeArr)));

        printConsole.printMessage("\tEmployee by type:");
        printConsole.print(finder.findEmployeeByType(employeeArr, TypeEmployee.TESTER));

        printConsole.printMessage("\tEmployee by type:");
        printConsole.print(finder.findEmployeeByType(employeeArr, TypeEmployee.PROJECTMANAGER));
    }
}
