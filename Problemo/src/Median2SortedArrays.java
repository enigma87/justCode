import java.lang.Math.*;

/**
 * 
 */

/**
 * @author enigma
 *
 */
public class Median2SortedArrays {

	/**
	 * 
	 */
	public Median2SortedArrays() {
		// TODO Auto-generated constructor stub
	}

	
	public double doubleMedian(int A[], int B[]) {
		
		return findMedian(A, 0, A.length-1, B, 0, B.length-1);
	}
	
	
	public double findMedian(int [] A, int low1, int high1, int [] B, int low2, int high2){
	
		if (A.length <= 0) return median(B);
		if (B.length <= 0) return median(A);
		
		if (high1-low1 == 1 && high2-low2 == 1 ) {
			double median = (Math.max(A[low1], B[low2]) + Math.min(A[high1], B[high2]))/2.0;
			return median;
		}
		if (high1-low1 == 1 && B.length == 0) {
			return Math.min(Math.max(A[0], B[0]), A[1]);
		}
		if (high1-low1 == 0 && high2-low2 == 1) {
			return Math.min(Math.max(A[0], B[0]), B[1]);
		}
		
		int divMedian1 = A[divideIndex(low1, high1)];
		int divMedian2 = B[divideIndex(low2, high2)];
		
		
		if (divMedian1 > divMedian2)  {
			
			return findMedian(A, low1, divideIndex(low1, high1), B, divideIndex(low2, high2), high2);
		}
		if (divMedian2 > divMedian1) {
			return findMedian( A, divideIndex(low1, high1), high1,B, low2, divideIndex(low2, high2));
		} 
		
		return (divMedian1 + divMedian2)/2;
		
	}
	
	public int divideIndex(int low, int high) {
		return (low+high)/2;
	}
	
	public double median(int [] A) {
		if (A.length <= 0) return 0;
		
		if (A.length%2 == 0) {
			return (A[A.length/2-1] + A[A.length/2])/2;
		}
		return A[A.length/2];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Median2SortedArrays m2 = new Median2SortedArrays();
		int [] A = new int[] {2,3,5,9,11};
		int [] B = new int[] {1,4,6,7,8};

		System.out.println(m2.doubleMedian(A,B));
		
		double test = 5.0;
		System.out.println(test/2);
	}

}
