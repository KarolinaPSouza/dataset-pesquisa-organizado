from collections import deque

def bfs(start, graph, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    while q:
        node = q.popleft()
        for neighbor in graph[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
    return dist

n = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

d1 = bfs(1, graph, n)
end1 = d1.index(max(d1))

d2 = bfs(end1, graph, n)
end2 = d2.index(max(d2))

d3 = bfs(end2, graph, n)

for i in range(1, n + 1):
    print(max(d2[i], d3[i]), end=' ')