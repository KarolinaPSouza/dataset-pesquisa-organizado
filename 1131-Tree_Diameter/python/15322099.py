import sys
from collections import deque

sys.setrecursionlimit(2000000) # Increase recursion depth for potential DFS use, though BFS is used here

def bfs_farthest(start_node, n, adj):
    """
    Performs BFS from a start_node to find the farthest node and its distance.
    Returns: (farthest_node, max_distance)
    """
    distances = [-1] * (n + 1)
    q = deque([(start_node, 0)])
    distances[start_node] = 0

    max_distance = -1
    farthest_node = -1

    while q:
        current_node, current_dist = q.popleft()

        if current_dist > max_distance:
            max_distance = current_dist
            farthest_node = current_node

        for neighbor in adj[current_node]:
            if distances[neighbor] == -1:
                distances[neighbor] = current_dist + 1
                q.append((neighbor, current_dist + 1))

    return farthest_node, max_distance

def solve():
    """
    Reads input, calculates diameter, and prints the result.
    """
    try:
        line1 = sys.stdin.readline()
        if not line1:
            return
        n = int(line1)
    except ValueError:
        return

    if n == 0:
        print(0)
        return
    if n == 1:
        print(0)
        return

    # Build adjacency list (1-based indexing)
    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        line = sys.stdin.readline()
        if not line:
            continue
        try:
            u, v = map(int, line.split())
            adj[u].append(v)
            adj[v].append(u)
        except ValueError:
            continue

    # Step 1: Find the farthest node from an arbitrary node (node 1)
    node_u, _ = bfs_farthest(1, n, adj)

    # Step 2: Find the farthest node from node_u to get the diameter
    _, diameter = bfs_farthest(node_u, n, adj)

    print(diameter)

if __name__ == "__main__":
    solve()