package com.wenqi.demo01.grah.shortpath;


import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wenqi Liang
 * @date 2023/12/9
 */
public class DijkstraShortestPath {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        test01(graph);
        test02(graph);
    }

    private static void test02(int[][] graph) {
        dijkstra(graph, 0);
    }

    private static void test01(int[][] graph) {
        List<Integer> found = Lists.newArrayList(0);
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;

        Map<Integer, Pair<Integer, List<Integer>>> pathMap = new HashMap<>();
        pathMap.put(0, new Pair<>(0, Lists.newArrayList(0)));

        dijkstra(graph, found, visited, pathMap);
    }

    public static void dijkstra(int[][] graph, List<Integer> found, boolean[] visited, Map<Integer, Pair<Integer, List<Integer>>> pathMap) {
        int length = graph.length;
        if (found.size() == length) {
            return;
        }

        int min = Integer.MAX_VALUE;
        int index = -1;
        int last = -1;
        for (int vertex : found) {
            for (int i = 0; i < length; i++) {
                int v = graph[vertex][i];
                if (!visited[i] && v != 0 && min > v + pathMap.get(vertex).getKey()) {
                    min = v + pathMap.get(vertex).getKey();
                    index = i;
                    last = vertex;
                }
            }
        }


        if (min != Integer.MAX_VALUE) {
            found.add(index);
            Pair<Integer, List<Integer>> pair = pathMap.get(last);
            List<Integer> newList = new ArrayList<>(pair.getValue());
            newList.add(index);
            pathMap.put(index, new Pair<>(min, newList));
            visited[index] = true;

            System.out.println("found one, index: "+ index + ", distance: " + min + ", path: " + newList);
        }

        dijkstra(graph, new ArrayList<>(found), visited, pathMap);
    }


    public static void dijkstra(int[][] graph, int start) {
        int numVertices = graph.length;
        int[] distance = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != INF && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance);
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < distance.length; v++) {
            if (!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printSolution(int[] distance) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }


}
