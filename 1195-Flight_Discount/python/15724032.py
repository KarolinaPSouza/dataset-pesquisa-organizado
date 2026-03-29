import sys
from collections import defaultdict, deque
import heapq

input = sys.stdin.readline
INF = 10**18


def dijkstra(graph, src):
    dist = [INF] * (n+1)
    dist[src] = 0

    heap = []
    heapq.heappush(heap, (0, src))

    while heap:
        curr_dis, curr_node = heapq.heappop(heap)
        if curr_dis > dist[curr_node]:
            continue
        for neigh, cost in graph[curr_node]:
            if dist[neigh] > curr_dis + cost:
                dist[neigh] = curr_dis + cost
                heapq.heappush(heap, (dist[neigh], neigh))
    return dist


graph = defaultdict(list)
reverse_graph = defaultdict(list)

n, m = map(int, input().split())
for _ in range(m):
    a, b, c = map(int, input().split(" "))
    graph[a].append((b,c))
    reverse_graph[b].append((a,c))


dist_src_to_all = dijkstra(graph, 1)
dist_dest_to_all = dijkstra(reverse_graph, n)

# print(dist_dest_to_all)
# print(dist_src_to_all)
res = INF

for u in graph:
    for v, c in graph[u]:
        cost = dist_src_to_all[u] + dist_dest_to_all[v] + c // 2
        if cost < res:
            res = cost

print(res)
