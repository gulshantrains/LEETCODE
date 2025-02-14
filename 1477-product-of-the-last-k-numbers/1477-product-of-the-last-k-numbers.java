//i was unable to find Optimal solution and also for case of when we get 0 as number
//whenever 0 comes reset array as uske phle sab 0 he honge 
class ProductOfNumbers {
    List<Integer> ls = new ArrayList<>();

    public ProductOfNumbers() {
    }

    public void add(int num) {
        if (num == 0)
            ls.clear();
        else if (ls.size() == 0) {
            ls.add(num);
        } else {
            ls.add(num * ls.get(ls.size() - 1));
        }
    }

    public int getProduct(int k) {
        if (k == ls.size())
            return ls.get(ls.size() - 1);

        if (k > ls.size())
            return 0;

        return ls.get(ls.size() - 1) / ls.get(ls.size() - k - 1);

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */