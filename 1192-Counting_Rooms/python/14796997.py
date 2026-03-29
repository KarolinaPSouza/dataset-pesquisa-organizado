from collections import deque
import sys


def bfs_grid_traversal(grid):
    R, C = len(grid), len(grid[0])
    visited = [[False] * C for _ in range(R)]
    DIRS = [(1, 0), (-1, 0), (0, -1), (0, 1)]
    total_rooms = 0

    def bfs(s_x, s_y):
        queue = deque()
        queue.append((s_x, s_y))

        while queue:
            x, y = queue.popleft()

            for d_x, d_y in DIRS:
                new_x = d_x + x
                new_y = d_y + y

                if 0 <= new_x < R and 0 <= new_y < C and not visited[new_x][new_y] and grid[new_x][new_y] == ".":
                    visited[new_x][new_y] = True
                    queue.append((new_x, new_y))

    for i in range(R):
        for j in range(C):
            if grid[i][j] == "." and not visited[i][j]:
                total_rooms += 1
                bfs(i, j)
    return total_rooms

n, m = map(int, sys.stdin.readline().split())

graph = []

for _ in range(n):
    current_row = list(sys.stdin.readline().strip())
    graph.append(current_row)

print(bfs_grid_traversal(graph))