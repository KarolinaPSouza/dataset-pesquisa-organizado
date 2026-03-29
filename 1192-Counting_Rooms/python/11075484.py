def bfs(i, j):
    stack = [(i, j)]
    while stack:
        x, y = stack.pop()
        s[x][y] = "#"
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and s[nx][ny] == ".":
                stack.append((nx, ny))


n, m = map(int, input().split())
s = [list(input()) for _ in range(n)]

ans = 0
for i in range(n):
    for j in range(m):
        if s[i][j] == ".":
            bfs(i, j)
            ans += 1

print(ans)