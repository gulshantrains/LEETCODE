class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();

        generate(nums, 0, new ArrayList<>(), subset);
        int xor = 0;

        for (List<Integer> x : subset) {
            int temp = 0;
            for (var z : x)
                temp ^= z;

            xor += temp;
        }
        return xor;
    }

    public void generate(int[] arr, int index, List<Integer> curr, List<List<Integer>> sub) {
        if (index == arr.length) {
            sub.add(new ArrayList<>(curr));
            return;
        }

        //Include the current element
        curr.add(arr[index]);
        generate(arr, index + 1, curr, sub);

        //Exclude the current element
        curr.remove(curr.size() - 1);
        generate(arr, index + 1, curr, sub);
    }
}