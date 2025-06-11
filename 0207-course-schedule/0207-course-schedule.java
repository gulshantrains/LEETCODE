class Solution {
    public boolean canFinish(int nC, int[][] pre) {
        int[] ind = new int[nC];
        Arrays.fill(ind, 0);

        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        for (int[] x : pre) {
            int to = x[0]; // Course i want to take
            int from = x[1]; // Prerequisite course

            mp.putIfAbsent(from, new ArrayList<>());
            mp.get(from).add(to); // Directed edge: from → to

            ind[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nC; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0; //Count how many pop out 
        while (!q.isEmpty()) {
            int v = q.poll();
            cnt++;

            if (mp.containsKey(v)) {
                for (int dependentCourse : mp.get(v)) {
                    ind[dependentCourse]--;

                    if (ind[dependentCourse] == 0) {
                        q.add(dependentCourse);
                    }
                }
            }
        }
        return cnt == nC;
    }
}
