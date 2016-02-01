
public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void sort(int [] A, int low, int high){
		if (high - low <= 0) return;
		
		int pivot = partition(A, low, high);
		sort(A, low, pivot-1);
		sort(A, pivot +1, high);
		
	};
	
	public int partition(int [] A, int low, int high) {
		int i = low+1;
		int j = high;
		int pivot = A[low];
		while (true) {
			while (A[i] < pivot) {
				i++;
			}
			while (A[j] > pivot) {
				j--;
			}
			
			if (i < j ) {
				int temp = A[i];
				A[i] = A[j];
				A[j] =  temp;
			} else {
				A[low] = A[j];
				A[j] = pivot;
				return j;
			}
		}
	}

public static void main (String args[]) {
	QuickSort qs = new QuickSort();
	int A[] = new int[] {5,3,8,7,10,9,6};
	qs.sort(A, 0, A.length-1);
	
	for (int i : A){
		
		System.out.println(i);
	}
	
}
}
