package tornado.org.kobral.search;

public class Binary {

    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length -1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
