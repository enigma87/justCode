package DyPro;

public class Factorial {

	public Factorial() {
		// TODO Auto-generated constructor stub
	}

	static  int stack_alloc = 0;
	
	static int[] memoize = new int[15];
	
	public static int Run(int n) {
		
		stack_alloc++;
		
		if (n == 0) return 1;
		if (n == 1) return 1;
		if (memoize[n] > 0 ) {
			return memoize[n];
		}
		return memoize[n] = n * Run(n-1);
	}
	
	
	public static void main(String args[]) {
		System.out.println(Run(14));
		System.out.println(stack_alloc);
		System.out.println(Run(12));
		System.out.println(stack_alloc);
	}
}
