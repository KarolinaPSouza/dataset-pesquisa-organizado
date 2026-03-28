import sys
from collections import deque

sys.setrecursionlimit(10**7)

def bfs(start, n, graph):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    farthest = start
    while q:
        u = q.popleft()
        for v in graph[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[farthest]:
                    farthest = v
    return farthest, dist

def solve():
    input = sys.stdin.readline
    n = int(input())
    graph = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    # Step 1: find one endpoint of diameter
    u, _ = bfs(1, n, graph)
    # Step 2: find other endpoint of diameter
    v, dist_u = bfs(u, n, graph)
    # Step 3: distances from v
    _, dist_v = bfs(v, n, graph)

    # Step 4: answer for each node
    ans = [str(max(dist_u[i], dist_v[i])) for i in range(1, n + 1)]
    print(" ".join(ans))

if __name__ == "__main__":
    solve()