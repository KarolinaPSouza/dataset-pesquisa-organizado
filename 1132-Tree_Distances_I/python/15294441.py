import sys
from collections import deque

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    dq = deque([start])
    dist[start] = 0
    far = start
    while dq:
        u = dq.popleft()
        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                dq.append(v)
                if dist[v] > dist[far]:
                    far = v
    return far, dist

def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    if not data:
        return
    it = iter(data)
    n = next(it)
    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a = next(it); b = next(it)
        adj[a].append(b)
        adj[b].append(a)

    A, _ = bfs(1, adj, n)
    B, distA = bfs(A, adj, n)
    _, distB = bfs(B, adj, n)

    out = [str(max(distA[i], distB[i])) for i in range(1, n + 1)]
    sys.stdout.write(" ".join(out))

if __name__ == "__main__":
    main()