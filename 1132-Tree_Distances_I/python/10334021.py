import sys
from collections import deque

sys.setrecursionlimit(1000000)
input = sys.stdin.read

def bfs(start, n, tree):
    distances = [-1] * (n + 1)
    queue = deque([start])
    distances[start] = 0
    farthest_node = start
    max_distance = 0

    while queue:
        node = queue.popleft()
        current_distance = distances[node]

        for neighbor in tree[node]:
            if distances[neighbor] == -1:  # Not visited
                distances[neighbor] = current_distance + 1
                queue.append(neighbor)
                if distances[neighbor] > max_distance:
                    max_distance = distances[neighbor]
                    farthest_node = neighbor

    return farthest_node, distances

def main():
    data = input().split()
    n = int(data[0])
    tree = [[] for _ in range(n + 1)]

    index = 1
    for _ in range(n - 1):
        a = int(data[index])
        b = int(data[index + 1])
        tree[a].append(b)
        tree[b].append(a)
        index += 2

    # First BFS from an arbitrary node (let's choose node 1)
    farthest_node_from_first, _ = bfs(1, n, tree)

    # Second BFS from the farthest node found
    farthest_node_from_farthest, distances_from_farthest = bfs(farthest_node_from_first, n, tree)

    # Third BFS from the other farthest node found
    _, distances_from_another_farthest = bfs(farthest_node_from_farthest, n, tree)

    # The answer for each node is the maximum of the distances from the two farthest ends
    results = [max(distances_from_farthest[i], distances_from_another_farthest[i]) for i in range(1, n + 1)]

    print(' '.join(map(str, results)))

if __name__ == "__main__":
    main()