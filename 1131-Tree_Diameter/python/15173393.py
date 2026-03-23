from collections import deque

def bfs(start, adj):
    n = len(adj)
    dist = [-1] * n
    dist[start] = 0
    q = deque([start])
    while q:
        node = q.popleft()
        for nei in adj[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
    farthest_node = max(range(n), key=lambda i: dist[i])
    return farthest_node, dist[farthest_node]

def main():
    n = int(input())
    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    # first BFS from arbitrary node (say 1)
    u, _ = bfs(1, adj)
    # second BFS from farthest node
    v, diameter = bfs(u, adj)
    print(diameter)

if __name__ == "__main__":
    main()