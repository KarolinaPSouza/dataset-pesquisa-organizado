n, m = map(int, input().split())


matrix = []
for _ in range(n):
    matrix.append(input())

visited = [[False] * m for _ in range(n)]

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  

ans = 0




for i in range(n):
    for j in range(m):
        if matrix[i][j] == '.' and not visited[i][j]:
            ans += 1
            stack = [(i, j)]
            visited[i][j] = True
            while stack:
                x, y = stack.pop()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < m:
                        if matrix[nx][ny] == '.' and not visited[nx][ny]:
                            stack.append((nx, ny))
                            visited[nx][ny] = True

print(ans)