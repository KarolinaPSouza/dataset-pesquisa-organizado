def dfs(x, y, n, m, grid, visited):
    stack = [(x, y)]
    while stack:
        cx, cy = stack.pop()
        if visited[cx][cy]:
            continue
        visited[cx][cy] = True
        for nx, ny in [(cx-1, cy), (cx+1, cy), (cx, cy-1), (cx, cy+1)]:
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and grid[nx][ny] == '.':
                stack.append((nx, ny))

def count_rooms(n, m, grid):
    visited = [[False] * m for _ in range(n)]
    room_count = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.' and not visited[i][j]:
                dfs(i, j, n, m, grid, visited)
                room_count += 1
    return room_count

n, m = map(int, input().split())
grid = [input().strip() for _ in range(n)]

print(count_rooms(n, m, grid))