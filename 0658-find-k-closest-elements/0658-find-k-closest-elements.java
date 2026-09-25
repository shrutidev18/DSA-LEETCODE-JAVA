class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int dif[]=new int[arr.length];
        int diff;
        for(int i=0;i<arr.length;i++){
            diff=Math.abs(x-arr[i]);
            dif[i]=diff;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
        if (a[1] != b[1])
            return b[1] - a[1];

        return b[0] - a[0];
    });
        for(int i=0;i<dif.length;i++){
            pq.offer(new int[]{arr[i],dif[i]});
            if(pq.size()>k) pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }
        Collections.sort(res);
        return res;
        
    }
}