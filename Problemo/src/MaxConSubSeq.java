package DyPro;

import java.util.Arrays;

public class MaxConSubSeq {

	public MaxConSubSeq() {
		// TODO Auto-generated constructor stub
	}
	
	public int findN3Sum(int [] A) {
		int n = A.length;
		int maxSum = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++){
				int guessSum = 0;
				for(int k = i; k <= j; k++){
					guessSum += A[k];
					if (guessSum > maxSum) maxSum = guessSum;
				}
			}
		}
		
		return maxSum;
	}
	
	public int findN2Sum(int []A) {
		int n = A.length;
		int maxSum = 0;
		for (int i =0; i < n; i ++) {
			int guessSum = 0;
			for (int j = i; j < n; j++) {
				guessSum += A[j];
				if (guessSum > maxSum) maxSum = guessSum;
			}
		}
		return maxSum;
	}

	public int  findNSum( int A[]) {
		int n = A.length;
		
		int dynSum [] = new int[n];
		int j = 0;
		
		dynSum[0] = A[0] > 0 ? A[0] : 0;
		
		for (int i = 1; i < n; i++) {
			
			if (A[i]<0) {
				j++;
				if (dynSum[j-1] + A[i] < 0) {
					dynSum[j] = 0;
				} else {
					dynSum[j] = dynSum[j-1] + A[i];
				}
			}
			else {
				dynSum[j] += A[i];
			}			
		}
		
		int maxSum = 0;
		for (int i =0; i < dynSum.length;i++) {
			if (dynSum[i] > maxSum) {
				maxSum = dynSum[i];
			}
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A [] = new int[] {4, -3, 2, 3, 4, -5, 7,-8};
		int sum = new MaxConSubSeq().findN3Sum(A);
		System.out.println(sum);
		sum = new MaxConSubSeq().findN2Sum(A);
		System.out.println(sum);
		sum = new MaxConSubSeq().findNSum(A);
		System.out.println(sum);
		
	}

}
