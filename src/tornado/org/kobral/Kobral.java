package tornado.org.kobral;

import tornado.org.kobral.core.api.utils.SButils;
import tornado.org.kobral.search.Binary;
import tornado.org.kobral.search.Linear;
import tornado.org.kobral.sort.Insertion;
import tornado.org.kobral.sort.Merge;

import javax.swing.*;
import java.util.Random;

class Kobral {

    private static final int TIMES_TO_RUN = Integer.parseInt(JOptionPane.showInputDialog("Times to run:"));
    private static final int SIZE = Integer.parseInt(JOptionPane.showInputDialog("Size of array:"));
    private static final int EXTRA = Integer.parseInt(JOptionPane.showInputDialog("Extra values:"));
    private static final int VALUE_TO_FIND = Integer.parseInt(JOptionPane.showInputDialog("Binary search value to find:"));
    private static final String SORT_TYPE = JOptionPane.showInputDialog("sort type:");

    public static void main(String[] args) throws Exception {
        for (int x = 0; x < TIMES_TO_RUN; x++) {
            int[] arr = (SIZE > 0) ? new int[SIZE] : new int[-SIZE];
            arr = populateArray(arr);
            StringBuilder sb = new StringBuilder();

            sb = SButils.appendArray(sb, arr);
            sb.append(SButils.newline());

            sb = SButils.announceSortType(sb, SORT_TYPE);

            switch (SORT_TYPE.toLowerCase()) {
                case "insertion":
                    Insertion insertion = new Insertion();
                    insertion.sort(arr);
                    break;
                case "merge":
                    Merge merge = new Merge();
                    merge.sort(arr);
                    break;
                default:
                    sb.append("ERROR!");
                    sb.append(SButils.newline());
                    sb.append(SButils.newline());
                    break;
            }

            sb = SButils.appendArray(sb, arr);
            sb.append(SButils.newline());
            sb.append("Index ");

            int result = Binary.search(arr, VALUE_TO_FIND);

            sb.append(result == -1 ? "was not found" : result);

            sb.append(SButils.newline());
            sb.append(SButils.newline());

            System.out.println(sb);
        }
    }

    private static int[] populateArray(int[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i] = recurse(s, 0);
        }
        return s;
    }

    private static int recurse(int[] arr, int count) {
        Random rand = new Random();
        int rnd = (EXTRA > 0) ? rand.nextInt(SIZE + EXTRA) + 1 : rand.nextInt(SIZE - EXTRA) + 1;
        if (!Linear.search(arr, rnd)) {
            return rnd;
        }
        return (count < SIZE) ? recurse(arr, count++) : -1;
    }

}
