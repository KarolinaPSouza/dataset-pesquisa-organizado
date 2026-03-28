import sys
from collections import deque
input = sys.stdin.readline

def solve():
    n = int(input())
    adj = [[] for _ in range(n)]
    for _ in range(n-1):
        a, b = map(int, input().split())
        a -= 1
        b -= 1
        adj[a].append(b)
        adj[b].append(a)

    def bfs(start):
        dist = [-1]*n
        q = deque()
        q.append(start)
        dist[start] = 0
        while q:
            u = q.popleft()
            for v in adj[u]:
                if dist[v] == -1:
                    dist[v] = dist[u] + 1
                    q.append(v)
        farthest_node = dist.index(max(dist))
        return dist, farthest_node

    # Find one endpoint of diameter
    _, u = bfs(0)
    # Find the other endpoint of diameter
    dist_u, v = bfs(u)
    # BFS from the other endpoint
    dist_v, _ = bfs(v)

    # Maximum distance for each node
    ans = [max(dist_u[i], dist_v[i]) for i in range(n)]
    print(' '.join(map(str, ans)))

solve()