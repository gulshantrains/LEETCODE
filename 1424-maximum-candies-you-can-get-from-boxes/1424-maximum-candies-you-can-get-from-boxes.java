class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        
        // Track which boxes we have and which we can open
        boolean[] hasBox = new boolean[n];
        boolean[] canOpen = new boolean[n];
        boolean[] opened = new boolean[n];
        
        // Mark initial boxes as available
        for (int box : initialBoxes) {
            hasBox[box] = true;
        }
        
        // Mark boxes that are already open (status[i] == 1)
        for (int i = 0; i < n; i++) {
            if (status[i] == 1) {
                canOpen[i] = true;
            }
        }
        
        int totalCandies = 0;
        boolean changed = true;
        
        // Keep trying to open boxes until no more progress can be made
        while (changed) {
            changed = false;
            
            for (int i = 0; i < n; i++) {
                // If we have the box, can open it, but haven't opened it yet
                if (hasBox[i] && canOpen[i] && !opened[i]) {
                    opened[i] = true;
                    changed = true;
                    
                    // Collect candies from this box
                    totalCandies += candies[i];
                    
                    // Get all keys from this box
                    for (int key : keys[i]) {
                        canOpen[key] = true;
                    }
                    
                    // Get all contained boxes
                    for (int box : containedBoxes[i]) {
                        hasBox[box] = true;
                    }
                }
            }
        }
        
        return totalCandies;
    }
}