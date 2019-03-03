package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.exception.SorterNullPointerException;
import by.epam.minchuk.task1.model.logic.sorter.Sorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {

    Employee [] actualEmployees;

    @Before
    public void init() throws ITCompanyNullPointerException {
        ITCompany itCompany = new ITCompany();

        itCompany.addEmployeeToCompany(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        itCompany.addEmployeeToCompany(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        itCompany.addEmployeeToCompany(new Tester("Tom", "Gibbs", 25,
                Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL));
        itCompany.addEmployeeToCompany(new ProjectManager("Scott", "Johnson", 60, "Online-Store"));

        actualEmployees = itCompany.getEmployees();
    }

    @Test
    public void testPositiveSortBySalary() throws SorterNullPointerException {
        Employee [] expectedEmployees = {
                new Tester("Tom", "Gibbs", 25,
                        Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL),
                new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "C++"),
                new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "Java"),
                new ProjectManager("Scott", "Johnson", 60, "Online-Store")
        };
        Sorter.sortBySalary(actualEmployees);
        Assert.assertArrayEquals(expectedEmployees, actualEmployees);
    }

    @Test(expected = SorterNullPointerException.class)
    public void testExceptionSortBySalary() throws SorterNullPointerException {
        actualEmployees = null;
        Sorter.sortBySalary(actualEmployees);
    }

    @Test
    public void testPositiveSortBySurnameAndSalary() throws SorterNullPointerException {
        Employee [] expectedEmployees = {
                new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "C++"),
                new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "Java"),
                new Tester("Tom", "Gibbs", 25,
                        Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL),
                new ProjectManager("Scott", "Johnson", 60, "Online-Store")
        };
        Sorter.sortBySurnameAndSalary(actualEmployees);
        Assert.assertArrayEquals(expectedEmployees, actualEmployees);
    }

    @Test(expected = SorterNullPointerException.class)
    public void testExceptionSortBySurnameAndSalary() throws SorterNullPointerException {
        actualEmployees = null;
        Sorter.sortBySurnameAndSalary(actualEmployees);
    }


}
