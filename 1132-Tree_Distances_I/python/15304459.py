import sys
from collections import deque

def bfs(start, node_count, adjacency_list):
    distance = [-1] * node_count
    distance[start] = 0
    queue = deque([start])

    farthest_node = start
    farthest_distance = 0

    while queue:
        current = queue.popleft()
        for neighbor in adjacency_list[current]:
            if distance[neighbor] == -1:
                distance[neighbor] = distance[current] + 1
                queue.append(neighbor)

                if distance[neighbor] > farthest_distance:
                    farthest_distance = distance[neighbor]
                    farthest_node = neighbor

    return distance, farthest_node


node_count = int(sys.stdin.readline())

if node_count == 1:
    print(0)
    sys.exit()

adjacency_list = [[] for _ in range(node_count)]

for _ in range(node_count - 1):
    u, v = map(int, sys.stdin.readline().split())
    u -= 1
    v -= 1
    adjacency_list[u].append(v)
    adjacency_list[v].append(u)

_, endpoint_1 = bfs(0, node_count, adjacency_list)
dist_from_endpoint_1, endpoint_2 = bfs(endpoint_1, node_count, adjacency_list)
dist_from_endpoint_2, _ = bfs(endpoint_2, node_count, adjacency_list)

eccentricities = []
for node in range(node_count):
    eccentricities.append(max(dist_from_endpoint_1[node], dist_from_endpoint_2[node]))

sys.stdout.write(" ".join(map(str, eccentricities)) + "\n")