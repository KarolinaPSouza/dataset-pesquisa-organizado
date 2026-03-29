import heapq
import sys

inf = 10 ** 19


def dijkstra(G, s):
    dis = [inf] * len(G)
    dis[s] = 0

    queue = []
    heapq.heappush(queue, (0, s))

    while queue:
        d, u = heapq.heappop(queue)
        if d > dis[u]:
            continue
        for v, w in G[u]:
            if dis[u] + w < dis[v]:
                dis[v] = dis[u] + w
                heapq.heappush(queue, (dis[v], v))

    return dis


def createGraph(v, e):
    graph1 = [[] for _ in range(v + 1)]
    graph2 = [[] for _ in range(v + 1)]
    edges = []

    for i in range(e):
        a, b, w = map(int, sys.stdin.readline().split())
        graph1[a].append((b, w))
        graph2[b].append((a, w))
        edges.append((a, b, w))

    return graph1, graph2, edges


def solve():
    n, m = map(int, sys.stdin.readline().split())
    g1, g2, edges = createGraph(n, m)

    dis1 = dijkstra(g1, 1)
    dis2 = dijkstra(g2, n)

    ans = inf
    for a, b, w in edges:
        ans = min(ans, dis1[a] + dis2[b] + w // 2)

    print(ans)


solve()