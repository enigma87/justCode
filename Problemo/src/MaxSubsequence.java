/**
 * 
 */

/**
 * @author enigma
 *
 */
public class MaxSubsequence {

	/**
	 * 
	 */
	public MaxSubsequence() {
		// TODO Auto-generated constructor stub
	}

	
	public int maxSum(int[] A, int left, int right){
		
		if (left == right) {
			return A[left];
			
		}
		
		int mid = (left + right) /2;
		 
		int leftMax = maxSum(A, left, mid);
		
		int rightMax = maxSum(A, mid+1, right);
		
		int leftSum = 0;
		int maxLeftSum = -100;
		int rightSum = 0;
		int maxRightSum= -100;
		
		
		for (int i=mid; i >= left; i--) {
			leftSum = leftSum + A[i];
			if (leftSum > maxLeftSum) maxLeftSum = leftSum;
		}
		
		for (int i=mid+1; i <= right; i++) {
			rightSum = rightSum + A[i];
			if (rightSum > maxRightSum) maxRightSum = rightSum;
			
		}
		
	System.out.println("rt sum " + rightMax + " left sum " + leftMax + " lt-rt " + maxLeftSum+" - "+maxRightSum + " l r m " + left + right + mid);	
	
		if (leftMax > rightMax && leftMax > (maxRightSum + maxLeftSum) ) {
			return leftMax;
		}
		
		if (rightMax > leftMax && rightMax > (maxLeftSum + maxRightSum)) {
			return rightMax;
		}
		
		return (maxLeftSum + maxRightSum);
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxSubsequence mss = new MaxSubsequence();
		
		System.out.println(mss.maxSum(new int [] {1, 2, 3,-5, 6, 7, 3, 9}, 0, 7));
	}

}
