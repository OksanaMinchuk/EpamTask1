package by.epam.minchuk.task1.util;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyDataWrongException;
import by.epam.minchuk.task1.model.exception.logicexception.TeamDataWrongException;
import by.epam.minchuk.task1.model.exception.technicalexeption.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.TeamNullPointerException;

/**
 * Class {@code CompanyCreator} creating ITCompany and adding Employees and Teams to the ITCompany
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class CompanyCreator {

    private Developer developer1 = new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Java");
    private Developer developer2 = new Developer("Donald", "Freeman", 46, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "C++");
    private Developer developer3 = new Developer("Cris", "Norman", 42, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Python");
    private Developer developer4 = new Developer("Jack", "Gilbert", 52, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "HTML");
    private Developer developer5 = new Developer("Jack", "Harrison", 37, Engineer.EngineerLevelType.JUNIOR,
            Developer.DeveloperType.FRONT_END, "CSS");
    private Developer developer6 = new Developer("Carroll", "Anderson", 48, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "JavaScript");

    private Tester tester1 = new Tester("Alex", "Miller", 30,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.MANUAL);
    private Tester tester2 = new Tester("Tom", "Gibbs", 25,
            Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL);
    private Tester tester3 = new Tester("Hailey", "Conor", 34,
            Tester.EngineerLevelType.SENIOR, Tester.TesterType.AUTOMATION);
    private Tester tester4 = new Tester("Oliver", "Watson", 31,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.AUTOMATION);

    private ProjectManager projectManager1 = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
    private ProjectManager projectManager2 = new ProjectManager("Martin", "Thompson", 62, "Game");
    private ProjectManager projectManager3 = new ProjectManager("Genry", "Blake", 55, "WebApp");

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
            itCompany.addEmployeeToCompany(tester4);
            itCompany.addEmployeeToCompany(projectManager1);
            itCompany.addEmployeeToCompany(projectManager2);
            itCompany.addEmployeeToCompany(projectManager3);
            itCompany.removeEmployeeFromCompany(projectManager3);
        } catch (ITCompanyNullPointerException e) {
            e.printStackTrace();
        }
        return itCompany.getEmployeesArray();
    }


    public Team createTeamNumberOne (ITCompany itCompany) throws CompanyCreatorNullPointerException {
        if (itCompany != null) {
            Team team = new Team();
            try {
                team.setManager((ProjectManager) itCompany.getEmployee(10));
                team.setBackEndDeveloper((Developer) itCompany.getEmployee(0));
                team.setFrontEndDeveloper((Developer) itCompany.getEmployee(3));
                team.setManualTester((Tester) itCompany.getEmployee(6));
                team.setAutomationTester((Tester) itCompany.getEmployee(8));
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            } catch (ITCompanyDataWrongException e) {
                e.printStackTrace();
            } catch (TeamDataWrongException e) {
                e.printStackTrace();
            }
            return team;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method \"createTeamNumberOne\" for a null object");
        }
    }

    public Team createTeamNumberTwo(ITCompany itCompany) throws CompanyCreatorNullPointerException {
        if (itCompany != null) {
            Team team = new Team();
            try {
                team.setManager((ProjectManager) itCompany.getEmployee(11));
                team.setBackEndDeveloper((Developer) itCompany.getEmployee(1));
                team.setFrontEndDeveloper((Developer) itCompany.getEmployee(4));
                team.setManualTester((Tester) itCompany.getEmployee(7));
                team.setAutomationTester((Tester) itCompany.getEmployee(9));
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            } catch (ITCompanyDataWrongException e) {
                e.printStackTrace();
            } catch (TeamDataWrongException e) {
                e.printStackTrace();
            }
            return team;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method \"createTeamNumberOne\" for a null object");
        }
    }

}
