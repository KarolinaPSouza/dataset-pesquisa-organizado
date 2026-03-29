def dfs(x, y):
    stack = [(x, y)]
    visited[x][y] = True
    while stack:
        x,y = stack.pop()
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and grid[nx][ny] == '.':
                    visited[nx][ny] = True
                    stack.append((nx, ny))
n, m = map(int, input().split())
grid = [list(input().strip()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
directions = [(-1,0), (1,0), (0,-1), (0,1)]
rooms = 0
for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not visited[i][j]:
            rooms += 1
            dfs(i, j)
print(rooms)