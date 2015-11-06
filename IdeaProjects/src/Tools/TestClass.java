package Tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EugeneBerezan on 11/5/15.
 */
public class TestClass {

    public static String getMonth(String monthName) {

        Map<String, String> month = new HashMap<>();

        month.put("Январь", "01");
        month.put("Февраль", "02");
        month.put("Март", "03");
        month.put("Апрель", "04");
        month.put("Май", "05");
        month.put("Июнь", "06");
        month.put("Июль", "07");
        month.put("Август", "08");
        month.put("Сентябрь", "09");
        month.put("Октябрь", "10");
        month.put("Ноябрь", "11");
        month.put("Декабрь", "12");

        return month.get(monthName);
    }

    public static void main(String[] args) {

        System.out.println(getMonth("Ноябрь"));

    }

}
