class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            int val = st.pop();
            if (!minSt.isEmpty() && val == minSt.peek()) {
                minSt.pop();
            }
        }
    }

    public int top() {
        return st.isEmpty() ? -1 : st.peek(); // or Integer.MAX_VALUE or another sentinel
    }

    public int getMin() {
        return minSt.isEmpty() ? -1 : minSt.peek();
    }

}
