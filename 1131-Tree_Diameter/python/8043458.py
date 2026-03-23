from collections import defaultdict, deque
n = int(input())
g = {}

g = defaultdict(list)

for i in range(n-1):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)


def bfs_farthest_node(graph, start):
    visited = set()
    distance = [0] * (n+1)
    queue = deque()

    visited.add(start)
    queue.append(start)

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if neighbor not in visited:
                visited.add(neighbor)
                distance[neighbor] = distance[current] + 1
                queue.append(neighbor)

    farthest_node = distance.index(max(distance))
    return farthest_node, distance[farthest_node]


farthest_node, distance = bfs_farthest_node(g, 1)
_, res = bfs_farthest_node(g, farthest_node)
print(res)