import java.sql.Timestamp;

public class palindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input:");
		
		//Scanner scan = new Scanner(System.in);
		//String message = "aacecaaa";
		//String message = "aabba";
		//String message = "adcba";
		//String message = "abcd";
		String message = "abcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyzabcdefghijklmlopqrstuvwxyz";
		//String message = "";
		
		//message = scan.nextLine();
		//method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        for(int i = 0; i < 12000; i++)
        	shortestPalindrome(message);
		//System.out.println("Output:" + shortestPalindrome(message));
		timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
	}
	
//	public static String shortestPalindrome(String s) {
//		char[] aryChr = s.toCharArray();
//		int[] alpha = new int[52];
//		int num = 0;
//		boolean getone = false;
//		
//		for(int i = 0; i < aryChr.length ; i++){
//			if(aryChr[i] != ' '){
//				num = aryChr[i] - 'a';
//				alpha[num]++;
//			}
//		}
//		boolean odd = false;
//		int sum = 0;
//		for(int i = 0; i < alpha.length ; i++){
//			if(alpha[i]%2 == 1){
//				odd = true;
//			}
//			sum += alpha[i]/2;
//		}
//		if(odd == false){
//			sum = sum * 2;
//		} else {
//			sum = sum * 2 + 1;
//		}
//		
//		return s;
//        
//    }
	
	public static String shortestPalindrome(String s) {
		
		if(s == "") return "";
		
		int last = s.length();
		String revers = ( new StringBuffer(s) ).reverse().toString();
		int first = 0;
		for(int lastidx = s.length(); lastidx > 0 ; lastidx--) {
			if(revers.substring(first, last).equals(s.substring(0,lastidx)))
				break;
			first++;			
		}
		revers = revers.substring(0, first);
		return revers + s;
        
    }
	
	
//	public static String shortestPalindrome(String s) {
//		int j = 0;
//	    for (int i = s.length() - 1; i >= 0; i--) {
//	        if (s.charAt(i) == s.charAt(j)) { j += 1; }
//	    }
//	    if (j == s.length()) { return s; }
//	    String suffix = s.substring(j);
//	    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
//    }
}
