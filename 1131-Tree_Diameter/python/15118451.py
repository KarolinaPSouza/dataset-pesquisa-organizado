from collections import defaultdict, deque

def find_diameter(n, edges):
    graph = defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    def bfs(node):
        queue = deque([(node, 0)])
        visited = set([node])
        max_node, max_dist = node, 0
        while queue:
            node, dist = queue.popleft()
            if dist > max_dist:
                max_node, max_dist = node, dist
            for neighbor in graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, dist + 1))
        return max_node, max_dist

    # Find the furthest node from an arbitrary node (1)
    node1, _ = bfs(1)
    # Find the furthest node from node1
    _, diameter = bfs(node1)
    return diameter

n = int(input())
edges = []
for _ in range(n - 1):
    u, v = map(int, input().split())
    edges.append((u, v))

print(find_diameter(n, edges))