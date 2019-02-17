package by.epam.minchuk.task1.entity;

import by.epam.minchuk.task1.logic.CompanyCreator;

public class Company {

    private Employee employees[] = new Employee[0];

    Developer developer1 = new Developer("John", "Conor", 50, EngineerLevelType.MIDDLE,
            DeveloperType.BACK_END, "Java");
    Developer developer2 = new Developer("Donald", "Freeman", 46, EngineerLevelType.MIDDLE,
            DeveloperType.BACK_END, "C++");
    Developer developer3 = new Developer("Jack", "Gilbert", 52, EngineerLevelType.SENIOR,
            DeveloperType.FRONT_END, "HTML");
    Developer developer4 = new Developer("Jack", "Harrison", 37, EngineerLevelType.JUNIOR,
            DeveloperType.FRONT_END, "CSS");
    Developer developer5 = new Developer("Carroll", "Anderson", 48, EngineerLevelType.SENIOR,
            DeveloperType.FRONT_END, "JavaScript");
    Developer developer6 = new Developer("Cris", "Norman", 42, EngineerLevelType.MIDDLE,
            DeveloperType.BACK_END, "Python");

    Tester tester1 = new Tester("Tom", "Gibbs", 25, EngineerLevelType.JUNIOR, TesterType.MANUAL);
    Tester tester2 = new Tester("Hailey", "Conor", 34, EngineerLevelType.SENIOR, TesterType.AUTOMATION);
    Tester tester3 = new Tester("Oliver", "Watson", 31, EngineerLevelType.MIDDLE, TesterType.AUTOMATION);

    ProjectManager projectManager1 = new ProjectManager("Scott","Johnson",60, "Online-Store");
    ProjectManager projectManager2 = new ProjectManager("Martin","Thompson",62, "Game");

    CompanyCreator companyCreator = new CompanyCreator();

    public void main(String[] args) {

        companyCreator.addEmployee(employees, developer1);
    }



}
