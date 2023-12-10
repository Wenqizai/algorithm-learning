package com.wenqi.demo01.grah.shortpath;

/**
 * @author Wenqi Liang
 * @date 2023/12/10
 */
public class FloydWarshallShortestPath {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

//        int[][] graph = {
//                {0, 2, INF, 6, INF, INF},
//                {INF, 0, 3, INF, 8, 5},
//                {INF, INF, 0, INF, INF, 7},
//                {INF, INF, INF, 0, INF, 9},
//                {INF, INF, INF, INF, 0, INF},
//                {INF, INF, INF, INF, INF, 0}
//        };

        test01(graph);

        System.out.println("#########");


//        int[][] graph2 = {
//                {0, 2, INF, 6, INF, INF},
//                {INF, 0, 3, INF, 8, 5},
//                {INF, INF, 0, INF, INF, 7},
//                {INF, INF, INF, 0, INF, 9},
//                {INF, INF, INF, INF, 0, INF},
//                {INF, INF, INF, INF, INF, 0}
//        };

        int[][] graph2 = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };


        test02(graph2, 0);
    }

    private static void test02(int[][] graph, int midVertex) {
        floydWarshall(graph, midVertex);
    }

    private static void test01(int[][] graph) {
        floydWarshall(graph);
    }


    public static void floydWarshall(int[][] graph, int midVertex) {
        int length = graph.length;

        if (midVertex == length - 1) {
            printSolution(graph);
            return;
        }

        // 假如要求 0 -> 4 的最短路径, 当假如引入中间顶点 midVertex 时, 看是发现了更短的路径
        // 那么求 Min(0 -> 4) = Min(0 -> midVertex) + Min(midVertex -> 4)
        for (int i = 0; i < length; i++) {
            if (midVertex == i) {
                continue;
            }

            for (int j = 0; j < length; j++) {
                if (midVertex == j) {
                    continue;
                }


                int value = graph[i][j];
                if (graph[i][midVertex] != INF && graph[midVertex][j] != INF        // 加入的 midVertex 必须要可以连接源点和目标点
                        && value > graph[i][midVertex] + graph[midVertex][j]) {     // 加入 midVertex 后, 发现源点到目标点的距离更近了
                    graph[i][j] = graph[i][midVertex] + graph[midVertex][j];
                }
            }
        }


        floydWarshall(graph, ++midVertex);
    }



    public static void floydWarshall(int[][] graph) {
        int numVertices = graph.length;

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                   if (graph[i][k] != INF && graph[k][j] != INF
                           && graph[i][k] + graph[k][j] < graph[i][j]) {
                       graph[i][j] = graph[i][k] + graph[k][j];
                   }
                }
            }
        }

        printSolution(graph);
    }

    private static void printSolution(int[][] distance) {
        System.out.println("Shortest Distances between Every Pair of Vertices:");
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
