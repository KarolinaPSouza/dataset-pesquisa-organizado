import sys
from collections import deque

def main():

    input = sys.stdin.readline

    n_str = input()
    if not n_str:
        return
    n = int(n_str)

    if n == 1:
        print(0)
        return

    adj = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        u, v = map(int, input().split())
        adj[u].append(v)
        adj[v].append(u)

    def bfs(start_node):
        distances = [-1] * (n + 1)

        queue = deque()

        distances[start_node] = 0
        queue.append(start_node)

        farthest_node = start_node
        max_dist = 0

        while queue:
            current_node = queue.popleft()

            if distances[current_node] > max_dist:
                max_dist = distances[current_node]
                farthest_node = current_node

            for neighbor in adj[current_node]:
                if distances[neighbor] == -1:
                    distances[neighbor] = distances[current_node] + 1
                    queue.append(neighbor)

        return farthest_node, max_dist

    endpoint_a, _ = bfs(1)
    _, diameter = bfs(endpoint_a)

    print(diameter)

if __name__ == "__main__":
    main()