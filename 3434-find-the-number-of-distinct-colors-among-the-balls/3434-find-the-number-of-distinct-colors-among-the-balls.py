class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        ball_colour = {}  # To store ball -> colour mapping
        colour_count = {}  # To store the count of balls for each colour
        ans = []

        for ball, colour in queries:
            # If the ball already has a colour, decrement the count for its previous colour.
            if ball in ball_colour:
                prev_colour = ball_colour[ball]
                colour_count[prev_colour] -= 1

                # If no balls of the previous colour remain, remove it from the dictionary.
                if colour_count[prev_colour] <= 0:
                    del colour_count[prev_colour]

            # Update the ball's colour.
            ball_colour[ball] = colour

            # Increment the count for the new colour.
            colour_count[colour] = colour_count.get(colour, 0) + 1

            # Append the number of unique colours (keys in colour_count) to the answer list.
            ans.append(len(colour_count))

        return ans