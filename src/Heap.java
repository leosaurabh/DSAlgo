public class Heap {

    int val;
    Heap left;
    Heap right;

    Heap(int val) {
        this.val = val;
    }

    void sort(Integer[] arr) {
        int length = arr.length;
        int lastParent = (length - 1)/2;

        while(lastParent >= 0) {
            heapify(arr, length, lastParent);
            lastParent--;
        }
    }

    int extract(Integer[] arr, int n) {
        int max = arr[0];
        arr[0] = arr[n-1];
        arr[n-1] = null;
        heapify(arr, n, 0);
        return 0;
    }

    // max heap
    void heapify(Integer[] arr, int n, int i) {
        int child1 = 2*i + 1;
        int child2 = 2*i + 2;

        int largest = i;
        if (child1 < n && arr[child1] != null && arr[child1] > arr[i]) {
            largest = child1;
        }

        if (child2 < n && arr[child2] != null && arr[child2] > arr[largest]) {
            largest = child2;
        }

        if (largest != i) {
            arr[i] = arr[i] ^ arr[largest];
            arr[largest] = arr[i] ^ arr[largest];
            arr[i] = arr[i] ^ arr[largest];
            heapify(arr, n, largest);
        }
    }
}
