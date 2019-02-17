package by.epam.minchuk.task1.entity;

public class Engineer extends Employee{

    private EngineerLevelType level;

    public Engineer() {
    }

    public Engineer(String name, String surname, int salaryPerHour, EngineerLevelType levelType) {
        super(name, surname, salaryPerHour);
        this.level = levelType;
    }

    public EngineerLevelType getLevel() {
        return level;
    }

    public void setLevel(EngineerLevelType level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Engineer engineer = (Engineer) o;

        return level == engineer.level;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  ", level=" + level + super.toString();
    }
}
