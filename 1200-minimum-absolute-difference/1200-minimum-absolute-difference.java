class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int mindiff = (int) 1e9 + 7;

        for (int i = 1; i < arr.length; i++) {
            int val = Math.abs(arr[i] - arr[i - 1]);

            mindiff = Math.min(val, mindiff);
        }

        System.out.println(mindiff);

        for (int i = 1; i < arr.length; i++) {

            if (Math.abs(arr[i] - arr[i - 1]) == mindiff) {
                ArrayList<Integer> temp = new ArrayList<>();
                //System.out.println("Inside Loop");

                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                ans.add(temp);
                
                // System.out.println(temp.get(0));
            }

        }

        return ans;
    }
}