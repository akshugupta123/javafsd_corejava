package bubblesort;

public class bubbleSort {

	public static void main(String[] args) {
        int[] array = {5, 9, 3, 1, 7}; // Predefined array

        // Sorting the array using bubble sort
        bubbleSort(array);

        // Checking if an element is present in the array
        int elementToFind = 7;
        boolean isPresent = findElement(array, elementToFind);

        // Printing the sorted array
        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Printing the result of element search
        if (isPresent) {
            System.out.println(elementToFind + " is present in the array.");
        } else {
            System.out.println(elementToFind + " is not present in the array.");
        }
    }

    // Bubble sort algorithm implementation
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Element search in the array
    public static boolean findElement(int[] array, int element) {
        for (int num : array) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }
}