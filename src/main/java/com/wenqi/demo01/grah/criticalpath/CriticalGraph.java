package com.wenqi.demo01.grah.criticalpath;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wenqi Liang
 * @date 2023/12/31
 */
public class CriticalGraph {
    private List<Pair<Integer, Integer>>[] srcList;
    private List<Pair<Integer, Integer>>[] destList;

    public CriticalGraph(int vertices) {
        this.srcList = new ArrayList[vertices];
        this.destList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            srcList[i] = new ArrayList<>();
            destList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        srcList[dest].add(new Pair(src, weight));
        destList[src].add(new Pair(dest, weight));
    }

    public List<Pair<Integer, Integer>>[] getSrcList() {
        return srcList;
    }

    public void setSrcList(List<Pair<Integer, Integer>>[] srcList) {
        this.srcList = srcList;
    }

    public List<Pair<Integer, Integer>>[] getDestList() {
        return destList;
    }

    public void setDestList(List<Pair<Integer, Integer>>[] destList) {
        this.destList = destList;
    }
}
