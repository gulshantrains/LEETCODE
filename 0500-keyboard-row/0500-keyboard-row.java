class Solution {
    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();

        Set<Character> row1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        Set<Character> row2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        Set<Character> row3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

        for (String x : words) {
            boolean flag1 = false, flag2 = false, flag3 = false;

            for (char y : x.toCharArray()) {
                y = Character.toLowerCase(y); // ✅ convert before checking
                if (row1.contains(y)) flag1 = true;
                else if (row2.contains(y)) flag2 = true;
                else if (row3.contains(y)) flag3 = true;
            }

            //  word valid if it belongs to exactly one row
            if ((flag1 ? 1 : 0) + (flag2 ? 1 : 0) + (flag3 ? 1 : 0) == 1)
                ans.add(x);
        }

        //Convert List<String> → String[]
        return ans.toArray(new String[0]);
    }
}
