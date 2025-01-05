class Solution:
    def maxLength(self, nums: List[int]) -> int:
        def lcm(a, b):
            return (a * b) // gcd(a, b)

        ans = 0
        for i in range(len(nums)):
            lcm_v = gcd_v = prod_v = nums[i]

            for j in range(i + 1, len(nums)):
                prod_v *= nums[j]
                gcd_v = gcd(gcd_v, nums[j]) #Inbuilt in Python 
                lcm_v = lcm(lcm_v, nums[j]) # Defined Above
                if prod_v == (gcd_v * lcm_v):
                    ans = max(ans, j - i + 1)
        return ans
