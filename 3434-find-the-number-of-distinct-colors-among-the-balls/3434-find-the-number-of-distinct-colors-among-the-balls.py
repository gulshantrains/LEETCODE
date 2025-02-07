class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        ball_colour = {}  # Maps ball -> colour
        colour_count = defaultdict(int) #Maps colour->count,auto-initializes missing keys to 0
        distinct = 0  # Keeps track of the number of distinct colours
        ans = []

        for ball, colour in queries:
            # If the ball already exists and its colour is unchanged, no update is needed.
            if ball in ball_colour:
                if ball_colour[ball] == colour:
                    ans.append(distinct)
                    continue
                # Decrement the count for the old colour.
                old_colour = ball_colour[ball]
                colour_count[old_colour] -= 1
                if colour_count[old_colour] == 0:
                    distinct -= 1

            # Update the ball's colour.
            ball_colour[ball] = colour
            # If this colour was not present before, update the distinct count.
            if colour_count[colour] == 0:
                distinct += 1
            colour_count[colour] += 1

            ans.append(distinct)

        return ans
