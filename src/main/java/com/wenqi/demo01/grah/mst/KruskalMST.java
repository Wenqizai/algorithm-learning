package com.wenqi.demo01.grah.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Kruskal 算法:
 * <p>
 * 1. 将图的所有边按权值从小到大排序。
 * 2. 从最小的边开始，依次将边加入最小生成树，但要保证加入该边不形成环。
 * 3. 重复步骤 2，直到最小生成树中包含所有顶点。
 *
 * @author Wenqi Liang
 * @date 2023/11/25
 */
public class KruskalMST {
    public static void main(String[] args) {
        int numVertices = 5;
        Edge[] edges = {
                new Edge(0, 1, 2),
                new Edge(0, 3, 6),
                new Edge(1, 2, 3),
                new Edge(1, 3, 8),
                new Edge(1, 4, 5),
                new Edge(2, 4, 7),
                new Edge(3, 4, 9)
        };

        int minWeight = kruskal(edges, numVertices);
        System.out.println("Minimum Weight of MST: " + minWeight);
    }

    public static int kruskal(Edge[] edges, int numVertices) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));
        List<Edge> edgeList = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];

        findEdge(edgeList, edges, visited);

        int minWeight = 0;

        for (Edge edge : edgeList) {
            minWeight += edge.weight;
        }

        return minWeight;
    }

    private static void findEdge(List<Edge> edgeList, Edge[] edges, boolean[] visited) {
        for (Edge edge : edges) {
            if (!visited[edge.src] || !visited[edge.dest]) {
                edgeList.add(edge);
                visited[edge.src] = true;
                visited[edge.dest] = true;
            }
        }
    }

    public static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
