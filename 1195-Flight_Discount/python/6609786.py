import sys
input = sys.stdin.readline
oo = 1 << 50
from heapq import heappop, heappush
def encode(x, y): return x << 20 | y
def decode(z): return z >> 20, z & 0xfffff
def dijkstra(graph, start):
    n = len(graph)
    dist = [oo] * n
    dist[start] = 0
    queue = [encode(0, start)]
    while queue:
        path_len, v = decode(heappop(queue))
        if path_len == dist[v]:
            for w, edge_len in graph[v]:
                if edge_len + path_len < dist[w]:
                    dist[w] = edge_len + path_len
                    heappush(queue, encode(edge_len + path_len, w))
    return dist



# n, m = map(int, input().split())
# g = [[] for _ in range(n)]
# for _ in range(m):
#     u, v, w = [int(i) - 1 for i in input().split()]; w += 1
#     g[u].append((v, w))


# dp = [[oo, oo] for _ in range(n)]
# dp[0][0] = dp[0][1] = 0
# q0 = [(0, )]



# Method 1: Using simple Dijkstra
n, m = map(int, input().split())
g = [[] for _ in range(2 * n)]
for _ in range(m):
    u, v, w = [int(i) - 1 for i in input().split()]; w += 1
    u1, v1 = u + n, v + n
    g[u].append((v, w))
    g[u1].append((v1, w))
    g[u].append((v1, w >> 1))

dis = dijkstra(g, 0)
print(dis[2 * n - 1])



# # Method 2
# n, m = map(int, input().split())
# g = [[] for _ in range(n)]
# gr = [[] for _ in range(n)]
# edges = []
# for _ in range(m):
#     u, v, w = [int(i) - 1 for i in input().split()]; w += 1
#     edges.append((u, v, w))
#     g[u].append((v, w))
#     gr[v].append((u, w))

# dis1 = dijkstra(g, 0)
# disN = dijkstra(gr, n - 1)
# ans = oo
# for u, v, w in edges:
#     ans = min(ans, dis1[u] + w // 2 + disN[v])
# print(ans)