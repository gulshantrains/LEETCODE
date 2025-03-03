class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
      List<Integer> min=new ArrayList<>();
      List<Integer> max=new ArrayList<>();
      List<Integer> piv=new ArrayList<>();

      for(int x: nums){
        if(x<pivot) min.add(x);
        else if(x>pivot) max.add(x);
        else piv.add(x);
      }
      min.addAll(piv);
      min.addAll(max);

      int[] result = new int[min.size()];
      for (int i = 0; i < min.size(); i++) result[i] = min.get(i);

      return result;

    }
}