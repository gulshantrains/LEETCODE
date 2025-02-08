class NumberContainers {

    HashMap<Integer,Integer> idxTonum=new HashMap<>();
    HashMap<Integer,PriorityQueue<Integer>> numToidxs=new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        //Add index->number
        idxTonum.put(index,number); 

        //If number is not in {num->index} then add no and also queue
        if(!numToidxs.containsKey(number)){
            numToidxs.put(number,new PriorityQueue<>());
        }
        numToidxs.get(number).offer(index); //Put index to number
    }
    public int find(int number) {
        if(!numToidxs.containsKey(number)) return -1; //Not present
        //Get all index of that number
        PriorityQueue<Integer> indexs=numToidxs.get(number);

        //Check until we find minimum
        while(!indexs.isEmpty()){
            int x=indexs.peek();
    //Lazy Update(baad me check kro ki ess index p avi v woo available hai yaa nhi)
            if(idxTonum.get(x)==number) return x;

            indexs.poll();//agr koi aur number hai tb poll kro
        }
        return -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */