// ===============================
// Member 3 - Quick Sort Algorithm
// ===============================

class Member3_QuickSort {
    static int steps;

    public static SortResult sort(int[] arr) {
        int[] data = arr.clone();
        steps = 0;
        long start = System.nanoTime();
        quickSort(data, 0, data.length - 1);
        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;
        return new SortResult("Quick Sort", data, time, steps);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = {15, 3, 9, 8, 5, 2};
        SortResult result = sort(data);
        System.out.println("Sorted Data (Quick Sort): " + java.util.Arrays.toString(result.sortedData));
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeTaken, result.steps);
    }
}