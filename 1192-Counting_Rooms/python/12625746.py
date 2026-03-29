from collections import deque

def bfs(grid, row, col, n, m):
    moves = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    queue = deque([(row, col)])
    grid[row][col] = '#'
    while queue:
        cur_r, cur_c = queue.popleft()
        for dr, dc in moves:
            new_row, new_col = cur_r + dr, cur_c + dc
            if 0 <= new_row < n and 0 <= new_col < m and grid[new_row][new_col] == '.':
                queue.append((new_row, new_col))
                grid[new_row][new_col] = '#'
    return grid

n, m = map(int, input().split())
grid = [list(input().strip()) for _ in range(n)]
component_count = 0
for row in range(n):
    for col in range(m):
        if grid[row][col] == '.':
            grid = bfs(grid, row, col, n, m)
            component_count += 1
print(component_count)