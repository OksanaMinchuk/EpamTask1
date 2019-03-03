package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.entity.creator.TypeEmployee;
import by.epam.minchuk.task1.model.exception.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.logic.finder.Finder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FinderTest {

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
    public void testPositiveFindAllEmployeeBySurname() throws FinderNullPointerException {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        expectedEmployees.add(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        Assert.assertEquals(expectedEmployees.get(0), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(0));
        Assert.assertEquals(expectedEmployees.get(1), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(1));
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindAllEmployeeBySurname() throws FinderNullPointerException {
        actualEmployees = null;
        Finder.findAllEmployeeBySurname(actualEmployees, "Conor");
    }

    @Test
    public void testPositiveFindEmployeeByMaxSalary() throws FinderNullPointerException {
        int maxSalary = Finder.findMaxSalary(actualEmployees);
        Employee actualEmployee = Finder.findEmployeeByMaxSalary(actualEmployees, maxSalary);
        Employee expectedEmployee = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByMaxSalaryWrongEmployee() throws FinderNullPointerException {
        int maxSalary = Finder.findMaxSalary(actualEmployees);
        actualEmployees = null;
        Finder.findEmployeeByMaxSalary(actualEmployees, maxSalary);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByMaxSalaryWrongSalary() throws FinderNullPointerException {
        Finder.findEmployeeByMaxSalary(actualEmployees, -5);
    }

    @Test
    public void testPositiveFindMaxSalary() throws FinderNullPointerException {
        int actualMaxSalary = Finder.findMaxSalary(actualEmployees);
        int excpectedMaxSalary = 60;
        Assert.assertEquals(excpectedMaxSalary, actualMaxSalary);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindMaxSalary() throws FinderNullPointerException {
        actualEmployees = null;
        Finder.findMaxSalary(actualEmployees);
    }

    @Test
    public void testFindEmployeeByType() throws FinderNullPointerException {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        expectedEmployees.add(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        Assert.assertEquals(expectedEmployees.get(0), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(0));
        Assert.assertEquals(expectedEmployees.get(1), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(1));
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByType() throws FinderNullPointerException {
        actualEmployees = null;
        Finder.findAllEmployeeBySurname(actualEmployees, "Conor");
    }
}
