package com.wenqi.demo01.grah.dfs;

import java.util.LinkedList;

/**
 * @author liangwenqi
 * @date 2023/10/31
 */
public class DFSGraphRecursiveAdjacencyListDirected {
    private final LinkedList<Integer>[] graph;
    private final int numVertices;

    public DFSGraphRecursiveAdjacencyListDirected(int numVertices) {
        this.numVertices = numVertices;
        this.graph = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            this.graph[i] = new LinkedList<>();
        }
    }

    // 添加有向边
    public void addDirectedEdge(int source, int destination) {
        graph[source].add(destination);
    }

    // 递归DFS
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Integer neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // DFS
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        DFSUtil(startVertex, visited);
    }

    /**
     *      0 -> 1 -> 3
     *      |    |    |
     *      v    v    v
     *      2 -> 4 -> 5
     */
    public static void main(String[] args) {
        int numVertices = 6;
        DFSGraphRecursiveAdjacencyListDirected graph = new DFSGraphRecursiveAdjacencyListDirected(numVertices);

        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(2, 5);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(4, 5);

        System.out.print("Depth First Traversal (Recursive): ");
        graph.DFS(0); // 从顶点0开始深度优先搜索
    }
}
