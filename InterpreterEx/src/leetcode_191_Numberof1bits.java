import java.sql.Timestamp;

public class leetcode_191_Numberof1bits {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 11;
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        for(int i = 0; i < 120; i++)
        	hammingWeight(a);
		//System.out.println("Output:" + shortestPalindrome(message));
		timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	public static int hammingWeight(int n) {
		
		String a = Integer.toBinaryString(n);
		int idx = 0;
		int count = 0;
		while(idx < a.length()){
			
			if(a.charAt(idx) == '1')
				count++;
			
			idx++;
		}
		return count;
    }
	
}
