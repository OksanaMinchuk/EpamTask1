package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FinderTest {

    Employee[] actualEmployees;

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

        actualEmployees = itCompany.getEmployeesArray();
    }

    @Test
    public void testPositiveFindAllEmployeeBySurname() throws FinderNullPointerException, FinderEmployeeNotFoundException {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        expectedEmployees.add(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        Assert.assertEquals(expectedEmployees.get(0), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(0));
        Assert.assertEquals(expectedEmployees.get(1), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(1));
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindAllEmployeeBySurname() throws FinderNullPointerException, FinderEmployeeNotFoundException {
        actualEmployees = null;
        Finder.findAllEmployeeBySurname(actualEmployees, "Conor");
    }

    @Test
    public void testPositiveFindEmployeeByMaxSalary() throws FinderNullPointerException {
        double maxSalary = Finder.findMaxSalary(actualEmployees);
        Employee actualEmployee = Finder.findEmployeeByMaxSalary(actualEmployees, maxSalary);
        Employee expectedEmployee = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByMaxSalaryWrongEmployee() throws FinderNullPointerException {
        double maxSalary = Finder.findMaxSalary(actualEmployees);
        actualEmployees = null;
        Finder.findEmployeeByMaxSalary(actualEmployees, maxSalary);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByMaxSalaryWrongSalary() throws FinderNullPointerException {
        Finder.findEmployeeByMaxSalary(actualEmployees, -5);
    }

    @Test
    public void testPositiveFindMaxSalary() throws FinderNullPointerException {
        double actualMaxSalary = Finder.findMaxSalary(actualEmployees);
        double excpectedMaxSalary = 60;
        double delta = 0.01;
        Assert.assertEquals(excpectedMaxSalary, actualMaxSalary, delta);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindMaxSalary() throws FinderNullPointerException {
        actualEmployees = null;
        Finder.findMaxSalary(actualEmployees);
    }

    @Test
    public void testFindEmployeeByType() throws FinderNullPointerException, FinderEmployeeNotFoundException {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        expectedEmployees.add(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        Assert.assertEquals(expectedEmployees.get(0), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(0));
        Assert.assertEquals(expectedEmployees.get(1), Finder.findAllEmployeeBySurname(actualEmployees, "Conor").get(1));
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByType() throws FinderNullPointerException, FinderEmployeeNotFoundException {
        actualEmployees = null;
        Finder.findAllEmployeeBySurname(actualEmployees, "Conor");
    }
}
