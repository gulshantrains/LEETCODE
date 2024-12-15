class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare
        (gain(b[0], b[1]), gain(a[0], a[1])));

        double sum = 0;

        for (int[] x : classes) {
            pq.add(new double[] { x[0], x[1] });
        }
        while (extraStudents > 0) {
            double[] top = pq.poll(); // Class with maximum potential gain
            top[0]++; // Add one student to passes
            top[1]++; // Add one student to total
            pq.add(top); // Reinsert the updated class into the PriorityQueue
            extraStudents--;
        }
        while(!pq.isEmpty()){
            double[] v=pq.poll();
            sum +=v[0]/v[1];
        }
        return sum/classes.length;

    }
     private double gain(double pass, double total) {
        double currentRatio = pass / total;
        double newRatio = (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}