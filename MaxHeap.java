
import java.util.*;
public class MaxHeap<E extends Comparable<E>> extends ArrayList<E>   {
    // construct an empty Heap using ArrayList
    // with root at index 0.
    // don't use binary tree for implementing the heap.
    // log n per insertion
    // heap sort O( n log n)
    ArrayList<E> maxHeap;

    public MaxHeap(){
        maxHeap = new ArrayList<>();
    }
    // returns max value
    public E findMax() throws ArrayIndexOutOfBoundsException{
        E max = null;
        if(maxHeap.size() <= 0)
        {
            System.out.println("MaxHeap size is <= 0");
        }
        else
        {
            max = maxHeap.get(0);
        for (int i = 0; i < maxHeap.size(); i++)
        {
            E temp = maxHeap.get(i);
            if (temp.compareTo(max) > 0)
                max = temp;
        }
        return max;
    }
    return max;
    }

    // adds a new value to the heap at the end of the Heap and 
    // adjusts values up to the root to ensure Max heap property is satisfied.
    // parent of node at i is given by the formula (i-1)/2
    // throw appropriate exception
    public void addHeap(E val) {
        maxHeap.add(val);
        int i = maxHeap.size() - 1;
        int parent = (i-1)/2;

        if (i < 3)
            parent = 0;
            
        E iVal = maxHeap.get(i);
        E iParent = maxHeap.get(parent);
        if (iVal.compareTo(iParent) > 0)
        {
        
            Collections.swap(maxHeap, i,parent);
            i = parent;
            parent = (i-1)/2;
            while (iVal.compareTo(iParent) > 0)
            {
                
                Collections.swap(maxHeap, i,parent);
                i = parent;
                parent = (i-1)/2;
            }

        }
    }

    //returns the max value at the root of the heap by swapping the last value 
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public E removeHeap() {
        int  p = 0;
       int child1 = 2* p +1;
       int child2 = 2 * p +2;
       E val1 = maxHeap.get(child1);
       E val2 = maxHeap.get(child2);
       E greaterVal;
       int greatSpot;
       if(val1.compareTo(val2) > 0)
       {
           greaterVal = val1;
            greatSpot = child1;
       }

       else
       {
           greaterVal = val2;
           greatSpot = child2;
       }

       maxHeap.set(p, maxHeap.get(maxHeap.size()));
       E pValue = maxHeap.get(p);
       while(greaterVal.compareTo(pValue) > 0) {
           E temp = pValue;
           maxHeap.set(p, greaterVal);
           maxHeap.set(greatSpot, temp);

           p = greatSpot;
           child1 = 2 * p + 1;
           child2 = 2 * p + 2;
           if (val1.compareTo(val2) > 0) {
               greaterVal = val1;
               greatSpot = child1;
           } else {
               greaterVal = val2;
               greatSpot = child2;
           }
       }
       return maxHeap.get(0);

    }

    // takes a list of items E and builds the heap and then prints 
    // decreasing values of E with calls to removeHeap().  
    public void heapSort(List<E> list)
    {
        ArrayList<E> sortHeap = new ArrayList<>();


        for (int i = 0; i < list.size(); i++)
            sortHeap.add(list.get(i));
        System.out.println(sortHeap);
       
        // Remove elements from the heap
        for (int i = list.size() - 1; i >= 0; i--)
            sortHeap.remove(list.get(i));

    }

    // merges the other maxheap with this maxheap to produce a new maxHeap.  
    public void heapMerge(MaxHeap<E> other){

        for (E  x : other){
            if (!maxHeap.contains(x))
                maxHeap.add(x);
        }
        heapSort(maxHeap);

    }

    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        for (int i = 0; i < list.size(); i++)
            maxHeap.add(list.get(i));
            System.out.println(maxHeap);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(42);
        list.add(15);
        list.add(9);

        MaxHeap<Integer> heap2 = new MaxHeap<>();
        heap2.add(2);
        heap2.add(60);
        heap2.add(20);
        heap2.add(15);

        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.buildHeap(list);
        heap.heapMerge(heap2);
        System.out.println(heap);
        System.out.println("Max " + heap.findMax());



    }


}