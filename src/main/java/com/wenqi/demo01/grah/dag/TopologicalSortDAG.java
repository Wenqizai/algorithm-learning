package com.wenqi.demo01.grah.dag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Wenqi Liang
 * @date 2023/12/10
 */
public class TopologicalSortDAG {
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Add directed edges
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // 这种实现是: 从后驱节点往后找 (叶子节点 -> 根节点)
        graph.topologicalSort();


        // 这种实现: 从前驱节点往后找, 不断删除指向边 (根节点 -> 叶子字节)
        topologicalSort(graph);

        // 还有一种是判断有向图有没有环, 就拓扑排序后的数量能不能更排序前的顶点数量一致, 如果不一致则是有环

    }


    public static void topologicalSort(Graph graph) {
        int verticesNums = graph.getVertices();
        boolean[] visited = new boolean[verticesNums];
        Stack<Integer> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < verticesNums; i++) {
            list.add(i);
        }

        doTopoLogicalSort(graph, list, visited, stack);


        System.out.println("\nstack: \n" + Arrays.toString(stack.toArray()));
    }

    private static void doTopoLogicalSort(Graph graph, List<Integer> verticesNums, boolean[] visited, Stack<Integer> stack) {
        if (verticesNums.isEmpty()) {
            return;
        }
        List<Integer> rest = new ArrayList<>(verticesNums);
        for (Integer vertex : verticesNums) {
            if (isPredecessor(graph, vertex, visited)) {
                stack.add(vertex);
                rest.remove(vertex);
                visited[vertex] = true;
            }
        }

        if (rest.size() == verticesNums.size()) {
            return;
        }

        doTopoLogicalSort(graph, rest, visited, stack);

    }

    private static boolean isPredecessor(Graph graph, int vertex, boolean[] visited) {
        // 找一个没有前驱的顶点
        List<List<Integer>> adjList = graph.getAdjList();
        for (int i = 0; i < adjList.size(); i++) {
            if (visited[i]) {
                continue;
            }

            List<Integer> predecessor = adjList.get(i);   // 前驱
            for (Integer successor : predecessor) {      // 后驱
                if (vertex == successor) {
                    return false;
                }
            }
        }
        return true;
    }


}
