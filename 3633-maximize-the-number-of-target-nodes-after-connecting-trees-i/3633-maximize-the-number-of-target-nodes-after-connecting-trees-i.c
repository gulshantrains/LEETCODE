int dfs(int node, int parent, int** children, int* childrenColSize, int k) {
    if (k < 0) {
        return 0;
    }
    int res = 1;
    for (int i = 0; i < childrenColSize[node]; i++) {
        int child = children[node][i];
        if (child == parent) {
            continue;
        }
        res += dfs(child, node, children, childrenColSize, k - 1);
    }
    return res;
}

int* build(int** edges, int edgesSize, int k) {
    int n = edgesSize + 1;
    int** children = (int**)malloc(n * sizeof(int*));
    int* childrenColSize = (int*)malloc(n * sizeof(int));
    memset(childrenColSize, 0, n * sizeof(int));
    for (int i = 0; i < edgesSize; i++) {
        childrenColSize[edges[i][0]]++;
        childrenColSize[edges[i][1]]++;
    }
    for (int i = 0; i < n; i++) {
        children[i] = (int*)malloc(childrenColSize[i] * sizeof(int));
        childrenColSize[i] = 0;
    }
    for (int i = 0; i < edgesSize; i++) {
        children[edges[i][0]][childrenColSize[edges[i][0]]++] = edges[i][1];
        children[edges[i][1]][childrenColSize[edges[i][1]]++] = edges[i][0];
    }
    int* res = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        res[i] = dfs(i, -1, children, childrenColSize, k);
    }
    for (int i = 0; i < n; i++) {
        free(children[i]);
    }
    free(children);
    free(childrenColSize);
    return res;
}

int* maxTargetNodes(int** edges1, int edges1Size, int* edges1ColSize,
                    int** edges2, int edges2Size, int* edges2ColSize, int k,
                    int* returnSize) {
    int n = edges1Size + 1;
    int* count1 = build(edges1, edges1Size, k);
    int* count2 = build(edges2, edges2Size, k - 1);
    int maxCount = 0;
    for (int i = 0; i < edges2Size + 1; i++) {
        if (count2[i] > maxCount) {
            maxCount = count2[i];
        }
    }
    int* res = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        res[i] = count1[i] + maxCount;
    }
    *returnSize = n;
    free(count1);
    free(count2);
    return res;
}