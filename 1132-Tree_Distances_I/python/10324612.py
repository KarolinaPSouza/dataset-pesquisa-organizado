from collections import defaultdict, deque

def bfs(start, n, adj):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    max_dist, max_node = 0, start

    while q:
        node = q.popleft()
        for neighbor in adj[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
                if dist[neighbor] > max_dist:
                    max_dist = dist[neighbor]
                    max_node = neighbor

    return max_node, dist

def solve():
    n = int(input())
    adj = defaultdict(list)

    for _ in range(n - 1):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    # First BFS to find one endpoint of the diameter
    u, _ = bfs(1, n, adj)

    # Second BFS from u to find the other endpoint of the diameter and distances
    v, dist_from_u = bfs(u, n, adj)

    # Third BFS from v to get distances
    _, dist_from_v = bfs(v, n, adj)

    # Calculate the maximum time for each friend
    for i in range(1, n + 1):
        print(max(dist_from_u[i], dist_from_v[i]), end=' ')

solve()