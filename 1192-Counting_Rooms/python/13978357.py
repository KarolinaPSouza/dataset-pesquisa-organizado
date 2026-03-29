n, m = map(int, input().split())
grid = [input() for _ in range(n)]
grid_bool = [[False] * m  for _ in range(n)]

def floor_counter(x, y):
    stack = [(x, y)]
    while stack:
        cx, cy = stack.pop()
        if grid_bool[cx][cy]:
            continue
        grid_bool[cx][cy] = True
        for dx, dy in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
            nx, ny = cx + dx, cy + dy
            if 0 <= nx < n and 0 <= ny < m:
                if grid[nx][ny] == "." and not grid_bool[nx][ny]:
                    stack.append((nx, ny))

rooms = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == "." and not grid_bool[i][j]:
            floor_counter(i, j)
            rooms += 1

print(rooms)