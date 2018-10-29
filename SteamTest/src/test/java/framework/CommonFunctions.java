package framework;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctions {

    private static ArrayList<Integer> listValueForRegexp = new ArrayList<>();
    private static int maximumElement;

    public static String getRegexMatch(String text, String regex) {
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(text);
        if(m.find()) return m.group(1);
        return "";
    }

    public static ArrayList<Integer> getListIntegerValueFromTextWithRegex(String text, String regex) {
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(text);
        while (m.find()) {
            listValueForRegexp.add(Integer.parseInt(m.group(1)));
        }
        return listValueForRegexp;
    }

    public static void findMaxValueList(List<Integer> list) {
        maximumElement = list.get(0);
        for (Integer value: list
             ) {
            if(value> maximumElement){
                maximumElement = value;
            }
        }
    }

    public static String getMaximumElement() {
        return String.valueOf(maximumElement);
    }
}
