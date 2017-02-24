
public class leetcode_35_SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] nums = {1,3,5,7};
		//int[] nums = {1,3};
		int[] nums = {1};
		int target = 0;
		
		leetcode_35_SearchInsertPosition a = new leetcode_35_SearchInsertPosition();
		
		System.out.println(a.searchInsert(nums, target));
	}

	
	public int searchInsert(int[] nums, int target) {
		
		int result = searchIndex(nums, target, 0, nums.length - 1);
		
		return result;
    }
	
	public int searchIndex(int[] nums, int target, int idx_s, int idx_e){
		
		int key = idx_s + (idx_e - idx_s + 1)/2;
		int result = 0;
				
		if(idx_e - idx_s <= 0)
			if(nums[idx_e] >= target)
				result = idx_e;
			else
				result = idx_e + 1;
		else if((int) nums[key] < target)
			result = searchIndex(nums, target, key + 1, idx_e);
		else
			result = searchIndex(nums, target, idx_s, key - 1);
		
		return result;
	}
}
