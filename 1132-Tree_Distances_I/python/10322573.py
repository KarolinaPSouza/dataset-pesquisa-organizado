from collections import defaultdict, deque

def bfs(start, n, adj):
    dist = [-1] * n
    queue = deque([start])
    dist[start] = 0
    while queue:
        node = queue.popleft()
        for neighbor in adj[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                queue.append(neighbor)
    farthest_node = dist.index(max(dist))  # O nó mais distante
    return farthest_node, dist

def solve():
    n = int(input())
    adj = defaultdict(list)

    for _ in range(n - 1):
        a, b = map(int, input().split())
        adj[a - 1].append(b - 1)
        adj[b - 1].append(a - 1)

    node_a, _ = bfs(0, n, adj)
    # Segundo BFS a partir do nó mais distante encontrado anteriormente
    node_b, dist_from_a = bfs(node_a, n, adj)
    # Terceiro BFS a partir de node_b para determinar as distâncias máximas
    _, dist_from_b = bfs(node_b, n, adj)

    result = [max(dist_from_a[i], dist_from_b[i]) for i in range(n)]
    print(" ".join(map(str, result)))

if __name__ == "__main__":
    solve()