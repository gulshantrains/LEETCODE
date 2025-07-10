class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by their start day
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to store the end days of available events
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int eventIndex = 0;
        int attendedEvents = 0;
        int n = events.length;

        // Iterate through each day, from day 1 up to the max possible day
        // To be safe, we can find the max end day, but a large enough number works if constraints are known.
        // A more efficient approach is to loop as long as there are events to process or attend.
        int currentDay = 0;
        while (eventIndex < n || !pq.isEmpty()) {
            // If the queue is empty and we have events left,
            // jump to the start day of the next event to save time.
            if (pq.isEmpty()) {
                currentDay = events[eventIndex][0];
            }

            // Add the end days of all events that start on the currentDay
            while (eventIndex < n && events[eventIndex][0] == currentDay) {
                pq.offer(events[eventIndex][1]);
                eventIndex++;
            }

            // Remove events from the queue that have already ended
            while (!pq.isEmpty() && pq.peek() < currentDay) {
                pq.poll();
            }

            // If there are events we can attend today, attend one.
            // We attend the one that ends the soonest (greedy choice).
            if (!pq.isEmpty()) {
                pq.poll();
                attendedEvents++;
            }

            // Move to the next day
            currentDay++;
        }

        return attendedEvents;
    }
}