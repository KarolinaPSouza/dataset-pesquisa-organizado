import heapq
import sys


def dijkstra(graph, s):
    INF = 10 ** 18
    dist = [INF] * len(graph)

    dist[s] = 0
    heap = [(0, s)]

    while heap:
        distance, node = heapq.heappop(heap)

        if distance != dist[node]:
            continue

        for neighbor_node, neighbor_dist in graph[node]:
            new_distance = neighbor_dist + distance

            if new_distance < dist[neighbor_node]:
                dist[neighbor_node] = new_distance
                heapq.heappush(heap, (new_distance, neighbor_node))
    return dist

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
reversed_graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, length = map(int, sys.stdin.readline().split())

    graph[a].append((b, length))
    reversed_graph[b].append((a, length))

dist = dijkstra(graph, 1)
reversed_dist = dijkstra(reversed_graph, n)

shortest_length = 10 ** 18
for node1 in range(1, len(graph)):
    for node2, distance in graph[node1]:
        shortest_length = min(dist[node1] + reversed_dist[node2] + distance//2, shortest_length)

print(shortest_length)