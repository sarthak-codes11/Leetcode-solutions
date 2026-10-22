class Solution {
    public int longestOnes(int[] nums, int k) {
        int st=0;
        int en=0;
        int zero=0;

        while(en<nums.length){
            if(nums[en] == 0){
                zero++;
            }
            en++;
            if(zero>k){
                if(nums[st] == 0){
                    zero--;
                }
                st++;
            }
        }
        return en-st;
    }
}