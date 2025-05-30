class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Use a stack to keep track of asteroids that are still "alive" and moving right,
        // or left-moving asteroids that have survived all collisions with right-moving ones to their left.
        // The stack effectively represents the asteroids from left to right.
        Stack<Integer> st = new Stack<>();

        for (var currentAsteroid : asteroids) {
            // 'exploded' flag: True if the 'currentAsteroid' explodes during collision checks.
            // If it explodes, it should not be pushed onto the stack.
            boolean exploded = false;

            // Collision logic:
            // This loop continues as long as a collision is possible and the currentAsteroid hasn't exploded.
            // A collision occurs ONLY if:

            // 1. The stack is not empty (there's an asteroid to collide with).
            // 2. The asteroid at the top of the stack (st.peek()) is moving RIGHT (positive).
            // 3. The 'currentAsteroid' being processed is moving LEFT (negative).
            //    This simulates a right-moving asteroid on the stack colliding with an incoming left-moving asteroid.
            while (!st.isEmpty() && st.peek() > 0 && currentAsteroid < 0) {
               
                int topAsteroidSize = st.peek();

                if (Math.abs(topAsteroidSize) > Math.abs(currentAsteroid)) {
                    // Case 1: The asteroid on the stack is larger.
                    // The 'currentAsteroid' explodes.
                    exploded = true;
                    // Since 'currentAsteroid' exploded, it won't collide with anything else on the stack.
                    // Break out of the inner while loop to process the next asteroid from the input array.
                    break;
                } else if (Math.abs(topAsteroidSize) < Math.abs(currentAsteroid)) {
                    // Case 2: The 'currentAsteroid' is larger.
                    // The asteroid on the stack explodes.
                    st.pop(); // Remove the exploded asteroid from the stack.
                    // 'currentAsteroid' survives and continues moving left.
                    // The loop will continue to check 'currentAsteroid' against the new top of the stack.
                } else { // Math.abs(topAsteroidSize) == Math.abs(currentAsteroid)
                    // Case 3: Both asteroids are of the same size.
                    // Both asteroids explode.
                    st.pop(); // Remove the exploded asteroid from the stack.
                    exploded = true; // Mark 'currentAsteroid' as exploded.
                    // Since both exploded, no further action is needed for this 'currentAsteroid'.
                    // Break out of the inner while loop.
                    break;
                }
            }
            if (!exploded) {
                st.push(currentAsteroid);
            }
        }

        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}
