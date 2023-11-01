package com.wenqi.demo01.grah.dfs;

import com.wenqi.demo01.grah.AllPathsSourceTarget797;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liangwenqi
 * @date 2023/11/1
 */
public class BFSGraphAdjacencyListDirected {
    private final LinkedList<Integer>[] graph;
    private final int numVertices;

    public BFSGraphAdjacencyListDirected(int numVertices) {
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

    // BFS
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Integer neighbor : graph[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }


    public static void main(String[] args) {
        test01();
    }

    //=== 邻接矩阵实现 ===//

    /**
     * 0 -> 1 -> 3
     * |    |    |
     * v    v    v
     * 2 -> 4 -> 5
     */
    private static void test01() {
        int numVertices = 6;
        BFSGraphAdjacencyListDirected graph = new BFSGraphAdjacencyListDirected(numVertices);

        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(2, 5);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(4, 5);

        System.out.print("Breadth First Traversal: ");
        graph.BFS(0); // 从顶点0开始广度优先搜索
    }
}
