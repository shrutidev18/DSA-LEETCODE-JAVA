class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int MOD = 1000000007;
        int ps[]=new int[n];
        int ns[]=new int[n];
        Arrays.fill(ps,-1);
        Arrays.fill(ns,n);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ps[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ns[i] = stack.peek();
            }
            stack.push(i);
        }
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - ps[i];
            long rightCount = ns[i] - i;
            
            long contribution = (leftCount * rightCount) % MOD;
            contribution = (contribution * arr[i]) % MOD;
            
            totalSum = (totalSum + contribution) % MOD;
        }
        
        return (int) totalSum;
    }
}