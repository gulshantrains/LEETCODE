class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        max_leftscore = [0] * len(values)
        max_leftscore[0] = values[0]
        maxscore = 0

        for i in range(1, len(values)):
            max_rscore = values[i] - i
            maxscore = max(max_rscore + max_leftscore[i - 1], maxscore)

            maxlscr = values[i] + i 
            max_leftscore[i] = max(max_leftscore[i - 1], maxlscr)
        return maxscore
