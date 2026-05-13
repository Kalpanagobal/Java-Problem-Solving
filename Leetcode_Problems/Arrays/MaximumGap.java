class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxDiff = 0;

        if(nums.length < 2) return 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > maxDiff){
                maxDiff = nums[i] - nums[i - 1];
            }
        }
        return maxDiff;
    }
}