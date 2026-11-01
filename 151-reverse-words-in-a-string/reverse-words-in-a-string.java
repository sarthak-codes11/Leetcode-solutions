class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        char[] sArr = s.toCharArray();
        int n = s.length();



        reverse(sArr, 0, n-1);
        int read =0, write = 0;

        while (read < n) {
            while (read < n && sArr[read] == ' ') {
                read++;
            }

            if (read == n) break;

            if (write > 0) {
                sArr[write++] = ' ';
            }

            int start = write;
            while (read < n && sArr[read] != ' ') {
                sArr[write++] = sArr[read++];
            }

            reverse(sArr, start, write - 1);
        }

        return new String(sArr, 0, write);
        
    }

    private void reverse(char[] arr, int i, int j) {

        while(i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}