import sys
from collections import deque

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    q = deque()
    q.append(start)
    dist[start] = 0
    while q:
        u = q.popleft()
        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    return dist

def main():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    adj = [[] for _ in range(n + 1)]
    idx = 1
    for _ in range(n - 1):
        a = int(data[idx]); b = int(data[idx + 1])
        idx += 2
        adj[a].append(b)
        adj[b].append(a)

    # First BFS from node 1 to find one end of a diameter
    d1 = bfs(1, adj, n)
    a = 1
    for i in range(1, n + 1):
        if d1[i] > d1[a]:
            a = i

    # Second BFS from a to find the other end b
    da = bfs(a, adj, n)
    b = a
    for i in range(1, n + 1):
        if da[i] > da[b]:
            b = i

    # Third BFS from b
    db = bfs(b, adj, n)

    # For each node, maximum distance to any node is max(dist to a, dist to b)
    res = []
    for i in range(1, n + 1):
        res.append(str(max(da[i], db[i])))

    print(" ".join(res))

if __name__ == "__main__":
    main()