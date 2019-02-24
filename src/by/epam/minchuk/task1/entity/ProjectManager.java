package by.epam.minchuk.task1.entity;

/**
 * Class {@code ProjectManager} is a subclass of Employee
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ProjectManager extends Employee {

    private String project;

    public ProjectManager() {
    }

    public ProjectManager(String name, String surname, int salaryPerHour, String project) {
        super(name, surname, salaryPerHour);
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProjectManager that = (ProjectManager) o;

        return project.equals(that.project);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + project.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProjectManager {" + super.toString() +
                "project='" + project + '\'' + "}";
    }
}
