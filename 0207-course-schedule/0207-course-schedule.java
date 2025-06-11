class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0); 

        // adj.get(i) will contain a list of courses that have 'i' as a prerequisite.
        // So, if course 'j' is in adj.get(i), it means there's an edge from i -> j.
        // This is equivalent to: to take 'j', you must first take 'i'.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int courseToTake = pre[0];   // This course needs a prerequisite
            int prerequisiteCourse = pre[1]; // This is the prerequisite course

            inDegree[courseToTake]++;

            // Add an edge from 'prerequisiteCourse' to 'courseToTake' in the adjacency list.
            // This means 'prerequisiteCourse' is a prerequisite for 'courseToTake'.
            adj.get(prerequisiteCourse).add(courseToTake);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i); 
            }
        }

        int coursesTakenCount = 0; // Count of courses that have been successfully "taken" (processed)

        // Process courses using Kahn's algorithm (Topological Sort)
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll(); // Get a course with no remaining prerequisites
            coursesTakenCount++;             // Increment the count of taken courses

            // Iterate through all courses that have 'currentCourse' as a prerequisite.
            // These are the 'neighbors' of 'currentCourse' in the graph.
            for (int neighbor : adj.get(currentCourse)) {
                
                inDegree[neighbor]--;

                // If the 'neighbor' course now has an in-degree of 0,
                // it means all its prerequisites have been met, so add it to the queue.
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return coursesTakenCount == numCourses;
    }
}