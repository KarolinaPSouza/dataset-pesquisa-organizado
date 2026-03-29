n, m = map(int, input().split())
grid = [list(input().strip()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

# Directions: up, down, left, right
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def dfs(x, y):
    stack = [(x, y)]
    while stack:
        cx, cy = stack.pop()
        for dx, dy in directions:
            nx, ny = cx + dx, cy + dy
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and grid[nx][ny] == '.':
                    visited[nx][ny] = True
                    stack.append((nx, ny))

room_count = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not visited[i][j]:
            visited[i][j] = True
            dfs(i, j)
            room_count += 1

print(room_count)