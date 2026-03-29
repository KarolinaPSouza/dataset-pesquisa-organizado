import sys
from heapq import heappush, heappop
from math import floor
input = sys.stdin.readline


def dijkstra(graph, start):
    dists = [[float("inf"), float("inf")] for _ in graph]

    dists[start][0] = 0
    dists[start][1] = 0

    priority = [(0, start, 0)]

    while priority:
        current_dist, current_node, used_discount = heappop(priority)

        if current_dist > dists[current_node][used_discount]:
            continue

        for child, w in graph[current_node]:
            next_dist = current_dist + w

            if next_dist < dists[child][used_discount]:
                dists[child][used_discount] = next_dist
                heappush(priority, (next_dist, child, used_discount))

            if used_discount == 0:
                next_dist = current_dist + floor(w / 2)

                if next_dist < dists[child][1]:
                    dists[child][1] = next_dist
                    heappush(priority, (next_dist, child, 1))

    return dists

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


dists = dijkstra(graph, 1)
print(dists[n][1])