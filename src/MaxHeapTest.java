import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void testAdd(){
        MaxHeap heap = new MaxHeap (5);

        Integer[] test0 = {};
        assertTrue(heap.equals(test0));

        heap.add(1);
        Integer[] test1 = {1};
        assertTrue(heap.equals(test1));

        heap.add(5);
        Integer[] test2 = {5, 1};
        assertTrue(heap.equals(test2));

        heap.add(2);
        Integer[] test3 = {5, 1, 2};
        assertTrue(heap.equals(test3));

        heap.add(7);
        Integer[] test4 = {7, 5, 2, 1};
        assertTrue(heap.equals(test4));

        heap.add(3);
        Integer[] test5 = {7, 5, 2, 1, 3};
        assertTrue(heap.equals(test5));

        Integer tests[][] = {
                {},
                {1},
                {4,1},
                {4, 1, 2},
                {7, 4, 2, 1},
                {7, 4, 2, 1, 3}
        };


    }

    @Test
    public void testGet(){
        MaxHeap heap = new MaxHeap(10);
        assertEquals(null, heap.get());
        heap.add(1);
        heap.add(2);
        heap.add(4);
        assertEquals((Integer) 4, heap.get());
        heap.add(3);
        assertEquals((Integer) 4, heap.get());
        heap.add(122);
        assertEquals((Integer) 122, heap.get());
        heap.add(-1223);
        assertEquals((Integer) 122, heap.get());
    }


    @Test
    public void testPop(){
        MaxHeap heap = new MaxHeap (10);
        heap.add(1);
        assertEquals((Integer) 1, heap.pop());
        assertEquals(null, heap.pop());

        heap.add(5);
        heap.add(1);
        assertEquals((Integer) 5, heap.pop());
        assertEquals((Integer) 1, heap.pop());

        heap.add(8);
        heap.add(2);
        heap.add(22);
        heap.add(222);
        assertEquals((Integer) 222, heap.pop());
        heap.pop();
        assertEquals((Integer) 8, heap.pop());
    }

/*
    @Test
    public void tests() {


        int testTime = 1000000;

        System.out.println("MaxHeapNLogN: ");

        Integer[] arr = new Integer[testTime];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt((arr.length - 1) + 1) + 1;
        }

        MaxHeap mh = new MaxHeap(testTime);
        mh.MaxHeapNLogN(arr);
        System.out.println(System.currentTimeMillis());


        System.out.println("MaxheapN: ");

        Integer[] arr1 = new Integer[testTime];
        Random r1 = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r1.nextInt((arr.length - 1) + 1) + 1;
        }

        MaxHeap mh1 = new MaxHeap(testTime);
        mh1.MaxHeapN(arr);
        System.out.println(System.currentTimeMillis());
    }

 */

    @Test
    public void testMaxHeapNlogN(){

        MaxHeap heap1 = new MaxHeap(1);
        Integer[] test1 = {};
        heap1.MaxHeapNLogN(test1);
        assertTrue(heap1.equals(test1));

        MaxHeap heap2 = new MaxHeap(5);
        Integer[] test2 = {1, 4, 2, 8, 3};
        Integer[] result2 = {8, 4, 2, 1, 3};
        heap2.MaxHeapNLogN(test2);
        assertTrue(heap2.equals(result2));

        MaxHeap heap3 = new MaxHeap(2);
        Integer[] test3 = {1,1};
        Integer[] result3 = {1,1};
        heap3.MaxHeapNLogN(test3);
        assertTrue(heap3.equals(result3));

    }
    @Test
    public void testMaxHeapN(){

        MaxHeap heap1 = new MaxHeap(5);
        Integer[] test1 = {};
        heap1.MaxHeapN(test1);
        assertTrue(heap1.equals(test1));

        MaxHeap heap2 = new MaxHeap(5);
        Integer[] test2 = {1, 4, 2, 8, 3};
        Integer[] result2 = {8, 4, 2, 1, 3};
        heap2.MaxHeapN(test2);
        assertTrue(heap2.equals(result2));

        MaxHeap heap3 = new MaxHeap(2);
        Integer[] test3 = {1,1};
        Integer[] result3 = {1,1};
        heap3.MaxHeapN(test3);
        assertTrue(heap3.equals(result3));

    }


}