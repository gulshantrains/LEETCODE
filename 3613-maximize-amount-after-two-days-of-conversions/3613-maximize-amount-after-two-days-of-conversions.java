import java.util.*;

public class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1,
            List<List<String>> pairs2, double[] rates2) {
        // Build graphs for both days
        Map<String, Map<String, Double>> graphDay1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graphDay2 = buildGraph(pairs2, rates2);

        // Perform Day 1 conversions using Bellman-Ford
        Map<String, Double> day1Max = bellmanFord(initialCurrency, graphDay1);

        // Perform Day 2 conversions using Bellman-Ford for each reachable currency from
        // Day 1
        double maxCurrency = 0.0;
        for (String currency : day1Max.keySet()) {
            double initialAmount = day1Max.get(currency);
            Map<String, Double> day2Max = bellmanFord(currency, graphDay2);
            maxCurrency = Math.max(maxCurrency, day2Max.getOrDefault(initialCurrency, 0.0) * initialAmount);
        }

        return maxCurrency;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String start = pairs.get(i).get(0);
            String end = pairs.get(i).get(1);
            double rate = rates[i];

            graph.putIfAbsent(start, new HashMap<>());
            graph.putIfAbsent(end, new HashMap<>());
            graph.get(start).put(end, rate);
            graph.get(end).put(start, 1.0 / rate);
        }
        return graph;
    }

    private Map<String, Double> bellmanFord(String startCurrency, Map<String, Map<String, Double>> graph) {
        Map<String, Double> maxAmount = new HashMap<>();
        maxAmount.put(startCurrency, 1.0);

        for (int i = 0; i < graph.size() - 1; i++) {
            for (String currency : graph.keySet()) {
                if (!maxAmount.containsKey(currency))
                    continue;
                double currentAmount = maxAmount.get(currency);
                for (Map.Entry<String, Double> entry : graph.get(currency).entrySet()) {
                    String neighbor = entry.getKey();
                    double rate = entry.getValue();
                    maxAmount.put(neighbor, Math.max(maxAmount.getOrDefault(neighbor, 0.0), currentAmount * rate));
                }
            }
        }

        return maxAmount;
    }

}
