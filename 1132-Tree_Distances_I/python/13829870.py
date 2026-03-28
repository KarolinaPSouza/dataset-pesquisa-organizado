import sys
from collections import deque
input = sys.stdin.readline

def bfs(start, adj):
    n = len(adj)
    dist = [-1]*n
    q = deque([start])
    dist[start] = 0
    while q:
        u = q.popleft()
        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    far = max(range(n), key=lambda i: dist[i])
    return far, dist

n = int(input())
adj = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = map(int, input().split())
    a -= 1; b -= 1
    adj[a].append(b)
    adj[b].append(a)

# 1) BFS from arbitrary node 0 -> get A
A, _ = bfs(0, adj)
# 2) BFS from A -> distA and farthest node B
B, distA = bfs(A, adj)
# 3) BFS from B -> distB
_, distB = bfs(B, adj)

ans = [str(max(distA[i], distB[i])) for i in range(n)]
print(" ".join(ans))