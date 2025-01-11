class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length())
            return false;

        int[] chridx = new int[26];
        int odd = 0;

        for (var x : s.toCharArray()) {
            chridx[x - 'a']++;
        }
        for (int x : chridx) {
            if (x % 2 != 0) //count odd wla ka number
                odd++;
        }
        if (odd > k) //Odd fre wale he decide krte hai kitne palindrom honge
            return false; //agr odd wale > K ,then we can make minimum odd no of 
                         //odd times palindrome
        return true;
    }
}