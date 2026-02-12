class Solution {
    public int pivotIndex(int[] nums) {
        
        int totalSum = 0;
        
        // Step 1: Calculate total sum of array
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Step 2: Traverse array to find pivot
        for (int i = 0; i < nums.length; i++) {
            
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i;   // Leftmost pivot index
            }
            
            leftSum += nums[i];
        }
        
        return -1;   // No pivot found
    }
}