import sys

input = lambda : sys.stdin.readline().rstrip()
INF = 10**25

def bellman(n, edges, start, graph):
    dp = [0] * n
    dp[start] = 0
    parent = [-1] * n
    for _ in range(n):
        for u, v, d in edges:
            if dp[v] > dp[u] + d:
                dp[v] = dp[u] + d
                parent[v] = u

    for u, v, d in edges:
        if dp[v] > dp[u] + d:
            for _ in range(n):
                u = parent[u]
            path = [u]
            while parent[path[-1]] != u:
                path.append(parent[path[-1]])

            return (path + [u])[::-1]


    return []




n, m = map(int, input().split())
edges = []
graph = [[] for _ in range(n)]

for _ in range(m):
    u, v, d = [int(x)-1 for x in input().split()]
    edges.append((u, v, d+1))
    graph[u].append(v)

dp = bellman(n, edges, 0, graph)
if dp:
    print("YES")
    print(*[i+1 for i in dp])
else:
    print("NO")