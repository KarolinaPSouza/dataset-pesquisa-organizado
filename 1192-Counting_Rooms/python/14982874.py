def count_rooms():
    n, m = map(int, input().split())
    grid = []
    for _ in range(n):
        grid.append(list(input().strip()))

    visited = [[False] * m for _ in range(n)]

    def dfs(start_row, start_col):
        stack = [(start_row, start_col)]
        visited[start_row][start_col] = True
        while stack:
            row, col = stack.pop()
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr, nc = row + dr, col + dc
                if 0 <= nr < n and 0 <= nc < m:
                    if grid[nr][nc] == '.' and not visited[nr][nc]:
                        visited[nr][nc] = True
                        stack.append((nr, nc))
    room_count = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.' and not visited[i][j]:
                dfs(i, j)
                room_count += 1

    print(room_count)

count_rooms()