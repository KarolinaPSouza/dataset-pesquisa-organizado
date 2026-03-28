import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
adj = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

# Step 1: Compute subtree heights using post-order iterative DFS
subtree = [0] * (n + 1)
parent = [-1] * (n + 1)
order = []
visited = [False] * (n + 1)

stack = [(1, 0)]
while stack:
    node, state = stack.pop()
    if state == 0:
        visited[node] = True
        stack.append((node, 1))
        for nei in adj[node]:
            if not visited[nei]:
                parent[nei] = node
                stack.append((nei, 0))
    else:
        max_depth = 0
        for nei in adj[node]:
            if nei != parent[node]:
                max_depth = max(max_depth, subtree[nei] + 1)
        subtree[node] = max_depth
        order.append(node)

# Step 2: Rerooting using BFS (or DFS) and propagate upward path
res = [0] * (n + 1)
res[1] = subtree[1]
queue = deque([(1, 0)])  # node, upward path

while queue:
    node, up = queue.popleft()

    # Collect children heights
    children = []
    for nei in adj[node]:
        if nei != parent[node]:
            children.append((nei, subtree[nei] + 1))

    # Compute prefix/suffix max
    m = len(children)
    prefix = [0] * m
    suffix = [0] * m
    for i in range(m):
        prefix[i] = children[i][1]
        if i > 0:
            prefix[i] = max(prefix[i], prefix[i - 1])
    for i in range(m - 1, -1, -1):
        suffix[i] = children[i][1]
        if i + 1 < m:
            suffix[i] = max(suffix[i], suffix[i + 1])

    for i, (child, _) in enumerate(children):
        best_sibling = -1
        if i > 0:
            best_sibling = max(best_sibling, prefix[i - 1])
        if i + 1 < m:
            best_sibling = max(best_sibling, suffix[i + 1])
        new_up = max(up + 1, best_sibling + 1 if best_sibling != -1 else 0)
        res[child] = max(subtree[child], new_up)
        queue.append((child, new_up))

print(*res[1:])