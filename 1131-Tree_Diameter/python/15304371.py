import sys
from collections import deque

def solve():
    node_count = int(sys.stdin.readline())

    if node_count == 1:
        print(0)
        return

    adjacency_list = [[] for _ in range(node_count)]

    for _ in range(node_count - 1):
        node_u, node_v = map(int, sys.stdin.readline().split())
        node_u -= 1
        node_v -= 1
        adjacency_list[node_u].append(node_v)
        adjacency_list[node_v].append(node_u)

    def bfs(start):
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

        return farthest_node, farthest_distance

    node_from_start, _ = bfs(0)
    opposite_end_node, tree_diameter = bfs(node_from_start)

    print(tree_diameter)

solve()