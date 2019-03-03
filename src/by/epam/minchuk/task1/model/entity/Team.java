package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.TeamDataWrongException;
import by.epam.minchuk.task1.model.exception.TeamNullPointerException;

import java.util.ArrayList;
import java.util.List;



public class Team {
    private ProjectManager manager;
    private List<Employee> teamEmployees;

    public Team() {
        teamEmployees = new ArrayList<>();
    }

    public Team(ProjectManager manager, List<Employee> teamEmployees) {
        this.manager = manager;
        this.teamEmployees = teamEmployees;
    }

    public ProjectManager getManager() {
        return manager;
    }

    public void setManager(ProjectManager manager) throws TeamDataWrongException {
        if (manager != null) {
            this.manager = manager;
        } else {
            throw new TeamDataWrongException("Wrong employee value");
        }
    }

    public List<Employee> getTeamEmployees() {
        return teamEmployees;
    }

    public void addEmployeeToTeam(Employee employee) throws TeamNullPointerException {
        if (employee != null) {
            teamEmployees.add(employee);
        } else {
            throw new TeamNullPointerException("Invoking a method \"addEmployeeToTeam\" for a null object, employee can not be null");
        }
    }

    public void removeEmployeeFromTeam(Employee employee) throws TeamNullPointerException {
        if (employee != null) {
            teamEmployees.remove(employee);
        } else {
            throw new TeamNullPointerException("Invoking a method \"removeEmployeeFromTeam\" for a null object, employee can not be null");
        }
    }

    public int getTeamPrice(ProjectManager manager, List<Employee> teamEmployees) throws TeamNullPointerException {
        if (manager != null && teamEmployees != null) {
            if (!teamEmployees.isEmpty()) {
                int price = manager.getSalaryPerHour();
                for (Employee employee : teamEmployees) {
                    price += employee.getSalaryPerHour();
                }
                return price;
            } else {
                throw new TeamNullPointerException("teamEmployees is empty");
            }
        } else {
            throw new TeamNullPointerException("Invoking a method \"getTeamPrice\" for a null object");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;
        if (!manager.equals(team.manager)) return false;
        return teamEmployees.equals(team.teamEmployees);
    }

    @Override
    public int hashCode() {
        int result = manager.hashCode();
        result = 31 * result + teamEmployees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Team" + manager.getProject() + "\n");
        builder.append(manager).append("\n");
        for (Employee employee: teamEmployees) {
            builder.append(employee).append("\n");
        }
        return builder + "";
    }

}
