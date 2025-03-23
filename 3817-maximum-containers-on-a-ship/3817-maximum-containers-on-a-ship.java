class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int total=maxWeight / w; //Total How many containers are possible
        int org=n*n*w; //Can load how many

        if(org<maxWeight) return n*n;
        return total;
    }
}