package tornado.org.kobral.sort;

public class Insertion {

    private int[] arr;

    public void sort(int[] arr) {
        this.arr = arr;
        int length = arr.length;
        insertion(this.arr, length);
    }

    private void insertion(int[] arr, int high) {
        for (int i = 1; i < high; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }

}
