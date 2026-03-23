def tree_diameter(n, edges):
    from collections import deque, defaultdict

    def bfs(start_node):
        # Distance and parent tracking
        dist = [-1] * (n + 1)
        dist[start_node] = 0

        # BFS setup
        queue = deque([start_node])
        farthest_node = start_node
        max_distance = 0

        # Perform BFS
        while queue:
            node = queue.popleft()
            current_distance = dist[node]
            for neighbor in graph[node]:
                if dist[neighbor] == -1:  # not visited
                    dist[neighbor] = current_distance + 1
                    if dist[neighbor] > max_distance:
                        max_distance = dist[neighbor]
                        farthest_node = neighbor
                    queue.append(neighbor)

        return farthest_node, max_distance

    if n == 1:
        return 0  # Diameter of a single node is 0

    # Build graph
    graph = defaultdict(list)
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)

    # Step 1: BFS from an arbitrary node, here node 1 (assuming 1-based index and nodes start at 1)
    first_farthest_node, _ = bfs(1)

    # Step 2: BFS from the node found from first BFS
    _, diameter = bfs(first_farthest_node)

    return diameter

# Read inputs and process the tree
import sys
input = sys.stdin.read
data = input().split()
n = int(data[0])

edges = []
index = 1
for _ in range(n - 1):
    a = int(data[index])
    b = int(data[index + 1])
    edges.append((a, b))
    index += 2

# Calculate the diameter of the tree
print(tree_diameter(n, edges))