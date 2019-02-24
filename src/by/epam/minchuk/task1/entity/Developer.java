package by.epam.minchuk.task1.entity;

public class Developer extends Engineer {

    public enum DeveloperType {
        FRONT_END, BACK_END
    }

    private DeveloperType developerType;
    private String skill;

    public Developer() {
    }

    public Developer(DeveloperType developerType, String skill) {
        this.developerType = developerType;
        this.skill = skill;
    }

    public Developer(String name, String surname, int salaryPerHour, EngineerLevelType levelType, DeveloperType developerType, String skill) {
        super(name, surname, salaryPerHour, levelType);
        this.developerType = developerType;
        this.skill = skill;
    }

    public DeveloperType getDeveloperType() {
        return developerType;
    }

    public void setDeveloperType(DeveloperType developerType) {
        this.developerType = developerType;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        if (developerType != developer.developerType) return false;
        return skill.equals(developer.skill);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + developerType.hashCode();
        result = 31 * result + skill.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Developer {" + super.toString() +
                ", developerType=" + developerType +
                ", skill='" + skill + '\''
                 + "}";
    }
}
