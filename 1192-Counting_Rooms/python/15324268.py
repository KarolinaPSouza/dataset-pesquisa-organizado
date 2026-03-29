n, m = map(int, input().split())
grid = [list(input().strip()) for _ in range(n)]

visited = [[False]*m for _ in range(n)]

def dfs_iter(r, c):
    stack = [(r, c)]

    while stack:
        x, y = stack.pop()

        if visited[x][y]:
            continue
        visited[x][y] = True

        if x+1 < n and grid[x+1][y] == '.' and not visited[x+1][y]:
            stack.append((x+1, y))
        if x-1 >= 0 and grid[x-1][y] == '.' and not visited[x-1][y]:
            stack.append((x-1, y))
        if y+1 < m and grid[x][y+1] == '.' and not visited[x][y+1]:
            stack.append((x, y+1))
        if y-1 >= 0 and grid[x][y-1] == '.' and not visited[x][y-1]:
            stack.append((x, y-1))


rooms = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not visited[i][j]:
            dfs_iter(i, j)
            rooms += 1

print(rooms)