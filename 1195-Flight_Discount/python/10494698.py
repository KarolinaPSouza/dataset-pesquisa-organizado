import heapq
import sys

input = sys.stdin.readline
INFINITY = int(1e18)

def find_shortest_path(source, graph, distances):
    queue = [(0, source)]
    distances[source] = 0

    while queue:
        current_dist, node = heapq.heappop(queue)

        if current_dist > distances[node]:
            continue

        for neighbor, weight in graph[node]:
            new_dist = current_dist + weight
            if new_dist < distances[neighbor]:
                distances[neighbor] = new_dist
                heapq.heappush(queue, (new_dist, neighbor))

n, m = map(int, input().split())

start_node = 1
end_node = n

graph_start = [[] for _ in range(n + 1)]
graph_end = [[] for _ in range(n + 1)]

distances_from_start = [INFINITY] * (n + 1)
distances_from_end = [INFINITY] * (n + 1)

edge_list = []

for _ in range(m):
    u, v, weight = map(int, input().split())
    graph_start[u].append((v, weight))
    graph_end[v].append((u, weight))
    edge_list.append((u, v, weight))

find_shortest_path(start_node, graph_start, distances_from_start)
find_shortest_path(end_node, graph_end, distances_from_end)

minimum_cost = INFINITY

for u, v, weight in edge_list:
    total_cost = distances_from_start[u] + (weight // 2) + distances_from_end[v]
    minimum_cost = min(minimum_cost, total_cost)

print(minimum_cost)