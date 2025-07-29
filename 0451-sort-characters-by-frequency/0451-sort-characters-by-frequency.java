class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        Map<Integer, List<Character>> tr = new TreeMap<>(Collections.reverseOrder());

        for (char ch : s.toCharArray())
            mp.merge(ch, 1, Integer::sum);

        for (var et : mp.entrySet()) { //var-->Map.Entry<Character, Integer>
            int freq = et.getValue();
            char ch = et.getKey();

            tr.putIfAbsent(freq, new ArrayList<>());
            tr.get(freq).add(ch);
        }

        StringBuilder ans = new StringBuilder();
        for (var entry : tr.entrySet()) { //var-->Map.Entry<Integer, List<Character>>
            int freq = entry.getKey();

            for (char ch : entry.getValue()) {

                ans.append(String.valueOf(ch).repeat(freq));

            }
        }

        return ans.toString();
    }
}