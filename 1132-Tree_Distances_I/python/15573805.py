import sys
from collections import deque

data = list(map(int, sys.stdin.buffer.read().split()))
n = data[0]
adj = [[] for _ in range(n+1)]
it = 1
for _ in range(n-1):
    a = data[it]; b = data[it+1]; it += 2
    adj[a].append(b)
    adj[b].append(a)

def bfs(start):
    dist = [-1] * (n+1)
    q = deque([start])
    dist[start] = 0
    while q:
        v = q.popleft()
        for w in adj[v]:
            if dist[w] == -1:
                dist[w] = dist[v] + 1
                q.append(w)
    return dist


d1 = bfs(1)
u = max(range(1, n+1), key=lambda x: d1[x])


du = bfs(u)
v = max(range(1, n+1), key=lambda x: du[x])


dv = bfs(v)

res = [str(max(du[i], dv[i])) for i in range(1, n+1)]
print(" ".join(res))