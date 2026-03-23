from collections import deque, defaultdict

n = int(input())
edges = [tuple(map(int, input().split())) for _ in range(n - 1)]

adj = defaultdict(list)
for a, b in edges:
    adj[a].append(b)
    adj[b].append(a)

distance = [-1] * (n + 1)
queue = deque([1])
distance[1] = 0
farthest_node = 1

while queue:
    node = queue.popleft()
    for neighbor in adj[node]:
        if distance[neighbor] == -1:
            distance[neighbor] = distance[node] + 1
            queue.append(neighbor)
            if distance[neighbor] > distance[farthest_node]:
                farthest_node = neighbor

distance = [-1] * (n + 1)
queue = deque([farthest_node])
distance[farthest_node] = 0
diameter = 0

while queue:
    node = queue.popleft()
    for neighbor in adj[node]:
        if distance[neighbor] == -1:
            distance[neighbor] = distance[node] + 1
            queue.append(neighbor)
            if distance[neighbor] > diameter:
                diameter = distance[neighbor]

print(diameter)