class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();

        for (var ast : a) {
            boolean expo = false;

            while (!st.isEmpty() && st.peek() > 0 && ast < 0) { //It will catch from front mtlb aane wla astroid agr peeche ke taraf jaa rha hoga tb he n hit kre g
                int topastSize = st.peek();

                if (Math.abs(topastSize) > Math.abs(ast)) {
                    expo = true;
                    break;
                } else if (Math.abs(topastSize) < Math.abs(ast)) {
                    st.pop();
                } else {
                    st.pop();
                    expo = true;
                    break;
                }
            }
            if (!expo)
                st.push(ast);
        }
        List<Integer> ans = new ArrayList<>(st);

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}