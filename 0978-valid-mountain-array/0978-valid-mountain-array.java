class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, idx = -1;

        if (n < 3)
            return false;

        for (int i = 1; i < n - 1; i++) {
            
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                idx = i;
                break;
            }
        }
        if(idx==-1) return false;
        
        for (int i = 0; i < idx; i++) {
            if (arr[i] >= arr[i + 1])
                return false;
        }
        for (int i = idx + 1; i < n - 1; i++) {
            if (arr[i + 1] >= arr[i])
                return false;
        }

        return true;
    }
}