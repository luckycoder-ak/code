class Solution {
    public static boolean dfs(int K, int cur, int[] arr, int[] nums) {
        if(cur<0) return true;
        for(int i=0; i<K; ++i) {
            if(arr[i]==nums[cur] || (cur>0 && arr[i]-nums[cur]>=nums[0])){ //必须保证减掉后，后面还有得减
                arr[i] -= nums[cur];
                if(dfs(K, cur-1, arr, nums)) return true;
                arr[i] += nums[cur];
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int x: nums) sum+=x;
        if(sum%k!=0) return false;
        int[] arr = new int[k];
        Arrays.fill(arr, sum/k);
        Arrays.sort(nums);
        return dfs(k, nums.length-1, arr, nums);
    }
}
