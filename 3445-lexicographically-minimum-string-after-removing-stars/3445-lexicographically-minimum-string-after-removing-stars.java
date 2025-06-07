class Solution {
    class Pair {
        char ch;
        int idx;

        Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public String clearStars(String s) {
        int n = s.length();

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.ch != b.ch)
                return a.ch - b.ch;
            else
                return b.idx - a.idx;
        });

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);

            if (temp == '*' && pq.isEmpty())
                continue;
            else if (temp != '*') {
                pq.offer(new Pair(temp, i));
            } else {
                pq.poll();
            }
        }
        if (pq.isEmpty())
            return "";

        ArrayList<Integer> ls = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            ls.add(temp.idx);
        }
        Collections.sort(ls);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < ls.size(); i++) {
            ans.append(s.charAt(ls.get(i)));
        }

        return ans.toString();
    }
}