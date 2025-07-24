/**
 * Solves the problem of finding the minimum score after removing two edges from a tree.
 * The score is defined as the difference between the largest and smallest XOR sums
 * of the three resulting components.
 */
class Solution {
    // Adjacency list to represent the tree
    private List<List<Integer>> adj;
    // Array of node values
    private int[] nums;
    // Stores the XOR sum of the subtree rooted at each node
    private int[] subtreeXor;
    // Discovery/entry times for DFS traversal (for subtree checks)
    private int[] tin;
    // Finish/exit times for DFS traversal
    private int[] tout;
    // A timer to assign entry and exit times during DFS
    private int time;
    // The total number of nodes in the tree
    private int n;

    /**
     * Main method to calculate the minimum score.
     *
     * @param nums  An array where nums[i] is the value of the ith node.
     * @param edges A 2D array representing the undirected edges of the tree.
     * @return The minimum possible score.
     */
    public int minimumScore(int[] nums, int[][] edges) {
        this.n = nums.length;
        this.nums = nums;
        this.adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build the adjacency list from the edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize helper arrays
        this.subtreeXor = new int[n];
        this.tin = new int[n];
        this.tout = new int[n];
        this.time = 0;

        // Perform DFS from root 0 to pre-calculate subtree XORs and traversal times.
        // The parent of the root is marked as -1.
        dfs(0, -1);

        // The XOR sum of the entire tree is the XOR sum of the subtree at the root (0).
        int totalXor = subtreeXor[0];
        int minScore = Integer.MAX_VALUE;

        // Iterate through all distinct pairs of nodes (i, j) to simulate removing
        // the edges connecting them to their parents. We start from 1 as node 0 is the root.
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xorA, xorB, xorC;

                // Check the relationship between the subtrees of i and j using their
                // discovery and finish times.
                boolean jInISubtree = tin[i] < tin[j] && tout[j] < tout[i];
                boolean iInJSubtree = tin[j] < tin[i] && tout[i] < tout[j];

                if (jInISubtree) {
                    // Case 1: Subtree 'j' is nested inside subtree 'i'.
                    // The three components are: subtree j, (subtree i - subtree j), and (total tree - subtree i).
                    xorA = subtreeXor[j];
                    xorB = subtreeXor[i] ^ subtreeXor[j];
                    xorC = totalXor ^ subtreeXor[i];
                } else if (iInJSubtree) {
                    // Case 2: Subtree 'i' is nested inside subtree 'j'.
                    // The three components are: subtree i, (subtree j - subtree i), and (total tree - subtree j).
                    xorA = subtreeXor[i];
                    xorB = subtreeXor[j] ^ subtreeXor[i];
                    xorC = totalXor ^ subtreeXor[j];
                } else {
                    // Case 3: Subtrees 'i' and 'j' are disjoint.
                    // The three components are: subtree i, subtree j, and the rest of the tree.
                    xorA = subtreeXor[i];
                    xorB = subtreeXor[j];
                    xorC = totalXor ^ subtreeXor[i] ^ subtreeXor[j];
                }

                // Calculate the score for this pair of edge removals.
                int maxVal = Math.max(xorA, Math.max(xorB, xorC));
                int minVal = Math.min(xorA, Math.min(xorB, xorC));
                
                // Update the overall minimum score.
                minScore = Math.min(minScore, maxVal - minVal);
            }
        }

        return minScore;
    }

    /**
     * Performs a Depth-First Search to calculate the XOR sum of each subtree
     * and to record the discovery and finish times for each node.
     *
     * @param u      The current node being visited.
     * @param parent The parent of the current node in the DFS traversal.
     * @return The XOR sum of the subtree rooted at node u.
     */
    private int dfs(int u, int parent) {
        // Record the discovery time for node u.
        tin[u] = time++;
        
        // Start the XOR sum with the value of the current node.
        int currentXor = nums[u];
        
        // Recursively visit all children.
        for (int v : adj.get(u)) {
            if (v != parent) {
                // Accumulate the XOR sum from the children's subtrees.
                currentXor ^= dfs(v, u);
            }
        }
        
        // Store the final XOR sum for the subtree rooted at u.
        subtreeXor[u] = currentXor;
        
        // Record the finish time for node u.
        tout[u] = time++;
        
        return currentXor;
    }
}
