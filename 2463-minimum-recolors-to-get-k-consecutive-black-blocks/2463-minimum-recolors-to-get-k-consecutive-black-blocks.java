class Solution {
    public int minimumRecolors(String blo, int k) {
        int minop=100000, curr=0;

    //Check for first Window of size 'k'
        for(int i=0; i<k; i++){
            if(blo.charAt(i)=='W') curr++;
        }
        minop=curr; //Assign value to min

        //Now check for all window by sliding one by one
        for(int i=k; i<blo.length(); i++){
            // If the character which exited the window is 'W' decrease count
            if(blo.charAt(i-k)=='W') curr--;

            //If character which entered the window if 'W' increase the count
            if(blo.charAt(i)=='W') curr++;

            minop=Math.min(minop,curr);
        }
        return minop;
    }
}