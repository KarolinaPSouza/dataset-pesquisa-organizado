import sys
from collections import deque

def bfs(start_node, n, adj):
    distances = [-1] * n
    distances[start_node] = 0
    queue = deque([start_node])

    farthest_node = start_node
    max_dist = 0

    while queue:
        u = queue.popleft()
        for v in adj[u]:
            if distances[v] == -1:
                distances[v] = distances[u] + 1
                queue.append(v)
                if distances[v] > max_dist:
                    max_dist = distances[v]
                    farthest_node = v

    return distances, farthest_node

n = int(sys.stdin.readline())

if n == 1:
    print(0)
    sys.exit()

adj = [[] for _ in range(n)]
for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    adj[a - 1].append(b - 1)
    adj[b - 1].append(a - 1)

_, endpoint_a = bfs(0, n, adj)
dist_from_a, endpoint_b = bfs(endpoint_a, n, adj)
dist_from_b, _ = bfs(endpoint_b, n, adj)

result = []
for i in range(n):
    result.append(max(dist_from_a[i], dist_from_b[i]))

sys.stdout.write(" ".join(map(str, result)) + "\n")
#