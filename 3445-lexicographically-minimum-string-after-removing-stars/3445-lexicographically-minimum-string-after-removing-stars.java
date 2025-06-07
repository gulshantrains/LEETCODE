class Solution {

    public String clearStars(String s) {
        int n = s.length();

        TreeMap<Character, Stack<Integer>> mp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);

            if (temp == '*') {
                if (!mp.isEmpty()) {
                    char minChar = mp.firstKey();
                    Stack<Integer> stack = mp.get(minChar);
                    stack.pop(); // remove largest index of that char

                    if (stack.isEmpty()) {
                        mp.remove(minChar);
                    }
                }
            } else {
                mp.putIfAbsent(temp, new Stack<>());
                mp.get(temp).push(i);
            }
        }

        // Gather all remaining indices and sort
        List<Integer> indices = new ArrayList<>();
        
        for (Stack<Integer> stack : mp.values()) {
            indices.addAll(stack);
        }

        Collections.sort(indices);

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (int idx : indices) {
            sb.append(s.charAt(idx));
        }

        return sb.toString();
    }
}
