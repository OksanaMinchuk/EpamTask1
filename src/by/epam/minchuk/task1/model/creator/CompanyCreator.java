package by.epam.minchuk.task1.model.creator;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.model.exception.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.exception.TeamDataWrongException;
import by.epam.minchuk.task1.model.exception.TeamNullPointerException;
import by.epam.minchuk.task1.view.PrinterConsole;

/**
 * Class {@code CompanyCreator} creating ITCompany and adding Employees and Teams to the ITCompany
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class CompanyCreator {

    PrinterConsole printConsole = new PrinterConsole();

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

    ProjectManager projectManager1 = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
    ProjectManager projectManager2 = new ProjectManager("Martin", "Thompson", 62, "Game");
    ProjectManager projectManager3 = new ProjectManager("Genry", "Blake", 55, "WebApp");

    public Employee[] createCompany() {
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
            itCompany.addEmployeeToCompany(projectManager3);
            itCompany.removeEmployeeFromCompany(projectManager3);
        } catch (ITCompanyNullPointerException e) {
            e.printStackTrace();
        }
        return itCompany.getEmployees();
    }

    public Team createTeamNumberOne (Employee employees []) throws CompanyCreatorNullPointerException {
        if (employees != null) {
            Team team = new Team();
            try {
                team.setManager((ProjectManager) employees[9]);
                team.addEmployeeToTeam(employees[0]);
                team.addEmployeeToTeam(employees[2]);
                team.addEmployeeToTeam(employees[3]);
                team.addEmployeeToTeam(employees[6]);
            } catch (TeamDataWrongException e) {
                e.printStackTrace();
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            }
            return team;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method \"createTeamNumberOne\" for a null object, employees cannot be null");
        }
    }

    public Team createTeamNumberTwo (Employee employees []) throws CompanyCreatorNullPointerException {
        if (employees != null) {
            Team team = new Team();
            try {
                team.setManager((ProjectManager) employees[10]);
                team.addEmployeeToTeam(employees[1]);
                team.addEmployeeToTeam(employees[4]);
                team.addEmployeeToTeam(employees[5]);
                team.addEmployeeToTeam(employees[7]);
                team.addEmployeeToTeam(employees[8]);
            } catch (TeamDataWrongException e) {
                e.printStackTrace();
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            }
            return team;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method \"createTeamNumberTwo\" for a null object, employees cannot be null");
        }
    }

}
