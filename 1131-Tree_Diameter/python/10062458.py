from collections import deque

def bfs(start, adj):
    n = len(adj)
    dist = [-1] * n
    q = deque([start])
    dist[start] = 0
    farthest_node = start

    while q:
        node = q.popleft()
        for neighbor in adj[node]:
            if dist[neighbor] == -1:  # Not visited
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
                if dist[neighbor] > dist[farthest_node]:
                    farthest_node = neighbor

    return farthest_node, dist[farthest_node]

n = int(input())
adj = [[] for _ in range(n)]
for _ in range(n - 1):
    x, y = map(int, input().split())
    adj[x - 1].append(y - 1)
    adj[y - 1].append(x - 1)

# First BFS to find the farthest node from node 0
farthest_node, _ = bfs(0, adj)

# Second BFS to find the farthest node from the previously found farthest node
_, diameter = bfs(farthest_node, adj)

print(diameter)