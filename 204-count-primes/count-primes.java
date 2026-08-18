import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        boolean[] bool = new boolean[n];
        int count = 0;

        Arrays.fill(bool, true);

        // Bug Fix: Changed condition to i * i < n to avoid Math.sqrt overhead
        for(int i = 2; i * i < n; i++){
            if(bool[i] == true){
                // Bug Fix: j jumps by i, and we target bool[j]
                for(int j = (i * i); j < n; j = j + i){
                    bool[j] = false;
                }
            }
        }

       for(int i = 2; i < n; i++){
            if(bool[i] == true){
                count++;
            }
       }

       return count;
    }
}
