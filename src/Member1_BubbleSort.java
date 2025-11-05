// ===============================
// Member 1 - Bubble Sort
// ===============================

// BubbleSort.java
import java.util.Arrays;

public class Member1_BubbleSort {
    public static SortResult sort(int[] arr) {
        int[] data = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        int steps = 0;
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();
        double timeTaken = (end - start) / 1_000_000.0;
        return new SortResult("Bubble Sort", data, timeTaken, steps);
    }
}
