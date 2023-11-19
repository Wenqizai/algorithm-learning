package com.wenqi.demo01.grah.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 最少生成树: Prim 算法
 * <p>
 * 1. 选择一个起始顶点作为起点。
 * 2. 将该顶点加入最小生成树。
 * 3. 从与最小生成树相邻的顶点中，选择一条最短的边，将该边的另一端顶点加入最小生成树。
 * 4. 复步骤 3，直到所有顶点都加入最小生成树。
 *
 * @author Wenqi Liang
 * @date 2023/11/13
 */
public class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        int[][] graph = {
//                {0, 2, 0, 6, 0},
//                {2, 0, 3, 8, 5},
//                {0, 3, 0, 0, 7},
//                {6, 8, 0, 0, 9},
//                {0, 5, 7, 9, 0}
//        };
//
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 8, 3, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        int minWeight = prim(graph);
        System.out.println("Minimum Weight of MST: " + minWeight);
    }

    public static int prim(int[][] graph) {
        int[][] newGraph = new int[graph.length][graph.length]; // 存储最少生成树
        boolean[] mark = new boolean[graph.length];
        List<Integer> foundList = new ArrayList<>();
        foundList.add(0);
        mark[0] = true;
        doPrim(foundList, mark, graph, newGraph);

        int totalWeight = 0;

        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                totalWeight += newGraph[i][j];
            }
        }

        return totalWeight;

    }

    public static void doPrim(List<Integer> foundList, boolean[] mark, int[][] graph, int[][] newGraph) {
        int length = graph.length;
        if (foundList.size() == length) {
            return;
        }

        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        int start = 0;

        // 遍历所有已经发现的顶点 foundList , 寻找最少的边
        for (int i = 0; i < foundList.size(); i++) {
            Integer index = foundList.get(i);
            for (int j = 0; j < length; j++) {
                if (graph[index][j] != 0 && !mark[j] && graph[index][j] < minValue) {
                    start = index;
                    minValue = graph[index][j];
                    minIndex = j;
                }
            }
        }

        mark[minIndex] = true;
        foundList.add(minIndex);
        newGraph[start][minIndex] = minValue;
        doPrim(foundList, mark, graph, newGraph);
    }


}
