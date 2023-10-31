package com.wenqi.demo01.grah;


import java.util.ArrayList;
import java.util.List;

/**
 * @author liangwenqi
 * @date 2023/10/31
 */
public class AllPathsSourceTarget797 {

    public static void main(String[] args) {
        test02();
    }



    List<List<Integer>> result = new ArrayList<>();
    List<Integer> found = new ArrayList<>();


    // == 邻接表解法 == //
    private static void test02() {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        System.out.println(new AllPathsSourceTarget797().allPathsSourceTarget2(graph));
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        found.add(0);
        dfs2(graph, 0);
        return result;
    }


    public void dfs2(int[][] graph,  int startIndex) {
        if (startIndex == graph.length - 1) {
            result.add(new ArrayList<>(found));
            return;
        }

        for (int i = 0; i < graph[startIndex].length; i++) {
            found.add(graph[startIndex][i]);
            dfs2(graph, graph[startIndex][i]);
            found.remove(found.size() - 1);
        }
    }


    // == 邻接矩阵解法 == //
    private static void test01() {
        int[][] graph = new int[4][4];
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[1][3] = 1;
        graph[2][3] = 1;
        System.out.println(new AllPathsSourceTarget797().allPathsSourceTarget1(graph));
    }
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        boolean[][] visited = new boolean[graph.length][graph.length];
        found.add(0);
        dfs1(graph, 0, visited);
        return result;
    }

    public void dfs1(int[][] graph, int startIndex, boolean[][] visited) {
        if (startIndex == graph.length - 1) {
            result.add(new ArrayList<>(found));
            return;
        }


        for (int k = 0; k < graph.length; k++) {
            if (!visited[startIndex][k] && graph[startIndex][k] == 1) {
                found.add(k);
                dfs1(graph, k, visited);
                found.remove(found.size() - 1);
                visited[startIndex][k] = true;
            }
        }
    }



    // == 其他人解法 == //

    List<List<Integer>> ans;		// 用来存放满足条件的路径
    List<Integer> cnt;		// 用来保存 dfs 过程中的节点值

    public void dfs3(int[][] graph, int node) {
        if (node == graph.length - 1) {		// 如果当前节点是 n - 1，那么就保存这条路径
            ans.add(new ArrayList<>(cnt));
            return;
        }
        for (int index = 0; index < graph[node].length; index++) {
            int nextNode = graph[node][index];
            cnt.add(nextNode);
            dfs3(graph, nextNode);
            cnt.remove(cnt.size() - 1);		// 回溯
        }
    }

    public List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
        ans = new ArrayList<>();
        cnt = new ArrayList<>();
        cnt.add(0);			// 注意，0 号节点要加入 cnt 数组中
        dfs3(graph, 0);
        return ans;
    }

}
