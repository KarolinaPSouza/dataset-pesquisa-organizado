import sys
from collections import deque

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        v = q.popleft()
        for u in adj[v]:
            if dist[u] == -1:
                dist[u] = dist[v] + 1
                q.append(u)
    return dist

def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    it = iter(data)
    n = next(it)
    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a = next(it); b = next(it)
        adj[a].append(b)
        adj[b].append(a)

    # BFS from 1 to find farthest node A
    dist1 = bfs(1, adj, n)
    A = max(range(1, n+1), key=lambda x: dist1[x])

    # BFS from A to get distA and find B
    distA = bfs(A, adj, n)
    B = max(range(1, n+1), key=lambda x: distA[x])

    # BFS from B to get distB
    distB = bfs(B, adj, n)

    out = [str(max(distA[i], distB[i])) for i in range(1, n+1)]
    sys.stdout.write(" ".join(out))

if __name__ == "__main__":
    main()