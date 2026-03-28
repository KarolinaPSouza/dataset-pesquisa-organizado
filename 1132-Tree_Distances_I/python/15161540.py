# import sys
# sys.setrecursionlimit(10**7)
# def diameter(n, g):

#     def dfs(root, visited, depth, depths):
#         if visited[root] == 1:
#             return
#         visited[root] = 1
#         depths[root] = depth
#         for neighbor in g[root]:
#             if visited[neighbor] == 0:
#                 depths[neighbor] = depth + 1
#                 dfs(neighbor, visited, depth + 1, depths)

#         return

#     depths0 = [0] * n
#     visited = [0] * n
#     dfs(0, visited, 0, depths0)
#     u = -1
#     curr_max = float("-inf")
#     for i in range(n):
#         if depths0[i] > curr_max:
#             u = i
#             curr_max = depths0[i]

#     visited = [0] * n
#     depths1 = [0] * n
#     dfs(u, visited, 0, depths1)

#     v = -1
#     curr_max = float("-inf")
#     for i in range(n):
#         if depths1[i] > curr_max:
#             v = i
#             curr_max = depths1[i]

#     depths2 = [0] * n
#     visited = [0] * n
#     dfs(v, visited, 0, depths2)

#     ans = []

#     for i in range(n):
#         ans.append(max(depths2[i], depths1[i]))

#     return ans


# n = int(input())
# edges = []
# g = {i:[] for i in range(n)}
# for i in range(n-1):
#     u, v = map(int, input().split())
#     g[u-1].append(v-1)
#     g[v-1].append(u-1)

# print(*diameter(n, g))

# CSES: Tree Distances I / similar problems
import sys
from collections import deque

data = list(map(int, sys.stdin.buffer.read().split()))
it = iter(data)
n = next(it)

g = [[] for _ in range(n)]
for _ in range(n - 1):
    a = next(it) - 1
    b = next(it) - 1
    g[a].append(b)
    g[b].append(a)


def bfs(start):
    dist = [-1] * n
    dq = deque([start])
    dist[start] = 0
    while dq:
        u = dq.popleft()
        for w in g[u]:
            if dist[w] == -1:
                dist[w] = dist[u] + 1
                dq.append(w)
    return dist


# 1) BFS from arbitrary node (0) to find one endpoint u
dist0 = bfs(0)
u = 0
maxd = -1
for i, d in enumerate(dist0):
    if d > maxd:
        maxd = d
        u = i

# 2) BFS from u to get distances dist_u and far endpoint v
dist_u = bfs(u)
v = 0
maxd = -1
for i, d in enumerate(dist_u):
    if d > maxd:
        maxd = d
        v = i

# 3) BFS from v to get distances dist_v
dist_v = bfs(v)

# answer: for each node, max(dist_u[i], dist_v[i])
out = " ".join(str(max(dist_u[i], dist_v[i])) for i in range(n))
sys.stdout.write(out)