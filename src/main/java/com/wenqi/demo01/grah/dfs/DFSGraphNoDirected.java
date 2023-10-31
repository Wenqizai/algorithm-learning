package com.wenqi.demo01.grah.dfs;

import java.util.Stack;

/**
 *
 *  0 --- 1 --- 2
 *  |     |   / |
 *  |     | /   |
 *  3 --- 4 --- 5
 *
 *      0  1  2  3  4  5
 *  0 | 0  1  1  0  0  0
 *  1 | 1  0  0  1  1  0
 *  2 | 1  0  0  0  1  1
 *  3 | 0  1  0  0  0  1
 *  4 | 0  1  1  0  0  1
 *  5 | 0  0  1  1  1  0
 *
 * @author liangwenqi
 * @date 2023/10/31
 */
public class DFSGraphNoDirected {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public DFSGraphNoDirected(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 1, 1, 1, 0}
        };

        DFSGraphNoDirected graph = new DFSGraphNoDirected(adjacencyMatrix);
        System.out.print("Depth First Traversal: ");
        graph.DFS(0); // 从顶点0开始深度优先搜索
    }
}
