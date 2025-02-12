class Solution:
    def maximumSum(self, nums: List[int]) -> int:

        ans = -1  # Initialize answer to -1 (if no valid pair exists)
        dig = [0] * 90  # Array to store the largest number for each digit sum

        for x in nums:
            digit_sum = self.get_digit(x)  # Compute sum of digits of x

            if dig[digit_sum] != 0:  # If a number with the same digit sum exists
                t_sum = dig[digit_sum] + x  # Compute potential max sum
                ans = max(ans, t_sum)  # Update global max sum

                dig[digit_sum] = max(dig[digit_sum], x)  # Store the larger number
            else:
                dig[digit_sum] = x  # Store the first occurrence of a digit sum

        return ans

    def get_digit(self, num: int) -> int:
        s = 0
        while num != 0:
            s += num % 10
            num //= 10
        return s
