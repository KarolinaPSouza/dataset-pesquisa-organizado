from collections import deque

def bfs(st, adj):
    n = len(adj)
    dist = [-1] * n
    dist[st] = 0
    q = deque([st])

    fn = st
    while q:
        node = q.popleft()
        for nei in adj[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
                if dist[nei] > dist[fn]:
                    fn = nei
    return fn, dist[fn]

n = int(input())
adj = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

u, i = bfs(1, adj)

v, dia = bfs(u, adj)

print(dia)