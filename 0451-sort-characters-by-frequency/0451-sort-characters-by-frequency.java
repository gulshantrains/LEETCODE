class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char ch : s.toCharArray())
            mp.merge(ch, 1, Integer::sum);

        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(mp.entrySet());

        StringBuilder ans=new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> temp=pq.poll();
            Character x=temp.getKey();
            int idx=temp.getValue();

            ans.append(String.valueOf(x).repeat(idx));

        }

        return ans.toString();
    }
}