import sys
from collections import deque
input = sys.stdin.readline

def count_rooms(n, m, grid):
    visited = [[False] * m for _ in range(n)]

    def bfs(i, j):
        queue = deque([(i, j)])
        visited[i][j] = True
        while queue:
            x, y = queue.popleft()
            for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    if not visited[nx][ny] and grid[nx][ny] == '.':
                        visited[nx][ny] = True
                        queue.append((nx, ny))

    count = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.' and not visited[i][j]:
                bfs(i, j)
                count += 1

    return count

# Read input fast
n, m = map(int, input().split())
grid = [input().strip() for _ in range(n)]

print(count_rooms(n, m, grid))