from collections import deque

def bfs(start, graph, n):
    visited = [False] * (n + 1)
    dist = [0] * (n + 1)
    q = deque([start])
    visited[start] = True
    while q:
        node = q.popleft()
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
    farthest_node = dist.index(max(dist))
    return farthest_node, max(dist)

n = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

node, _ = bfs(1, graph, n)
_, diameter = bfs(node, graph, n)
print(diameter)