from collections import deque
def bfs(start, graph, n):
    visited = [False] * (n + 1)
    distance = [0] * (n + 1)
    queue = deque([start])
    visited[start] = True
    while queue:
        node = queue.popleft()
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                distance[neighbor] = distance[node] + 1
                queue.append(neighbor)
    farthest_node = distance.index(max(distance))
    return farthest_node, max(distance)
n = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
farthest, _ = bfs(1, graph, n)
_, diameter = bfs(farthest, graph, n)
print(diameter)