class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        Map<Integer, List<Character>> tr = new TreeMap<>(Collections.reverseOrder());

        for (char ch : s.toCharArray())
            mp.merge(ch, 1, Integer::sum);

        for (Map.Entry<Character, Integer> et : mp.entrySet()) {
            int freq = et.getValue();
            char ch = et.getKey();

            tr.putIfAbsent(freq, new ArrayList<>());
            tr.get(freq).add(ch);
        }

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : tr.entrySet()) {
            int freq = entry.getKey();

            for (char ch : entry.getValue()) {

                ans.append(String.valueOf(ch).repeat(freq));

            }
        }

        return ans.toString();
    }
}