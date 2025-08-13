/*
    3^n < 2^31  
    log₂(3^n) < log₂(2^31)
    n * log₂(3) < 31
    
    n < 31 / log₂(3)
    log₂(3) ≈ 1.58496
    
    n < 31 / 1.58496 ≈ 19.56 ----> So n value must be less than 20 
    And if number is prime then its power multiple is just smaller power of that number only
    
    */
class Solution {

    public boolean isPowerOfThree(int n) {
        
        // int x=(int)Math.pow(3,19);
        // System.out.println(x);
        return (n > 0 && 1162261467 % n == 0);
    }
}