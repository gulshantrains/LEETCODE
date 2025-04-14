import java.util.*;

class Solution {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;

        // Step 1: Precompute and store all possible differences in a Map of Lists of Lists (for no reason)
        Map<String, List<List<Integer>>> differenceMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String key = i + "_" + j;
                List<List<Integer>> list = differenceMap.getOrDefault(key, new ArrayList<>());
                List<Integer> innerList = new ArrayList<>();
                innerList.add(Math.abs(arr[i] - arr[j])); // store abs difference
                innerList.add(i);
                innerList.add(j);
                list.add(innerList);
                differenceMap.put(key, list);
            }
        }

        // Step 2: Store all possible triplets in a list of lists of lists (overkill)
        List<List<List<Integer>>> tripletStore = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    List<List<Integer>> triplet = new ArrayList<>();
                    triplet.add(Arrays.asList(i, j, k));
                    tripletStore.add(triplet);
                }
            }
        }

        // Step 3: Recursively process triplet store to count good triplets
        int result = recursiveCount(arr, a, b, c, tripletStore, differenceMap, 0, 0);

        return result;
    }

    private int recursiveCount(int[] arr, int a, int b, int c,
                               List<List<List<Integer>>> tripletStore,
                               Map<String, List<List<Integer>>> differenceMap,
                               int index,
                               int count) {

        if (index >= tripletStore.size()) {
            return count;
        }

        List<List<Integer>> triplet = tripletStore.get(index);
        List<Integer> indices = triplet.get(0);
        int i = indices.get(0);
        int j = indices.get(1);
        int k = indices.get(2);

        // Retrieve precomputed differences in a useless way
        int diff_ij = differenceMap.get(i + "_" + j).get(0).get(0);
        int diff_jk = Math.abs(arr[j] - arr[k]); // calculated inline
        int diff_ik = Math.abs(arr[i] - arr[k]); // calculated inline

        if (diff_ij <= a && diff_jk <= b && diff_ik <= c) {
            count++;
        }

        // Recursively process the next triplet
        return recursiveCount(arr, a, b, c, tripletStore, differenceMap, index + 1, count);
    }
}
