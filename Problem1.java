// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int result [] = new int [n];
        Stack<Integer> st = new Stack<>();
        int prev =0, cur = 0;
        for(String log: logs){
            String [] ar = log.split(":"); // [id, start/end, 2]
            cur = Integer.parseInt(ar[2]);
            if(ar[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += cur-prev;
                }
                st.push(Integer.parseInt(ar[0]));
                prev = cur;
            }else{
                //end
                result[st.pop()] += cur + 1 - prev;
                // +1 added because its right end of the task where as start is left end
                prev = cur + 1;
            }
        }
        return result;
    }
}