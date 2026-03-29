def count_rooms(n, m, grid):
    def dfs(x, y):
        stack = [(x, y)]
        while stack:
            cx, cy = stack.pop()
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == '.':
                    grid[nx][ny] = '#'  # Mark as visited
                    stack.append((nx, ny))

    room_count = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.':
                dfs(i, j)
                room_count += 1

    return room_count

# Reading input
import sys
input = sys.stdin.read
data = input().split()

n = int(data[0])
m = int(data[1])
grid = [list(data[i + 2]) for i in range(n)]

# Calculate the number of rooms
result = count_rooms(n, m, grid)

# Print the result
print(result)