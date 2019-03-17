package by.epam.minchuk.task1.util.localizationConst;

import java.util.Locale;
import java.util.ResourceBundle;

public class EmployeeConstant {

    private static ResourceBundle bundle;
    private static Locale locale;

    static {
        changeLocale(Locale.getDefault());
    }

    public static String NAME;
    public static String SURNAME;
    public static String SALARY_PER_HOUR;

    public static void changeLocale (Locale locale) {
        bundle = ResourceBundle.getBundle("localization.l10n", locale);
        NAME = bundle.getString("name");
        SURNAME = bundle.getString("surname");
        SALARY_PER_HOUR = bundle.getString("salaryPerHour");
    }
}
