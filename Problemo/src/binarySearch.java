
public class binarySearch {

	int A[];
	public binarySearch(int arr[]) {
		// TODO Auto-generated constructor stub
		
		A = arr;
	}

	
	public int Search(int a,int i,int j) {
		if (a == A[(i+j)/2]) return (i+j)/2;
		else if (a < A[(i+j)/2]) {
			return Search(a, i, (i+j)/2-1);
		} else if (a > A[(i+j)/2] ){
			return Search(a, (i+j)/2+1, j);
		}
		return -1;
	}
	

	
	
	public static void main(String args[]){
		binarySearch bS = new binarySearch(new int[]{1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19});
		System.out.println(bS.Search(15, 0, bS.A.length-1));
		
		
	}
	
}
