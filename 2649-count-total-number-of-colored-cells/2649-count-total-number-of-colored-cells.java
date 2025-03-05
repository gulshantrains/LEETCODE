/*
n=1-->1    1+0 
n=2-->5    4+1
n=3-->13   9+4
n=4-->25   16+9
...
n=n     n^2 + (n-1)^2 PATTERN AND WE CALL THIS DIAMOND PATTERn
*/
class Solution {
    public long coloredCells(int n) {
        return (long)n*n + (long)(n-1)*(n-1);
    }
}