import sys
sys.setrecursionlimit(500000)

def solve():
    # Fast input reading
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    n = int(input_data[0])

    if n == 0:
        sys.stdout.write("0\n")
        return
    if n == 1:
        sys.stdout.write("0\n")
        return

    # Build the adjacency list for the tree
    adj = [[] for _ in range(n + 1)]
    data_idx = 1
    for _ in range(n - 1):
        u = int(input_data[data_idx])
        v = int(input_data[data_idx + 1])
        adj[u].append(v)
        adj[v].append(u)
        data_idx += 2

    # The diameter of a tree can be found using two Breadth-First Search (BFS) or Depth-First Search (DFS) traversals.

    # Step 1: Find the farthest node 'u' from an arbitrary starting node (e.g., node 1).
    def find_farthest_node(start_node):
        # Using BFS to find the farthest node and its distance

        # Initialize distances and parent array (optional, not needed for distance)
        distance = [-1] * (n + 1)
        queue = [(start_node, 0)] # (node, dist)
        distance[start_node] = 0

        max_dist = 0
        farthest_node = start_node

        head = 0
        while head < len(queue):
            u, d = queue[head]
            head += 1

            if d > max_dist:
                max_dist = d
                farthest_node = u

            for v in adj[u]:
                if distance[v] == -1:
                    distance[v] = d + 1
                    queue.append((v, d + 1))

        return farthest_node, max_dist

    # Start BFS from node 1
    u, _ = find_farthest_node(1)

    # Step 2: Find the farthest node 'v' from node 'u'. The distance is the diameter.
    _, diameter = find_farthest_node(u)

    sys.stdout.write(str(diameter) + "\n")

if __name__ == "__main__":
    solve()