package by.epam.minchuk.task1.util;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.*;

/**
 * Class {@code CompanyCreator} creating ITCompany and adding Employees and Teams to the ITCompany
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class CompanyCreator {

    private static Developer developer1 = new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Java");
    private static Developer developer2 = new Developer("Donald", "Freeman", 46, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "C++");
    private static Developer developer3 = new Developer("Cris", "Norman", 42, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Python");
    private static Developer developer4 = new Developer("Jack", "Gilbert", 52, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "HTML");
    private static Developer developer5 = new Developer("Jack", "Harrison", 37, Engineer.EngineerLevelType.JUNIOR,
            Developer.DeveloperType.FRONT_END, "CSS");
    private static Developer developer6 = new Developer("Carroll", "Anderson", 48, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "JavaScript");

    private static Tester tester1 = new Tester("Alex", "Miller", 30,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.MANUAL);
    private static Tester tester2 = new Tester("Tom", "Gibbs", 25,
            Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL);
    private static Tester tester3 = new Tester("Hailey", "Conor", 34,
            Tester.EngineerLevelType.SENIOR, Tester.TesterType.AUTOMATION);
    private static Tester tester4 = new Tester("Oliver", "Watson", 31,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.AUTOMATION);

    private static ProjectManager projectManager1 = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
    private static ProjectManager projectManager2 = new ProjectManager("Martin", "Thompson", 62, "Game");
    private static ProjectManager projectManager3 = new ProjectManager("Genry", "Blake", 55, "WebApp");

    public static Employee[] createCompany() {
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


    public static Team createTeamNumberOne (ITCompany itCompany) throws CompanyCreatorNullPointerException {
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

    public static Team createTeamNumberTwo(ITCompany itCompany) throws CompanyCreatorNullPointerException {
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
