import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }
    public MaxHeap() {
        data = new Integer[0];
        size = 0;
    }

    // to be implemented in O(NlogN)
    public void MaxHeapNLogN(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {

        this.data = Arrays.copyOf(data, data.length);
        this.size = data.length;
        int lastParent = (size - 2) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapDown(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {

        if (size >= data.length) {
            return false;
        }
        data[size] = item;
        size++;
        heapUp(size - 1);

        return true;
    }

    // return the max item in the heap
    public Integer get() {
        if (size <= 0) {
            return null;
        }
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        if (size <= 0) {
            return null;
        }
        int max = data[0];
        data[0] = data[size - 1];
        heapDown(0);
        size--;
        return max;
    }

    private void heapUp(int n) {

        if (n == 0) {
            return;
        }
        Integer parent = (n - 1) / 2;
        // when child node is larger than the parent
        if (data[n] > data[parent]) {
            //Swap
            Swap(n, parent);
            heapUp(parent);
        }

    }

    private void heapDown(int n) {

        if (n == size){
            return;
        }

        Integer left = 2 * n + 1;
        Integer right = 2 * n + 2;
        if (right <= size - 1) {
            //Compare parent with left child
            if (data[n] < data[left]) {
                //Compare left and right child.
                if (data[left] >= data[right]) {
                    //Swap
                    Swap(n, left);
                    heapDown(left);
                }
                //Right is larger than left
                else {
                    //Swap
                    Swap(n, right);
                    heapDown(right);
                }
            }
            //If node is less than just the right child.
            else if (data[n] < data[right]) {
                Swap(n, right);
                heapDown(right);
            }
        }
    }

    public void Swap(Integer i, Integer j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = str + data[i] + ", ";

        }
        return str;
    }


    public boolean equals(Integer[] data) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] != data[i]) return false;
        }
        return true;
    }
}

