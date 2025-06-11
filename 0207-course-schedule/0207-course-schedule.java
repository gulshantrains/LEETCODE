class Solution {
    private int[] state; // 0: unvisited, 1: visiting, 2: visited
    private ArrayList<ArrayList<Integer>> adj; 

    private boolean hasCycleDFS(int n) {
        state[n] = 1; // Mark current node as 'visiting'

        for (int v : adj.get(n)) { // Iterate over neighbors
            if (state[v] == 0) { // If neighbor is unvisited
                if (hasCycleDFS(v)) { 
                    return true;     // Propagate the cycle detection
                }
            } else if (state[v] == 1) { // If neighbor is currently 'visiting' (in recursion stack)
                return true;            // Cycle detected (back-edge)
            }
            // If state[v] == 2, it means the neighbor has already been fully processed and is not part of a cycle.
            // We just skip it.
        }

        state[n] = 2; // Mark current node as 'visited' (fully processed, no cycle found through this path)
        return false; // No cycle found starting from this node or its descendants
    }

    public boolean canFinish(int nC, int[][] pre) {

        adj = new ArrayList<>(nC); // Initialize adj as a private member
        for (int i = 0; i < nC; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : pre) {
            int dependentCourse = p[0]; // Course that needs prerequisite
            int prerequisiteCourse = p[1]; // The prerequisite course

            adj.get(prerequisiteCourse).add(dependentCourse); // Edge: prerequisite -> dependent
        }

        state = new int[nC];
        Arrays.fill(state, 0);

        for (int i = 0; i < nC; i++) {
            if (state[i] == 0) { // If the course hasn't been visited yet
                if (hasCycleDFS(i)) { 
                    return false;     // If a cycle is detected, we cannot finish all courses
                }
            }
        }
        return true; 
    }
}