package tornado.org.kobral.core.api.utils;


public class SButils {

    public static StringBuilder appendArray(StringBuilder sb, int[] arr) {
        for (int i : arr) {
            sb.append(i);
            sb.append(System.getProperty("line.separator"));
        }
        return sb;
    }

    public static StringBuilder announceSortType(StringBuilder sb, String type) {
        sb.append("Sorting by: ");
        sb.append(type);
        sb.append(newline());
        sb.append(newline());
        return sb;
    }

    public static String newline() {
        return System.getProperty("line.separator");
    }

}
