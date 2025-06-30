/**
 * Solution class to determine if a set of equations involving single-letter
 * variables can be satisfied.
 * It utilizes the Disjoint Set Union (DSU) data structure (also known as Union-Find)
 * to manage equivalence relations between variables.
 */
class Solution {

    // rank array for optimizing union operations (union by rank)
    // rank[i] stores the rank (approximate height) of the tree rooted at i.
    public static int[] rank;

    // parent array for representing the Disjoint Set Union structure
    // parent[i] stores the parent of element i. If parent[i] == i, then i is the root of its set.
    public static int[] parent;

    public int find(int x) {
        // Base case: if x is its own parent, it is the root of the set.
        if (x == parent[x])
            return x;

        // Path compression: set parent[x] directly to the root of its current parent.
        // This flattens the tree, making future find operations faster.
        parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int x, int y) {
        // Find the roots of the sets containing x and y.
        int x_root = find(x);
        int y_root = find(y);

        // If x and y are already in the same set, do nothing.
        if (x_root == y_root)
            return;

        // Union by rank: Attach the tree with the smaller rank under the root
        // of the tree with the larger rank. This helps keep the trees flat.
        if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root; // Make y_root the parent of x_root
        } else if (rank[y_root] < rank[x_root]) {
            parent[y_root] = x_root; // Make x_root the parent of y_root
        } else {
            // If ranks are equal, choose one as the parent (e.g., y_root)
            // and increment its rank as the tree height effectively increases.
            parent[x_root] = y_root;
            rank[y_root]++;
        }
    }

    public boolean equationsPossible(String[] eq) {
        // Initialize rank and parent arrays for 26 lowercase English letters.
        // 'a' corresponds to index 0, 'b' to 1, ..., 'z' to 25.
        rank = new int[26];
        parent = new int[26];

        // Initialize ranks to 0.
        Arrays.fill(rank, 0);

        // Each character is initially in its own set (itself is its parent).
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        // First pass: Process all '==' (equality) equations.
        // These equations establish equivalence relations between variables.
        for (var c : eq) {
            // Check if the operator is '=='
            if (c.charAt(1) == '=') {
                // Convert characters to 0-25 integer indices by subtracting 'a'.
                // Then, unite the sets of these two variables.
                union(c.charAt(0) - 'a', c.charAt(3) - 'a');
            }
        }

        // Second pass: Process all '!=' (inequality) equations.
        // Now, we check if any '!=' equation contradicts the established equivalences.
        for (var c : eq) {
            // Check if the operator is '!'
            if (c.charAt(1) == '!') {
                // Find the roots (representatives) of the sets for both variables.
                // It's crucial to convert characters to 0-25 indices first.
                int first_par_root = find(c.charAt(0) - 'a');
                int second_par_root = find(c.charAt(3) - 'a');

        // If the roots are the same, it means the two variables are in the same set
        // (i.e., they are equivalent according to '==' equations).
        // However, the current equation states they are not equal, which is a contradiction.
                if (first_par_root == second_par_root)
                    return false; // Contradiction found, so return false.
            }
        }

        // If the second pass completes without finding any contradictions,
        // it means all equations can be satisfied.
        return true;
    }
}