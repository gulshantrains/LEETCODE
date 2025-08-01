class Solution {
    public static int[] rank;   
    public static int[] parent; 

    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); 
    }

    public void union(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if (x_root == y_root) return; 

        if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        } else if (rank[y_root] < rank[x_root]) {
            parent[y_root] = x_root;
        } else {
            parent[y_root] = x_root;
            rank[x_root]++; 
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> A) {
        int n = A.size();
        rank = new int[n];
        parent = new int[n];

        // Initialize DSU: each account is its own parent initially
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }

        // Map each email to the first account index (id) it appears in
        Map<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            List<String> acc = A.get(i); //Whole String Arrays contains Everthing

            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i); // First time seeing this email so Assign Id
                } else {
                    // Union the current account with the account where this email was first seen
                    union(i, emailToId.get(email));
                }
            }
        }

        // Group all emails under their ultimate (root) parent account id
        Map<Integer, List<String>> idToMail = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int rootId = find(emailToId.get(email)); // Find the root id (representative) of this email

            idToMail.computeIfAbsent(rootId, k -> new ArrayList<>()).add(email); // Add to that root's group
        }

        // Build the final merged accounts list
        List<List<String>> ans = new ArrayList<>();
        for (Integer id : idToMail.keySet()) {
            List<String> emails = idToMail.get(id); //Whole Email Array of that Id
            
            Collections.sort(emails); // Sort emails lexicographically
            emails.add(0, A.get(id).get(0)); // Add the user's name at the front (from original account list)
            ans.add(emails); // Add the complete merged entry to result
        }

        return ans;
    }
}
