import java.sql.Timestamp;

public class leetcode_29_DividetowIntergers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        for(int i = 0; i < 120; i++)
        	divide(-2147483648, -1017100424);
		//System.out.println("Output:" + shortestPalindrome(message));
		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
	}
	
	
	public static int divide(int dividend, int divisor) {
		boolean minus = false;
		
		if(( dividend < 0 || divisor < 0 ) && ! ( dividend < 0 && divisor < 0 ))
			minus = true;
		
		if(dividend == 0)
			return 0;
		
//		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		int a = 0;
		String result = "";
		String ab = "";
		String strDividend = Integer.toString(dividend);
		
		int[] divide = {0,0};
		
		for(int i = 0 ; i < strDividend.length(); i++){
			if(strDividend.charAt(i) == '-')
				continue;
			
			ab = divide[1] + Integer.toString(Integer.parseInt(strDividend.charAt(i) + "")) + "";
			if(ab.equals("2147483648"))
				divide = divideChar(Integer.MAX_VALUE, divisor);
			else 
				divide = divideChar(Integer.parseInt(ab), divisor);
			result += divide[0] + "";
		}
		
		if(result.equals("2147483648"))
			a = Integer.MAX_VALUE;
		else
			a = Integer.parseInt(result);
		
		if(minus)
			a = -a;
		
		System.out.println(a);
		return a;
    }
	
	public static int[] divideChar(int dividend, int divisor){
		
		int[] result = new int[2];
		int a = 0;
		//int b = 0;	
		
		while(true){
			
			
			dividend -= divisor;
			
			if(dividend >= 0){
				a++;
			} else break;
			
		}
		
		result[0] = a; //¸ò
		if(dividend != 0)
			result[1] = dividend + divisor; //³ª¸ÓÁö
		else result[1] = 0;
		
		return result;
	}
	
}
