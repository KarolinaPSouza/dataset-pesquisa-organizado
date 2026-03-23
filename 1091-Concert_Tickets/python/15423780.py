import sys
sys.setrecursionlimit(10**7)
from collections import deque

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    q = deque()
    q.append(start)
    dist[start] = 0

    farthest_node = start

    while q:
        u = q.popleft()
        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[farthest_node]:
                    farthest_node = v

    return farthest_node, dist[farthest_node]


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

    # Step 1: BFS from any node (choose node 1)
    A, _ = bfs(1, adj, n)

    # Step 2: BFS from A to find farthest
    B, diameter = bfs(A, adj, n)

    print(diameter)


solve()