class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; // stores last index + 1 for each ASCII char (0 = not seen)
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // If ch appeared inside the current window, move left past its previous occurrence
            left = Math.max(left, lastSeen[ch]);
            lastSeen[ch] = right + 1;
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}