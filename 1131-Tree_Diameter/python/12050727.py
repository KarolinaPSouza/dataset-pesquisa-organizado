import sys
import collections

def find_farthest(node, graph):
    queue = collections.deque([(node, 0)])  
    visited = set([node])
    farthest_node, max_distance = node, 0

    while queue:
        current, dist = queue.popleft()
        if dist > max_distance:
            max_distance = dist
            farthest_node = current

        for neighbor in graph[current]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append((neighbor, dist + 1))

    return farthest_node, max_distance

def tree_diameter(n, edges):
    if n == 1:
        return 0  

    graph = collections.defaultdict(list)
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)


    farthest, _ = find_farthest(1, graph)


    _, diameter = find_farthest(farthest, graph)

    return diameter

sys.setrecursionlimit(200000)  # Evitar errores en DFS para grandes n
input = sys.stdin.read
data = input().split("\n")

n = int(data[0].strip())
edges = [tuple(map(int, line.split())) for line in data[1:n] if line]

print(tree_diameter(n, edges))