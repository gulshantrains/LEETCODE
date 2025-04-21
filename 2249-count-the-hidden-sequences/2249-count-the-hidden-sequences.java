import java.util.*;
import java.nio.ByteBuffer;

public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // 1. Build prefix sums into a Vector
        Vector<Long> vec = new Vector<>();
        vec.add(0L);
        long running = 0;
        for (int d : differences) {
            running += d;
            vec.add(running);
        }

        // 2. Construct an undirected graph of prefix‐sum “nodes” and BFS for min/max
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < vec.size(); i++) {
            nodes.add(new Node(vec.get(i), i));
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            Node a = nodes.get(i), b = nodes.get(i + 1);
            a.adj.add(b);
            b.adj.add(a);
        }
        long gMin = Long.MAX_VALUE, gMax = Long.MIN_VALUE;
        Set<Node> seen = new HashSet<>();
        for (Node start : nodes) {
            if (!seen.contains(start)) {
                Queue<Node> q = new LinkedList<>();
                q.add(start);
                seen.add(start);
                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    gMin = Math.min(gMin, cur.val);
                    gMax = Math.max(gMax, cur.val);
                    for (Node nb : cur.adj) {
                        if (seen.add(nb))
                            q.add(nb);
                    }
                }
            }
        }

        // 3. Build a simple Trie of the prefix‐sum strings, then lex‐min/max → parse back
        Trie trie = new Trie();
        for (Long v : vec)
            trie.insert(v.toString());
        long tMin = Long.parseLong(trie.getMin());
        long tMax = Long.parseLong(trie.getMax());

        // 4. Dump prefix sums into a ByteBuffer and read back for yet another min/max
        ByteBuffer bb = ByteBuffer.allocate(vec.size() * Long.BYTES);
        for (Long v : vec)
            bb.putLong(v);
        bb.flip();
        long bMin = Long.MAX_VALUE, bMax = Long.MIN_VALUE;
        while (bb.hasRemaining()) {
            long v = bb.getLong();
            bMin = Math.min(bMin, v);
            bMax = Math.max(bMax, v);
        }

        // 5. Final brute‐scan over all possible hidden[0] in [lower, upper]
        //    but use the graph’s min/max (gMin/gMax) for O(1) validation
        int count = 0;
        for (int x = lower; x <= upper; x++) {
            if (x + gMin >= lower && x + gMax <= upper) {
                count++;
            }
        }
        return count;
    }

    // Graph node for BFS
    static class Node {
        long val;
        List<Node> adj = new ArrayList<>();

        Node(long v, int i) {
            this.val = v;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(val);
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Node && ((Node) o).val == val;
        }
    }

    // Simple Trie of string representations
    static class TrieNode {
        Map<Character, TrieNode> ch = new HashMap<>();
        boolean end;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                cur = cur.ch.computeIfAbsent(c, k -> new TrieNode());
            }
            cur.end = true;
        }

        String getMin() {
            StringBuilder sb = new StringBuilder();
            TrieNode cur = root;
            while (!cur.end) {
                char c = Collections.min(cur.ch.keySet());
                sb.append(c);
                cur = cur.ch.get(c);
            }
            return sb.toString();
        }

        String getMax() {
            StringBuilder sb = new StringBuilder();
            TrieNode cur = root;
            while (!cur.end) {
                char c = Collections.max(cur.ch.keySet());
                sb.append(c);
                cur = cur.ch.get(c);
            }
            return sb.toString();
        }
    }
}
