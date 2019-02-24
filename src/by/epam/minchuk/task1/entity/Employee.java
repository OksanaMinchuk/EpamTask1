package by.epam.minchuk.task1.entity;

import by.epam.minchuk.task1.exception.MyIncorrectDataException;

/**
 * Class {@code Employee} is a superclass for all emloyees of IT-Company
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
*/


public class Employee {

    private String name;
    private String surname;
    private int salaryPerHour;

    public Employee() {
    }

    public Employee(String name, String surname, int salaryPerHour) {
        if (name != null && name != "" && surname != null && surname != "" && salaryPerHour > 0) {
            this.name = name;
            this.surname = surname;
            this.salaryPerHour = salaryPerHour;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws MyIncorrectDataException {
        if (name != null && name != "") {
            this.name = name;
        } throw new MyIncorrectDataException("Incorrect name value");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws MyIncorrectDataException {
        if (surname != null && surname != "") {
            this.surname = surname;
        } throw new MyIncorrectDataException("Incorrect surname value");
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) throws MyIncorrectDataException {
        if (salaryPerHour > 0) {
            this.salaryPerHour = salaryPerHour;
        } else throw new MyIncorrectDataException("Incorrect salaryPerHour value");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (salaryPerHour != employee.salaryPerHour) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return surname != null ? surname.equals(employee.surname) : employee.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + salaryPerHour;
        return result;
    }

    @Override
    public String toString() {
        return  " name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salaryPerHour=" + salaryPerHour + ", ";
    }
}
