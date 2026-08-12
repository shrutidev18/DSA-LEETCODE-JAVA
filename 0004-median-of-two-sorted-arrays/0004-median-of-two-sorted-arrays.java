class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; int n= nums2.length;
        int l = m+n;
        int ans[] = new int[l];
        int i=0;int j=0;int in=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                ans[in++]=nums1[i++];
            }
            else{
                ans[in++]=nums2[j++];
            }

        }
        while(i<m) ans[in++]=nums1[i++];
        while(j<n) ans[in++]=nums2[j++];

        if(l%2!=0) {
            return ans[l/2];
        }
        float a = ans[l/2 -1];
        float b= ans[l/2];
        return (a+b)/2.0;
        }
}