## DAG

有向无环图 DAG (Direct Acyclic Graph)：在图论中，如果一个有向图从任意顶点出发无法经过若干条边回到该点，则这个图是一个有向无环图。

- 应用
  1. 课程排序：比如学完 A 课程，才能学 B 课程，A 和 B 课程是一个先后顺序关系，无法同时进行；
  2. 工程进度：一个总工程分成若干子工程

- AOV 网（拓扑排序）

顶点表示活动，弧表示活动之间的邮箱制约关系

- AOE 网（关键路径）

弧标识符活动，顶点表示活动的开始或结束时间

## 拓扑排序

如果存在两个顶点 i -> j，那么拓扑排序后 i, j 的顺序关系一定是 i 在 j 的前面。

- 算法实现

1. 在有向图中选一个没有前驱的顶点（没有顶点指向该顶点）且输出之；
2. 从图中删除该顶点和所有以它为尾的弧；
3. 重复上述两步，直到全部顶点均已输出，或者但图中不存在无前驱的顶点为止。

AOV 拓扑排序后的序列不是唯一的。

- 拓扑排序的应用

检查 AOV 网中是否存在环：对有向图构造其顶点的拓扑有序序列，若网中所有顶点都在它的拓扑有序序列中，则该 AOV 网必定不存在环。

## 关键路径

把工程计划表示为边表示活动的网络，即 AOE 网，用顶点表示时间，弧表示活动，弧的权表示活动持续时间。




