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
            return b.idx - a.idx;
        });

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (!pq.isEmpty())
                    pq.poll();
            } else {
                pq.offer(new Pair(ch, i));
            }
        }

        // Extract indices and sort
        List<Integer> ls = new ArrayList<>();
        while (!pq.isEmpty()) {
            ls.add(pq.poll().idx);
        }
        Collections.sort(ls);

        StringBuilder sb = new StringBuilder();
        for (int idx : ls) {
            sb.append(s.charAt(idx));
        }

        return sb.toString();
    }
}
