import sys
sys.setrecursionlimit(300000)
input = sys.stdin.readline

n = int(input())
g = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

# --- Step 1: find farthest node from any node (say node 1)
def dfs(start):
    stack = [(start, -1, 0)]
    far_node, max_dist = start, 0
    dist = [0] * (n + 1)
    while stack:
        node, parent, d = stack.pop()
        dist[node] = d
        if d > max_dist:
            max_dist = d
            far_node = node
        for nei in g[node]:
            if nei != parent:
                stack.append((nei, node, d + 1))
    return far_node, dist

# --- Step 2: find one endpoint of diameter
u, _ = dfs(1)
# --- Step 3: find farthest from u (second endpoint)
v, dist_u = dfs(u)
# --- Step 4: distances from v
_, dist_v = dfs(v)

# --- Step 5: for each node, answer = max(dist_u[i], dist_v[i])
res = [str(max(dist_u[i], dist_v[i])) for i in range(1, n + 1)]
print(" ".join(res))