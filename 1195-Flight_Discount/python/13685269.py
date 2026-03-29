import heapq

n, m = map(int, input().split())

adj = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    a -= 1
    b -= 1
    adj[a].append((b, c))

shortest_path = [float("inf")] * (2 * n)
visited = [False] * (2 * n)
shortest_path[0] = 0
pq = [(0, 0)]

while pq:
    path_length, node = heapq.heappop(pq)

    if visited[node]:
        continue
    visited[node] = True
    shortest_path[node] = path_length

    original_node = node - n if node >= n else node
    for next_node, weight in adj[original_node]:
        if original_node == node:
            heapq.heappush(pq, (path_length + weight, next_node))
            heapq.heappush(pq, (int(path_length + weight / 2), next_node + n))
        else:
            heapq.heappush(pq, (path_length + weight, next_node + n))

if shortest_path[2 * n - 1] < float("inf"):
    print(shortest_path[2 * n - 1])
else:
    print("IMPOSSIBLE")
