class Solution {
    // Find function for union-find data structure - finds the root parent of node x
    public int find(int x, int[] parent){
        if(parent[x]==x) return x; // If x is its own parent, return x (found the root)

        return parent[x]=find(parent[x],parent); // Path compression: recursively find root and update parent[x]
    }
    
    // Union function to merge two components - makes x the parent of y
    public void union(int x,int y,int[] parent){
        parent[y]=x; // Set x as the parent of y (merging two components)
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] ans=new int[query.length]; 
        
        int[] cost=new int[n]; // Array to track minimum cost for each component
        int[] parent=new int[n]; // Array to track parent relationships for union-find
        Arrays.fill(cost,-1); // Initialize all costs to -1 
        for(int i=0; i<n; i++) parent[i]=i; // Initialize each node as its own parent
        
        for(var x:edges){
            int u=x[0]; 
            int v=x[1]; 
            int w=x[2]; 
            
            int parent_u=find(u,parent); // Find root parent of u
            int parent_v=find(v,parent); // Find root parent of v
            
            if(parent_u != parent_v){ // If u and v are in different components
                cost[parent_u] &=cost[parent_v];
                union(parent_u,parent_v,parent); // Merge the two components
            }
            cost[parent_u] &=w; 
        }
        
        int i=0;
        for(var y:query){
            int s=y[0]; // Source node for query
            int t=y[1]; // Target node for query
            
            int p_s=find(s,parent); // Find root parent of source
            int t_s=find(t,parent); // Find root parent of target
            
            if(s==t) ans[i++]=0; // If source and target are the same, cost is 0
            else if(p_s != t_s) ans[i++]=-1; // If source and target are in different components, no path exists
            else ans[i++]=cost[p_s]; // Otherwise, return the cost of their common component
        }
        return ans; // Return array of answers for all queries
    }
}