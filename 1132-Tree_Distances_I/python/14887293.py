from collections import defaultdict, deque

n = int(input())
graph = defaultdict(list)

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start, n, graph):
    dist = [-1] * (n+1)
    dist[start] = 0
    q = deque([start])

    while q:
        curr = q.popleft()

        for node in graph[curr]:
            if dist[node] == -1:
                dist[node] = dist[curr] + 1
                q.append(node)

    farthest = dist.index(max(dist))            
    return farthest, dist


nodeA, _ = bfs(1, n, graph)

nodeB, distA = bfs(nodeA, n, graph)

_, distB = bfs(nodeB, n, graph)

for i in range(1, n+1):
    print(max(distA[i], distB[i]), end=' ')