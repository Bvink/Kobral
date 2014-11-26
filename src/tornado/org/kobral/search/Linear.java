package tornado.org.kobral.search;

public class Linear {

    public static boolean search(int[] arr, int rnd) {
        for (int i : arr) {
            if (i == rnd) {
                return true;
            }
        }
        return false;
    }
}
