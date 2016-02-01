import java.util.*;
import java.io.*;

/**
 * 
 * MAX HEAP PQ
 * 
 */

/**
 * @author vikramaditya
 *
 */
public class PQ {

    ArrayList<Integer> arr;
    int count = 0;
    /**
     * 
     */
    public PQ() {
        arr = new ArrayList<Integer>();
        // TODO Auto-generated constructor stub
    }

    
    public int getLeftChildIndx(int i) {
        if (i>=0
            && (2*i+1) < count) {
            
        
            return (2*i+1);
        }
        return -1;
    
    }
    
    public int getRightChildIndx(int i) {
        if (i>=0
                && (2*i+2) < count) {
            
            return (2*i+2);
        }
        return -1;
    } 
    
    /*
     * simply return
     * 
     */
    
    public boolean insertArr(int el){
        if (this.arr.add(el)) {
            this.count++;
            return true;
        }
        return false;
    }
    
    
    public boolean arrSwap(int i, int j) {
        
        if (i < 0 || i >= count || j < 0 || j >= count) {
            return false;
        }
        
        Integer temp = this.arr.get(i);
        this.arr.set(i, this.arr.get(j));
        this.arr.set(j, temp);
        
        return true;
    }
    
    public boolean percolateDown(int i) {
        
        if (i < 0 || i >= this.count) return false;
        
        Integer parent = this.arr.get(i);
        int leftIndx = this.getLeftChildIndx(i);
        int rightIndx = this.getRightChildIndx(i);
        
        /*
         * Try and find the max among left and right children
         * 	1. if the left child doesn't exist, RETURN
         * 	2. update max if right child EXISTS and is greater than left
         */

        if (leftIndx < 0 ) return false;
        
        int max = this.arr.get(leftIndx).compareTo(parent) > 0 ? leftIndx : i;
        
        if (rightIndx > 0 ) {
            max = this.arr.get(rightIndx).compareTo(this.arr.get(max)) > 0 ? rightIndx : max;
        }
        
        /*
         * Swap with the parent if max(left,right) is 
         * greater than parent: i and percolate down
         * until i finds its appropriate position
         */
        
        if (i != max) {
        	arrSwap(i, max);
        	percolateDown(max);
        }
        
        return true;
    }
    
    public void heapify() {
        if (this.count <= 0) return;
        
        for (int i=this.arr.size()/2-1; i>=0; i--) {
            this.percolateDown(i);
        }
    }
    
    public void heapSort() {
        if (this.count <=0 ) return;
        
        for (;this.count > 0; ) {
            this.arrSwap(0, count-1);
            --this.count;
            this.percolateDown(0);
        }
    }
    /*
     * always deletes the element at right most corner
     * 
     */
    public boolean delArr(){
        this.count--;
        this.arr.remove(this.count);
        return true;
    }
    
    public void dump(){
        for (int i : this.arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PQ pq = new PQ();
        pq.insertArr(109);
        pq.insertArr(104);
        pq.insertArr(106);
        pq.insertArr(107);
        pq.insertArr(105);
        pq.insertArr(108);
        pq.insertArr(103);
        pq.insertArr(102);
        pq.insertArr(101);
        pq.insertArr(100);
        //pq.delArr();
        //pq.delArr();
        pq.dump();
        pq.heapify();
        pq.dump();
        pq.heapSort();
        pq.dump();
    }
    
}