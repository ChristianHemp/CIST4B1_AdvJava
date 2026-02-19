public class Week3 {
    public static void main(String[] args) {

        int[] arr = {2, 8, 5, 3, 1, 4, 6, 7, 9};


        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        insertionSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++)
                if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        // start at index 0 and move to sorted portion
        // move next index into sorted side and put it in sorted order

        for(int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            while(j >= 0 && (arr[j] > current)) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }
}
