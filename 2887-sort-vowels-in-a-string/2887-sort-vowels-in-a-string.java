class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> vow = new ArrayList<>();

        for (char x : s.toCharArray()) {
            if (vowels.contains(x)) {
                vow.add(x);
            }
        }

        Collections.sort(vow);

        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (char x : s.toCharArray()) {
            if (vowels.contains(x)) {
                ans.append(vow.get(i++));
            } else {
                ans.append(x);
            }
        }

        return ans.toString();
    }
}
