def counting_rooms(n, m, grid):
    visited = [[0] * m for _ in range(n)]
    count = 0

    # Directions: left, up, right, down
    directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]

    for i in range(n):
        for j in range(m):
            if grid[i][j] == "." and not visited[i][j]:
                count += 1
                stack = [(i, j)]
                visited[i][j] = 1

                while stack:
                    r, c = stack.pop()
                    for dr, dc in directions:
                        nr, nc = r + dr, c + dc
                        if 0 <= nr < n and 0 <= nc < m:
                            if grid[nr][nc] == "." and not visited[nr][nc]:
                                visited[nr][nc] = 1
                                stack.append((nr, nc))

    return count


# ---------------- Main -----------------
n, m = map(int, input().split())
grid = [list(input().strip()) for _ in range(n)]

print(counting_rooms(n, m, grid))