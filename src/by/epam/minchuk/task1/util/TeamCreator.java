package by.epam.minchuk.task1.util;

import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.entity.ProjectManager;
import by.epam.minchuk.task1.model.entity.Team;
import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyDataWrongException;
import by.epam.minchuk.task1.model.exception.technicalexeption.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;
import by.epam.minchuk.task1.model.exception.technicalexeption.TeamNullPointerException;

/**
 * Class {@code TeamCreator} creating Teams
 *
 * @autor Oksana Minchuk
 * @version 1.0 15.03.2019
 */

public class TeamCreator {

    public Team createTeamOne (ITCompany itCompany) throws CompanyCreatorNullPointerException {
        if (itCompany != null) {
            Team itTeam = new Team();
            try {
                itTeam.setManager((ProjectManager) itCompany.getEmployee(10));
                itTeam.addWorker(itCompany.getEmployee(0));
                itTeam.addWorker(itCompany.getEmployee(3));
                itTeam.addWorker(itCompany.getEmployee(6));
                itTeam.addWorker(itCompany.getEmployee(8));
            } catch (ITCompanyDataWrongException e) {
                e.printStackTrace();
            } catch (EmployableNullPointerExeption employableNullPointerExeption) {
                employableNullPointerExeption.printStackTrace();
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            }
            return itTeam;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method for a null object");
        }
    }
    public Team createTeamTwo (ITCompany itCompany) throws CompanyCreatorNullPointerException {
        if (itCompany != null) {
            Team itTeam = new Team();
            try {
                itTeam.setManager((ProjectManager) itCompany.getEmployee(11));
                itTeam.addWorker(itCompany.getEmployee(1));
                itTeam.addWorker(itCompany.getEmployee(4));
                itTeam.addWorker(itCompany.getEmployee(7));
                itTeam.addWorker(itCompany.getEmployee(9));
            } catch (ITCompanyDataWrongException e) {
                e.printStackTrace();
            } catch (EmployableNullPointerExeption employableNullPointerExeption) {
                employableNullPointerExeption.printStackTrace();
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            }
            return itTeam;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method for a null object");
        }
    }
}
