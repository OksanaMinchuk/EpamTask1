package by.epam.minchuk.task1.model.entity;


import by.epam.minchuk.task1.model.exception.TeamDataWrongException;
import by.epam.minchuk.task1.model.exception.TeamNullPointerException;

public class Team {
    private ProjectManager manager;
    private Developer backEndDeveloper;
    private Developer frontEndDeveloper;
    private Tester manualTester;
    private Tester automationTester;

    public Team() {
    }

    public Team(ProjectManager manager, Developer backEndDeveloper, Developer frontEndDeveloper, Tester manualTester, Tester automationTester) {
        this.manager = manager;
        this.backEndDeveloper = backEndDeveloper;
        this.frontEndDeveloper = frontEndDeveloper;
        this.manualTester = manualTester;
        this.automationTester = automationTester;
    }

    public Team(Team team) {
        this.manager = team.manager;
        this.backEndDeveloper = team.backEndDeveloper;
        this.frontEndDeveloper = team.frontEndDeveloper;
        this.manualTester = team.manualTester;
        this.automationTester = team.automationTester;
    }

    public ProjectManager getManager() {
        return manager;
    }

    public void setManager(ProjectManager manager) throws TeamNullPointerException {
        if (manager != null) {
            this.manager = manager;
        } else {
            throw new TeamNullPointerException("Wrong manager value, manager cannot be null");
        }
    }

    public Developer getBackEndDeveloper() {
        return backEndDeveloper;
    }

    public void setBackEndDeveloper(Developer backEndDeveloper) throws TeamDataWrongException {
        if (backEndDeveloper !=null && backEndDeveloper.getDeveloperType().equals(Developer.DeveloperType.BACK_END)) {
            this.backEndDeveloper = backEndDeveloper;
        } else {
            throw new TeamDataWrongException("Wrong backEndDeveloper value");
        }
    }

    public Developer getFrontEndDeveloper() {
        return frontEndDeveloper;
    }

    public void setFrontEndDeveloper(Developer frontEndDeveloper) throws TeamDataWrongException {
        if (frontEndDeveloper != null && frontEndDeveloper.getDeveloperType().equals(Developer.DeveloperType.FRONT_END)) {
            this.frontEndDeveloper = frontEndDeveloper;
        } else {
            throw new TeamDataWrongException("Wrong frontEndDeveloper value");
        }
    }

    public Tester getManualTester() {
        return manualTester;
    }

    public void setManualTester(Tester manualTester) throws TeamDataWrongException {
        if (manualTester != null && manualTester.getTesterType().equals(Tester.TesterType.MANUAL)) {
            this.manualTester = manualTester;
        } else {
            throw new TeamDataWrongException("Wrong manualTester value");
        }
    }

    public Tester getAutomationTester() {
        return automationTester;
    }

    public void setAutomationTester(Tester automationTester) throws TeamDataWrongException {
        if (automationTester != null && automationTester.getTesterType().equals(Tester.TesterType.AUTOMATION)) {
            this.automationTester = automationTester;
        } else {
            throw new TeamDataWrongException("Wrong automationTester value");
        }
    }

    public double getTeamPrice() throws TeamNullPointerException {
        return manager.getSalaryPerHour() + backEndDeveloper.getSalaryPerHour() + frontEndDeveloper.getSalaryPerHour()
                + manualTester.getSalaryPerHour() + automationTester.getSalaryPerHour();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!manager.equals(team.manager)) return false;
        if (!backEndDeveloper.equals(team.backEndDeveloper)) return false;
        if (!frontEndDeveloper.equals(team.frontEndDeveloper)) return false;
        if (!manualTester.equals(team.manualTester)) return false;
        return automationTester.equals(team.automationTester);
    }

    @Override
    public int hashCode() {
        int result = manager.hashCode();
        result = 31 * result + backEndDeveloper.hashCode();
        result = 31 * result + frontEndDeveloper.hashCode();
        result = 31 * result + manualTester.hashCode();
        result = 31 * result + automationTester.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Team on project " + manager.getProject() + " { " +
                "\nmanager=" + manager +
                "\nbackEndDeveloper=" + backEndDeveloper +
                "\nfrontEndDeveloper=" + frontEndDeveloper +
                "\nmanualTester=" + manualTester +
                "\nautomationTester=" + automationTester +
                '}';
    }
}
