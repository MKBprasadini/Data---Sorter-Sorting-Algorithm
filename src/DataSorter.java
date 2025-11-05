/ ===============================
// Member 4 - Data Input, UI, and Comparison
// ===============================

import java.util.*;  

public class DataSorter {
    static Scanner sc = new Scanner(System.in);
    static int[] data = new int[0];

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> manualInput();
                case 2 -> generateRandomData();
                case 3 -> doBubbleSort();
                case 4 -> doMergeSort();
                case 5 -> doQuickSort();
                case 6 -> compareAlgorithms();
                case 7 -> { System.out.println("Goodbye!"); System.exit(0); }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }

    public static void manualInput() {
        sc.nextLine();
        System.out.print("Enter numbers separated by spaces: ");
        String[] input = sc.nextLine().trim().split("\\s+");
        data = new int[input.length];
        for (int i = 0; i < input.length; i++) data[i] = Integer.parseInt(input[i]);
        System.out.println("Data entered successfully: " + Arrays.toString(data));
    }

    public static void generateRandomData() {
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();
        data = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) data[i] = r.nextInt(1000);
        System.out.println("Random data: " + Arrays.toString(data));
    }

    public static void doBubbleSort() {
        SortResult result = Member1_BubbleSort.sort(data);
        System.out.println("Sorted (Bubble Sort): " + Arrays.toString(result.sortedData));
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeTaken, result.steps);
    }

    public static void doMergeSort() {
        SortResult result = Member2_MergeSort.sort(data);
        System.out.println("Sorted (Merge Sort): " + Arrays.toString(result.sortedData));
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeTaken, result.steps);
    }

    public static void doQuickSort() {
        SortResult result = Member3_QuickSort.sort(data);
        System.out.println("Sorted (Quick Sort): " + Arrays.toString(result.sortedData));
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeTaken, result.steps);
    }

    public static void compareAlgorithms() {
    SortResult b = Member1_BubbleSort.sort(data);
    SortResult m = Member2_MergeSort.sort(data);
    SortResult q = Member3_QuickSort.sort(data);

    System.out.println("\n--- Comparison Table ---");
    System.out.printf("%-15s %-15s %-10s%n", "Algorithm", "Time (ms)", "Steps");
    System.out.println("------------------------------------------");
    System.out.printf("%-15s %-15.3f %-10d%n", b.name, b.timeTaken, b.steps);
    System.out.printf("%-15s %-15.3f %-10d%n", m.name, m.timeTaken, m.steps);
    System.out.printf("%-15s %-15.3f %-10d%n", q.name, q.timeTaken, q.steps);
    System.out.println("------------------------------------------");
}
}
