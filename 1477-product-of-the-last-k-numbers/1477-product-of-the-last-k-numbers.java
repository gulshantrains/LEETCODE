//i was unable to find Optimal solution and also for case of when we get 0 as number
//whenever 0 comes reset array as uske phle sab 0 he honge 
class ProductOfNumbers {
    List<Integer> ls = new ArrayList<>();
    int p=1;

    public ProductOfNumbers() {
    }

    public void add(int num) {
        if (num == 0){
            ls=new ArrayList<>();
            p=1;
            return;
        }
        p *=num;
        ls.add(p);
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