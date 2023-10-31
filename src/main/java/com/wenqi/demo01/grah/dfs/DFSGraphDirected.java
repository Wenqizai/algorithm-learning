package com.wenqi.demo01.grah.dfs;

import java.util.Stack;

/**
 * @author liangwenqi
 * @date 2023/10/31
 */
public class DFSGraphDirected {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public DFSGraphDirected(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    /**
     * 非递归实现
     */
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    /**
     * 递归实现
     */
    private boolean[] visited;
    public void DFS2(int startVertex) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                DFS2(i); // 递归调用
            }
        }
    }


    /**
     *  0 --> 1 --> 2
     *  ^           |
     *  |           |
     *  |           v
     *  3 <-- 4 <-- 5
     * <p>
     *      0  1  2  3  4  5
     *  0 | 0  1  1  0  0  0
     *  1 | 0  0  0  1  1  0
     *  2 | 0  0  0  0  1  1
     *  3 | 0  0  0  0  0  1
     *  4 | 0  0  0  0  0  1
     *  5 | 0  0  0  0  0  0
     */
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

        DFSGraphDirected graph = new DFSGraphDirected(adjacencyMatrix);
        System.out.print("Depth First Traversal: ");
        graph.DFS(0); // 从顶点0开始深度优先搜索
    }
}
