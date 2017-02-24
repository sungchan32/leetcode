
public class leetcode_3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		leetcode_3_LongestSubstringWithoutRepeatingCharacters cl = new leetcode_3_LongestSubstringWithoutRepeatingCharacters();
		
		String s = "bpfbhmipx";
		System.out.print("result = " + cl.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s)  {
        int length = 0;
        String substring = "";
        
        if(s.length() > 0)
        	substring = s.charAt(0) + "";
        
        boolean repeat = false;
        for(int i = 0 ; i < s.length(); i++) {
        	for(int j = 0 ; j < substring.length(); j++) {
        		if(substring.charAt(j) == s.charAt(i)) {
        			repeat = true;
        			substring += s.charAt(i) + "";
        			substring = substring.substring(j + 1);
        			break;
        		} else {
        			repeat = false;
        		}
        	}
        
        	if(repeat) {
        		
        	} else {
        		substring += s.charAt(i) + "";
        	}
        	length = substring.length() > length ? substring.length() : length;
        	repeat = false;
        }
        
        return length;
    }
}
