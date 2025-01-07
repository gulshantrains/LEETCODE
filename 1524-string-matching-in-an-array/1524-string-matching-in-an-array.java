class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> lst = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String old = words[i];

            for (int j = 0; j < words.length; j++) {
                String newest = words[j];
                if (i != j) {
                    if (!lst.contains(newest) && old.contains(newest))
                        lst.add(newest);
                }
            }

        }
        return lst;
    }
}