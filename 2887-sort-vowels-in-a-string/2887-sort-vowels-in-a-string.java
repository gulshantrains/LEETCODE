class Solution {
    public String sortVowels(String s) {
        List<String> vow = new ArrayList<>();

        for (var x : s.toCharArray()) {
            if ("AEIOUaeiou".contains(String.valueOf(x)))
                vow.add(String.valueOf(x));
        }
        Collections.sort(vow);

        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (var x : s.toCharArray()) {
            if (!"AEIOUaeiou".contains(String.valueOf(x))) {
                ans.append(x);
            } else {
                ans.append(vow.get(i++));
            }
        }
        return ans.toString();
    }
}