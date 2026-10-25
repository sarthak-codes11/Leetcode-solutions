class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int total = 0;

        int left = 0;
        int right = 0;

        int start = 0;
        int end = n - 1;

        while (start < end) {

            left = Math.max(left, height[start]);
            right = Math.max(right, height[end]);

            if (left < right) {

                total += left - height[start];
                start++;

            } else {

                total += right - height[end];
                end--;
            }
        }

        return total;
    }
}