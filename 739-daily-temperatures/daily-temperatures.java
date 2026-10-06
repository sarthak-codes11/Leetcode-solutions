import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prev = stack.pop();
                arr[prev] = i - prev;
            }
            stack.push(i);
        }
        return arr;
    }
}
//review again