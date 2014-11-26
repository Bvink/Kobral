package tornado.org.kobral.sort;

public class Merge {
    private int[] arr;
    private int[] temparr;

    public void sort(int[] arr) {
        this.arr = arr;
        int length = arr.length;
        this.temparr = new int[length];
        split(0, length - 1);
    }

    private void split(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            split(low, middle);
            split(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            temparr[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (temparr[i] <= temparr[j]) {
                arr[k] = temparr[i];
                i++;
            } else {
                arr[k] = temparr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = temparr[i];
            k++;
            i++;
        }

    }
}