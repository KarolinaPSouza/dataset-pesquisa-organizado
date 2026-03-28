import sys
from collections import deque
sys.setrecursionlimit(10**7)

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    farthest = start

    while q:
        u = q.popleft()
        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[farthest]:
                    farthest = v
    return farthest, dist


def solve():
    data = sys.stdin.read().split()
    it = iter(data)
    n = int(next(it))

    adj = [[] for _ in range(n+1)]

    for _ in range(n-1):
        a = int(next(it))
        b = int(next(it))
        adj[a].append(b)
        adj[b].append(a)

    # 1. BFS from any node (1) to get diameter endpoint A
    A, _ = bfs(1, adj, n)

    # 2. BFS from A to get distances distA[] and endpoint B
    B, distA = bfs(A, adj, n)

    # 3. BFS from B to get distances distB[]
    _, distB = bfs(B, adj, n)

    # eccentricity of each node = max(distA, distB)
    result = [str(max(distA[i], distB[i])) for i in range(1, n+1)]
    print(" ".join(result))


solve()