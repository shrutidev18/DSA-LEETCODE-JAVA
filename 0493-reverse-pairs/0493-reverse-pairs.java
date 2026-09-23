class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        
        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        
        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }
        System.arraycopy(temp, 0, nums, low, temp.length);
    }
}
