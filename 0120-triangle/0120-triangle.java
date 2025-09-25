class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        // mem points to the same triangle; we modify in-place
        List<List<Integer>> mem = tri;

        // start from second last row
        for (int row = tri.size() - 2; row >= 0; row--) {
            for (int col = 0; col < tri.get(row).size(); col++) {
                int newVal = mem.get(row).get(col) + Math.min(
                        mem.get(row + 1).get(col),
                        mem.get(row + 1).get(col + 1)
                );
                mem.get(row).set(col, newVal);  //use set() to update
            }
        }

        return mem.get(0).get(0);
    }
}
