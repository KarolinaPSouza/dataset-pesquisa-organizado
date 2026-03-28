import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline
from collections import deque

def bfs(start, g, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    far = start

    while q:
        u = q.popleft()
        for v in g[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[far]:
                    far = v
    return far, dist

def solve():
    n = int(input())
    g = [[] for _ in range(n+1)]
    for _ in range(n-1):
        a, b = map(int, input().split())
        g[a].append(b)
        g[b].append(a)

    # Find diameter endpoints A and B
    A, _ = bfs(1, g, n)
    B, distA = bfs(A, g, n)
    _, distB = bfs(B, g, n)

    # Eccentricity for each node is max(distA, distB)
    ans = [str(max(distA[i], distB[i])) for i in range(1, n+1)]
    print(" ".join(ans))

if __name__ == "__main__":
    solve()