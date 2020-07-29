package graphs;

import java.util.*;

public class TopologicalSorting {

    public int[] topologicalSort1(int[][] prerequisites) {
        int[] topologicalSort = new int[prerequisites.length];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        //build graph
        for(int[] dep: prerequisites) {
            int src = dep[1], dest = dep[0];
            if(!adjList.containsKey(src))
                adjList.put(src, new LinkedList<>());
            adjList.get(src).add(dest);
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> solution = new Stack<>();
        dfsUtil(prerequisites[0][1], adjList, visited, solution);

        for (Map.Entry<Integer, List<Integer>> entry: adjList.entrySet())
            dfsUtil(entry.getKey(), adjList, visited, solution);

        if(solution.size() != prerequisites.length)
            return new int[0];
        for(int i=0; i<prerequisites.length; i++)
            topologicalSort[i++] = solution.pop();
        return topologicalSort;
    }

    private void dfsUtil(Integer curr, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visited, Stack<Integer> solution) {
        if(curr == null)
            return;

        if(visited.containsKey(curr))
            return;
        visited.put(curr, true);
        if(adjList.containsKey(curr)) {
            for (Integer child : adjList.get(curr)) {
                dfsUtil(child, adjList, visited, solution);
            }
        }
        solution.push(curr);
    }

    public static void main(String[] args) {
        int[][] data = {
                {0, 5},
                {0, 4},
                {2, 5},
                {3, 2},
                {1,3},
                {1, 4},
                {0, 2}
        };

        new TopologicalSorting().topologicalSort1(data);
    }
}
