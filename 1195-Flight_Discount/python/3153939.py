# https://cses.fi/problemset/task/1195

from sys import *
from heapq import *
from collections import *

# inputs
graph = defaultdict(list)
graph_transpose = defaultdict(list)
n, m = map(int, stdin.readline().split())
for _ in range(m):
    s, e, w = map(int, stdin.readline().split())
    graph[s].append((e, w))
    graph_transpose[e].append((s, w))


def dijkstra(graph, source):
    heap_ = []
    distance = [maxsize] * (n + 1)
    heapify(heap_)
    distance[source] = 0  # source is our source node
    heappush(heap_, (0, source))  # source is at distance 0 from n
    processed = set()

    while heap_:
        dist, node = heappop(heap_)
        if distance[node] < dist:
            continue
        processed.add(node)
        for neigbor in graph[node]:
            neigbor_node, neigbor_dis = neigbor
            if neigbor_node not in processed and distance[node] + neigbor_dis < distance[neigbor_node]:
                distance[neigbor_node] = distance[node] + neigbor_dis
                heappush(heap_, (distance[neigbor_node], neigbor_node))
    return distance


dis_orignal = dijkstra(graph, 1)
dis_transpose = dijkstra(graph_transpose, n)
ans = maxsize
for node in range(1, n + 1):
    neigborlist = graph[node]
    for neigbor in neigborlist:
        e, w = neigbor
        ans = min(ans, (dis_orignal[node] + (w // 2) + dis_transpose[e]))
print(ans)