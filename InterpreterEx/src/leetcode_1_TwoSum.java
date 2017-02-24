public class leetcode_1_TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = {};
		
		leetcode_1_TwoSum cl = new leetcode_1_TwoSum();
		
		result = cl.twoSum(nums, target);
		
		System.out.print("result = ");
		for(int i = 0; i < result.length ; i++) {
			System.out.print(result[i] + " ");
		}
		
		
	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		for(int i = 0 ; i < nums.length ; i++) {
			for(int j = i + 1; j < nums.length ; j++) {
				if(target == nums[i] + nums[j]) {
					result[0] = i;
					result[1] = j;
					return result;
				}
					
			}
		}
		
        return result;
    }
	
}
