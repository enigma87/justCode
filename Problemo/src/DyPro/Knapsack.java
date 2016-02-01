package DyPro;

public class Knapsack {

	public Knapsack() {
		// TODO Auto-generated constructor stub
	}
	
	private int max(int a, int b) {
		
		return a > b? a : b;
		
	}
	
	private int optProfit(int [] value, int  [] weight, int remWeight){

		int profit = 0;
		int [][] dynaTable = new int[value.length+1][remWeight+1];
		
		// base case
		for (int i =0; i <= remWeight; i++) {
			dynaTable[0][i] = 0;
		}
		for (int i =0; i <= value.length; i++) {
			dynaTable[i][0] = 0;
		}
		
		
		// build the dynamic table
		for (int i = 1; i <= value.length; i++ ) {
			
			for (int j =1; j <= remWeight; j++) {
				
				if (weight[i-1] > j) {
					dynaTable [i] [j] =  dynaTable[i-1][j];
				} else {
					
					dynaTable [i] [j] = max(dynaTable[i-1][j], value[i-1] + dynaTable[i-1][j-weight[i-1]]);
				}
				
				
			}
			
			
		}
		
		profit = dynaTable[value.length][remWeight];
		
		return profit;
	}
	
	static int [] dynRepeatProfit ;
	private  int optRepeatProfit(int [] value, int [] weight, int weightLimit ) {
		dynRepeatProfit  = new int[weightLimit+1];
		
		dynRepeatProfit[0] = 0;
		
		for (int j = 1; j <= weightLimit; j++) {
			
			for (int i =0; i < value.length; i++) {
				if (weight[i] <= j )
				dynRepeatProfit[j] = max(dynRepeatProfit[j-1], dynRepeatProfit[j-weight[i]]+value[i]);
				
			}
			
		}
		
		
		
		return dynRepeatProfit[weightLimit];
		
		
	}
	
	
	public static void main(String args[]) {
		
		int[] item_value = new int[]{1,6,18,22,28};
		int[] item_weight = new int[]{1,2,5,6,7};

	System.out.println(new Knapsack().optProfit(item_value, item_weight, 4));
	
	System.out.println(new Knapsack().optRepeatProfit(item_value, item_weight, 4));
	
	}
	
	

}
