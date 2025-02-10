class Solution:
    def clearDigits(self, s: str) -> str:
        ans = []  # To store asnwer

        for char in s:
            #If char is number and len(ans) is not 0
            if char.isdigit() and ans:
                ans.pop() #Delete last index character
            else:
                ans.append(char)
                
        return "".join(ans)
