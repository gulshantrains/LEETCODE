class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int EC) {
        ArrayList<Boolean> ls = new ArrayList<>();

        int max = -1;
        for (int x : candies) {
            if (x > max)
                max = x;
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + EC >= max)
                ls.add(true);
            else
                ls.add(false);
        }
        return ls;
    }
}