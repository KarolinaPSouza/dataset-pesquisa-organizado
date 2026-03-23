import sys
from collections import deque

def bfs(start, n, graph):
    queue = deque([start])
    visited = [-1] * (n + 1)
    visited[start] = 0
    farthest_node, max_distance = start, 0

    while queue:
        node = queue.popleft()
        for neighbor in graph[node]:
            if visited[neighbor] == -1:
                visited[neighbor] = visited[node] + 1
                queue.append(neighbor)
                if visited[neighbor] > max_distance:
                    max_distance = visited[neighbor]
                    farthest_node = neighbor
    return farthest_node, max_distance

n = int(sys.stdin.readline().strip())
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

node1, _ = bfs(1, n, graph)
node2, diameter = bfs(node1, n, graph)

print(diameter)