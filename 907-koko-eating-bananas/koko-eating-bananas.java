class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        long total = 0;
        for (int pile : piles) {
            total += pile;
        }

        int low = (int) ((total + h - 1L) / h);

        int high = (int) ((total - 2L * n + h + 1L)
                / (h - n + 1L));

        while (low < high) {

            int speed = low + (high - low) / 2;

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + speed - 1) / speed;
                if (hours > h) {
                    break;
                }
            }

            if (hours <= h) {
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return low;
    }
}