// It is related to quick sort algorithm and is one of the tools you'll need in a divide and conquer question.
// The main jist of the algorithm is that it sorts up to your requirements as if it acts as a interpreter rather than a compiler.
// Further details : https://www.geeksforgeeks.org/quickselect-algorithm/
public static int partition(int[] arr,int low, int high) {
    int pivot = arr[high], pivotloc = low;
    for (int i = low; i <= high; i++) {
        // inserting elements of less value
        // to the left of the pivot location
        if (arr[i] < pivot) {
            int temp = arr[i];
            arr[i] = arr[pivotloc];
            arr[pivotloc] = temp;
            pivotloc++;
        }
    }

    // swapping pivot to the final pivot location
    int temp = arr[high];
    arr[high] = arr[pivotloc];
    arr[pivotloc] = temp;

    return pivotloc;
}
