import sys
from collections import deque

def main():
    n = int(sys.stdin.readline())
    adj = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, sys.stdin.readline().split())
        adj[a].append(b)
        adj[b].append(a)

    def bfs(start):
        visited = [-1] * (n + 1)
        queue = deque([start])
        visited[start] = 0
        farthest_node = start
        max_distance = 0

        while queue:
            node = queue.popleft()
            for neighbor in adj[node]:
                if visited[neighbor] == -1:
                    visited[neighbor] = visited[node] + 1
                    queue.append(neighbor)
                    if visited[neighbor] > max_distance:
                        max_distance = visited[neighbor]
                        farthest_node = neighbor
        return farthest_node, max_distance

    # First BFS to find one end of the diameter
    u, _ = bfs(1)

    # Second BFS to find the other end of the diameter
    v, diameter = bfs(u)

    print(diameter)

if __name__ == "__main__":
    main()