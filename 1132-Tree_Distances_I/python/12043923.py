import sys
from collections import deque

input = sys.stdin.read
sys.setrecursionlimit(10**6)

def bfs(root):
    q = deque([(root, 0)])
    vis = [False] * (n + 1)
    vis[root] = True
    finalNode, finalDis = root, 0

    while q:
        node, dis = q.popleft()
        res[node] = max(res[node], dis)
        if dis >= finalDis:
            finalNode, finalDis = node, dis
        for neigh in tree[node]:
            if not vis[neigh]:
                q.append((neigh, dis + 1))
                vis[neigh] = True
    return finalNode, finalDis

# Fast Input
data = input().split()
n = int(data[0])

# Fast Tree Initialization
tree = [[] for _ in range(n + 1)]
res = [0] * (n + 1)

idx = 1
for _ in range(n - 1):
    a, b = int(data[idx]), int(data[idx + 1])
    tree[a].append(b)
    tree[b].append(a)
    idx += 2

# Run BFS to find the tree diameter
fn, fd = bfs(1)
fn, fd = bfs(fn)
fn, fd = bfs(fn)

# Fast Output (using join instead of multiple writes)
sys.stdout.write(" ".join(map(str, res[1:])) + "\n")