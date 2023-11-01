package com.wenqi.demo01.grah.dfs;

import java.util.LinkedList;

/**
 * @author liangwenqi
 * @date 2023/11/1
 */
public class BFSGraphRecursiveAdjacencyListDirected {
    private final LinkedList<Integer>[] graph;
    private final int numVertices;

    public BFSGraphRecursiveAdjacencyListDirected(int numVertices) {
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

    // 递归DFS（近似BFS，非典型BFS）
    private void recursiveBFSUtil(LinkedList<Integer> queue, boolean[] visited) {
        if (queue.isEmpty()) {
            return;
        }

        int vertex = queue.poll();
        System.out.print(vertex + " ");

        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }

        recursiveBFSUtil(queue, visited);
    }

    // 近似BFS（递归DFS）
    public void recursiveBFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        recursiveBFSUtil(queue, visited);
    }

    /**
     * 0 -> 1 -> 3
     * |    |    |
     * v    v    v
     * 2 -> 4 -> 5
     */
    public static void main(String[] args) {
        int numVertices = 6;
        BFSGraphRecursiveAdjacencyListDirected graph = new BFSGraphRecursiveAdjacencyListDirected(numVertices);

        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(2, 5);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(4, 5);

        System.out.print("Recursive BFS (Non-standard): ");
        graph.recursiveBFS(0); // 从顶点0开始近似BFS
    }
}
