class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int k = 2;
        int count = 1; 
        int occurrences = 1; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                occurrences++;
            } else {
                occurrences = 1;
            }
            
            if (occurrences <= k) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}