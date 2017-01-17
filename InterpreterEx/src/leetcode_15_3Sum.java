import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class leetcode_15_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {-10,-1, -5, -6, -7, -2, -3, 0, 1, 2,3,4,5,6,8,9, -1, -4};
		//int[] a = {-1, -2,  0, 1, -1, -4};
		int[] a = {-1,0,1,2,-1,-4};
		//int[] a = {-5,1,-3,-1,-4,-2,4,-1,-1};
		//int[] a = {1,4,-4,-5,-1,-2,-3,-4};
		//int[] a = {6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5};
		//int[] a = {0,0,0};
		//int[] a = {-1,0,1};
		//int[] a = {1,1,-2};
		//int[] a = {-1,0,1,0};
		//int[] a = {0,0,1,2,3,4};		
		//int[] a = {};
//		int[] a = {0};
//		threeSum(a);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        for(int i = 0; i < 12000; i++)
        	threeSum(a);
		//System.out.println("Output:" + shortestPalindrome(message));
		timestamp = new Timestamp(System.currentTimeMillis());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
		
		if(nums.length >= 3)
			hs = new HashSet<List<Integer>>(combination(nums));
		result = new ArrayList<List<Integer>>(hs); 
        
		return result;
    }
	
	public static List<Integer> convertAndSortArray(int[] nums){
		
		Integer[] newArray = new Integer[nums.length];
		int i = 0;
		for (int value : nums) {
		    newArray[i++] = Integer.valueOf(value);
		}
		
		List<Integer> a = Arrays.asList(newArray);
		
		Collections.sort(a);
		
		return a;
	}
	
	public static List<List<Integer>> combination(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		
		List<Integer> a = convertAndSortArray(nums);
		List<Integer> b = new ArrayList<Integer>();
		int zeroIdx = a.size();
		
		//find zero index
		for(int i = 0 ; i < a.size() ; i++){
			if(a.get(i) >= 0){
				zeroIdx = i;
				
				if(i+2 < a.size() && a.get(i + 1) == 0 && a.get(i + 2) == 0)
					result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{0,0,0})));
				
				break;
			}
		}
		int zerolast = zeroIdx;
		//find zero index
		for(int i = zeroIdx ; i < a.size() ; i++){
			if(a.get(i) == 0){
				zerolast = i;
			} else{
				break;
			}
		}
		
		
		//모든 수가 음수
		if(zeroIdx == a.size())
			return result;
		
		if(zeroIdx == 0 && a.size() >= 3){
//			result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{0,0,0})));
			return result;
		} 

		//array b is 절대값이 같은 수 의 index number
		int j = a.size() - 1;
		for(int i = 0 ; i < zeroIdx ; i++){
			if(a.get(i) < 0){
				b.add(a.size() - 1);
				for(; j >= zeroIdx ; ){
					if(Math.abs(a.get(i)) < Math.abs(a.get(j))){
						b.set(i, j);
						j--;
					} else if(Math.abs(a.get(i)) == Math.abs(a.get(j))){
						b.set(i, j);
						break;
					} else{
						break;
					}
				}
			}
		}
		
		
		
		for(int i = 0 ; i < zeroIdx ; i++){
			//0을 포함한 집합
			if(a.get(zeroIdx) == 0)
				if(b.get(i) != 0 && Math.abs(a.get(i)) == Math.abs(a.get(b.get(i)))) {
					List<Integer> set = new ArrayList<Integer>();
					set.add(a.get(i));
					set.add(a.get(b.get(i)));
					set.add(a.get(zeroIdx));
					Collections.sort(set);
					result.add(set);
				}
			if(i < a.size()-1 && a.get(i) == a.get(i+1)){
				i++;
			}
			//음수를 1개 포함
//			if(a.get(zeroIdx) == 0)
//				result.addAll(getSumZero(a.subList(zeroIdx+1, b.get(i) + 1), a.get(i)));
//			else 
//				result.addAll(getSumZero(a.subList(zeroIdx, b.get(i) + 1), a.get(i)));
			if(a.get(zeroIdx) == 0)
				result.addAll(getSumZero(a.subList(zerolast + 1, b.get(i) + 1), a.get(i)));
			else 
				result.addAll(getSumZero(a.subList(zerolast, b.get(i) + 1), a.get(i)));
		}
		
		for(int i = zeroIdx ; i < a.size() ; i++){
			//음수를 2개 포함
			if(a.get(zeroIdx) == 0)
				result.addAll(getSumZero(a.subList(0, zeroIdx), a.get(i)));
			else
				result.addAll(getSumZero(a.subList(0, zeroIdx), a.get(i)));
			if(i < a.size()-1 && a.get(i) == a.get(i+1)){
				i++;
			}
		}
		
		
		
		
		//combination
//		if(nums == null) return result;
//		int n = nums.length;
//		
//		int[] k = null;
//		if(n-1>0)
//			k = new int[n-1];
//		//String set = "";
//		for(int i = 0 ; i < n -1 ; i++){
//			for(int j = i+1; j < n -1 ; j++) {
//				//set += i+","+j +"," +(n - 1)+"/";
//				if(nums[i] + nums[j]+ nums[nums.length-1] == 0){
//					//System.out.print(i+","+j +"," +(n - 1)+" = ");
//					//System.out.println(nums[i] + "," + nums[j] + "," + nums[nums.length-1]+"/");
//					List<Integer> set = new ArrayList<Integer>();
//					set.add(nums[i]);
//					set.add(nums[j]);
//					set.add(nums[nums.length-1]);
////					Collections.sort(set, Collections.reverseOrder());
//					Collections.sort(set);
//					
//					result.add(set);
//				}
//			}
//			if(i < n-1)
//				k[i] = nums[i];
//		}
//		if(k.length >= 3)
//			result.addAll(0, combination(k));
		return result;
	}
	
	public static List<List<Integer>> getSumZero(List<Integer> a, Integer number){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i = 0 ; i < a.size() ; i++){
			//if(Math.abs(a.get(i)) > number)
			for(int j = i+1; j < a.size() ; j++) {
				
				if(a.get(i) + a.get(j) + number == 0){
					//System.out.print(i+","+j +"," +(n - 1)+" = ");
					//System.out.println(nums[i] + "," + nums[j] + "," + nums[nums.length-1]+"/");
					List<Integer> set = new ArrayList<Integer>();
					set.add(a.get(i));
					set.add(a.get(j));
					set.add(number);
					Collections.sort(set);
					
					result.add(set);
				}
		}
	}
		
		return result;
	}
}
