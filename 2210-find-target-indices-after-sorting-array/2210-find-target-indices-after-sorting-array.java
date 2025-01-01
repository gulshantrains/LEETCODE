class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();

        int fstoc = firstOcc(nums, target);
        int lstoc = lastOcc(nums, target);

        if (fstoc == -1 || lstoc == -1)
            return ls;
        for (int i = fstoc; i <= lstoc; i++) {
            ls.add(i);
        }
        return ls;
    }

    public int firstOcc(int[] ar, int target) {
        int l = 0, r = ar.length - 1;
        int foc = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (ar[mid] == target) {
                foc = mid;
                r = mid - 1;
            } else if (ar[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return foc;
    }

    public int lastOcc(int[] ar, int target) {
        int l = 0, r = ar.length - 1;
        int laoc = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (ar[mid] == target) {
                laoc = mid;
                l = mid + 1;
            } else if (ar[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return laoc;
    }
}