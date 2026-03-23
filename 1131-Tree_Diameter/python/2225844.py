from collections import deque
from sys import stdin,stdout

n = int(stdin.readline())
g = [[] for i in range(n + 1)]


def bfs(node, n):
    q = deque()
    q.append([node, 0])
    vis = [False for i in range(n + 1)]
    curr = []
    vis[node] = True
    while len(q):
        curr = q.popleft()
        for x in g[curr[0]]:
            if not vis[x]:
                q.append([x, curr[1] + 1])
                vis[x] = True
    return curr


for i in range(n - 1):
    a, b = map(int, stdin.readline().split())
    g[a].append(b)
    g[b].append(a)

l, d = bfs(1, n)
f, g = bfs(l, n)
stdout.write(str(g))