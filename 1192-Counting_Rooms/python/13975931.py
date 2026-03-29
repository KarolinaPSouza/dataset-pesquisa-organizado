from collections import deque

def count_rooms(n, m, grid):
    visited = [[False]*m for _ in range(n)]
    directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]
    room_count = 0

    def bfs(sr, sc):
        queue = deque()
        queue.append((sr, sc))
        visited[sr][sc] = True

        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < m:
                    if not visited[nr][nc] and grid[nr][nc] == '.':
                        visited[nr][nc] = True
                        queue.append((nr, nc))

    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.' and not visited[i][j]:
                room_count += 1
                bfs(i, j)

    return room_count

# Input reading
n, m = map(int, input().split())
grid = [input().strip() for _ in range(n)]

# Output
print(count_rooms(n, m, grid))