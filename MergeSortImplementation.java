import java.util.Random;

public class MergeSortImplementation {
    static void mergeSort(int[] arr) {

        // Base case array of length 1 is already sorted with itself
        if(arr.length <= 1) {
            return;
        }

        // Finds middle value (integer division rounds down)
        int middle = arr.length / 2;

        // Initialize two integer arrays left and right with correct sizes
        int[] left = new int[middle];
        // arr.length - middle ensures handling in case the array length is odd
        int[] right = new int[arr.length - middle];


        for(int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }

        for(int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    static void merge(int[] arr, int[] left, int[] right) {
        // Initialize counter/indexing ints
        int i = 0;
        int j = 0;
        int z = 0;

        // Loop that sorts the integers back into the loop based on which is larger
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[z] = left[i];
                z += 1;
                i += 1;
            }
            else {
                arr[z] = right[j];
                z += 1;
                j += 1;
            }
        }

        // These two while loops catch the possibility that the arrays are different length
        // The previous loop condition will evaluate false if one is empty, but there might still be values to be sorted
        while(i < left.length) {
            arr[z] = left[i];
            z += 1;
            i += 1;
        }

        while(j < right.length) {
            arr[z] = right[j];
            z += 1;
            j += 1;
        }
    }

    // Simple method to generate a random array of size int size
    static int[] generateArr(int size) {
        Random random = new Random();

        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        return arr;
    }

    // Simple method to generate a descending array "worst" case
    static int[] generateWorstArr(int size) {
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        return arr;
    }

    public static void main(String[] args) {

        // modify array sizes here to test time complexity
        int[] arr = generateArr(10000);
        int[] worstArr = generateWorstArr(10000);

        // Using nanotime to calculate runtime for testing
        long startTime = System.nanoTime();

        mergeSort(worstArr);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("The worst array took " + totalTime + " ns to merge sort");

        startTime = System.nanoTime();

        mergeSort(arr);

        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("The average array took " + totalTime + " ns to merge sort");

        for(int element : arr) {
            System.out.print(element + ", ");
        }

        System.out.println();
        for(int element : worstArr) {
            System.out.print(element + ", ");
        }
    }
}
