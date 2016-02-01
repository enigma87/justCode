
public class Stock_Profit {

	static int BUY = -1;
	static int SELL = -1;
	static int PROFIT = 0;
	
	public Stock_Profit() {
		// TODO Auto-generated constructor stub
	}

	public static void reset(){
		BUY = -1;
		SELL = -1;
		PROFIT = 0;
	}
	
	
	public static void tellProfit(int [] stockPrice) {
		
		int buy = 0;
		SELL = 0; 
				
		for(int i=1; i< stockPrice.length; i++){
			if (stockPrice[i] < stockPrice[buy]){
				buy = i;
			}
			if (stockPrice[i]-stockPrice[buy] > PROFIT) {
				PROFIT = stockPrice[i] - stockPrice[buy];
				SELL = i;
				BUY = buy;
			}
			
		}
		
		System.out.println("buy on " + BUY + " and sell on " + SELL + " for a profit of $" + PROFIT);
		reset();
	
	}
	
	public int [] searchProfit(int[] stockPrice, int left, int right){
		int [] result = new int[3];
		
		if (left + 1 == right) return new int []{0, left, left};
		
		//Mid Min Max
		int mid = (left + right) / 2;
		
		int leftResult[] = searchProfit( stockPrice, left, mid);
		int rightResult[] = searchProfit(stockPrice, mid, right);
		
		int leftBuy = leftResult[1];
		int leftSell = leftResult[2];
		int leftProfit = leftResult[0];
		
		int rightBuy = rightResult[1];
		int rightSell = rightResult[2];
		int rightProfit = rightResult[0];
		
		int leftMin = Min(stockPrice, left, mid);
		int rightMax = Max(stockPrice, mid, right);
		
		int profit = stockPrice[rightMax] - stockPrice[leftMin];
		
		if (leftProfit > rightProfit && leftProfit > profit) return leftResult;
		if (rightProfit > profit && rightProfit > leftProfit) return rightResult;
		
		
		return new int[] {profit, leftMin, rightMax};
	}
	
	public int Mid(int left, int right) {
		return (left + right)/2;
	}
	
	// * return index of the max of two ints
	public int Max(int [] A, int left, int right) {
		
		if (A[right] > A[left]) return right;
		return left;		
	}
	
	// * return index of min of two numbers
	public int Min(int [] A, int left, int right) {
		if (A[left] < A[right]) return left;
		return right;
	}
	
	
	public static void main(String args[]){
		Stock_Profit sp = new Stock_Profit();
		System.out.println(sp.searchProfit(new int [] {200, 220, 150, 10, 100,  185, 120, 60, 70, 135,10, 100}, 0, 11)[2]);
		
	}
}