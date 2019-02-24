package by.epam.minchuk.task1.entity;

public class Tester extends Engineer {

    public enum TesterType {
        AUTOMATION, MANUAL
    }

    private TesterType testerType;

    public Tester() {
    }

    public Tester(String name, String surname, int salaryPerHour, EngineerLevelType level, TesterType testerType) {
        super(name, surname, salaryPerHour, level);
        this.testerType = testerType;
    }

    public TesterType getTesterType() {
        return testerType;
    }

    public void setTesterType(TesterType testerType) {
        this.testerType = testerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tester tester = (Tester) o;

        return testerType == tester.testerType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + testerType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tester {" + super.toString() +
                ", testerType=" + testerType + "}";
    }
}
