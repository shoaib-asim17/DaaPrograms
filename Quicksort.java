public class Quicksort {

    // Partition method to rearrange the elements based on pivot
    public int partition(int a[], int low, int high) {
        int pivot = a[low];  // Pivot element is chosen as the first element
        int i = low + 1;     // Start from the element right after the pivot
        int j = high;        // Start from the last element

        do {
            while (i <= j && a[i] <= pivot) {
                i++;  // Move right until an element greater than the pivot is found
            }
            while (i <= j && a[j] > pivot) {
                j--;  // Move left until an element smaller than or equal to the pivot is found
            }
            if (i < j) {
                // Swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        } while (i < j);  // Continue until i and j cross

        // Swap pivot element with a[j] to place it in the correct position
        int temp = a[low];
        a[low] = a[j];
        a[j] = temp;

        return j;  // Return the partition index
    }

    // Quicksort method to recursively sort the array
    public void sort(int a[], int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);  // Partition the array
            sort(a, low, pi - 1);              // Recursively sort the left partition
            sort(a, pi + 1, high);             // Recursively sort the right partition
        }
    }

    // Utility method to print the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to execute the Quicksort algorithm
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        Quicksort ab = new Quicksort();
        ab.sort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
