from collections import deque

def bfs(start, n, graph):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    farthest_node = start

    while q:
        node = q.popleft()
        for neighbor in graph[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
                if dist[neighbor] > dist[farthest_node]:
                    farthest_node = neighbor

    return farthest_node, dist

n = int(input().strip())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

u, _ = bfs(1, n, graph)
v, dist_from_u = bfs(u, n, graph)
_, dist_from_v = bfs(v, n, graph)

print(*[max(dist_from_u[i], dist_from_v[i]) for i in range(1, n + 1)])