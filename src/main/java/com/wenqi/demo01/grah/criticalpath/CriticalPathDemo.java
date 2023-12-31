package com.wenqi.demo01.grah.criticalpath;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 求关键路径步骤:
 * 1. 求 Ve(i) ，从源点 i 一直往前推进
 * 2. 求Vl(i)，从汇点 k 一直往后推进，注意此时已经计算完所有顶点的 Ve
 * 3. 求 e(i) 和 l(i)
 * 4. 计算 l(i) - e(i)
 *
 * @author Wenqi Liang
 * @date 2023/12/31
 */
public class CriticalPathDemo {
    private static int[] vEarly = new int[6];
    private static int[] vLately = new int[6];
    private static List<Integer> criticalPath = new ArrayList<>();

    public static void main(String[] args) {
        CriticalGraph graph = new CriticalGraph(6);

        // Adding directed edges with weights
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 7);

        calculateCriticalPath(graph);
    }

    public static void calculateCriticalPath(CriticalGraph graph) {
        List<Pair<Integer, Integer>>[] srcList = graph.getSrcList();
        List<Pair<Integer, Integer>>[] destList = graph.getDestList();
        doCalculateEarly(0, srcList);
        doCalculateLately(srcList.length - 1, destList);

        // 3. 求 e(i) 和 l(i)
        System.out.println("Critical Path:");

        for (int i = 0; i < srcList.length; i++) {
            int slack = vLately[i] - vEarly[i];
            System.out.println("Activity " + i + ": ES=" + vEarly[i] + ", LS=" + vLately[i] + ", Slack=" + slack);
            if (slack == 0) {
                System.out.println("  Critical Activity!");
                criticalPath.add(i);
            }
        }

        System.out.println("\n 关键路径活动: " + criticalPath.toString());
    }

    public static void doCalculateEarly(int startVertex, List<Pair<Integer, Integer>>[] srcList) {
        if (startVertex == srcList.length) {
            return;
        }
        List<Pair<Integer, Integer>> pairs = srcList[startVertex];
        if (pairs.isEmpty()) {
            vEarly[startVertex] = 0;
        } else {
            int max = -1;
            for (Pair<Integer, Integer> pair : pairs) {
                Integer src = pair.getKey();
                Integer weight = pair.getValue();
                if (vEarly[src] + weight > max) {
                    max = vEarly[src] + weight;
                }
            }
            vEarly[startVertex] = max;
        }
        doCalculateEarly(++startVertex, srcList);
    }

    public static void doCalculateLately(int startVertex, List<Pair<Integer, Integer>>[] destList) {
        if (startVertex < 0) {
            return;
        }
        if (startVertex == destList.length - 1) {
            vLately[startVertex] = vEarly[startVertex];
        } else {
            Integer minLateV = Integer.MAX_VALUE;
            for (Pair<Integer, Integer> pair : destList[startVertex]) {
                Integer dest = pair.getKey();
                Integer lateV = vLately[dest];
                Integer weight = pair.getValue();
                if (lateV - weight < minLateV) {
                    minLateV = lateV - weight;
                }
            }
            vLately[startVertex] = minLateV;
        }
        doCalculateLately(--startVertex, destList);
    }


}
