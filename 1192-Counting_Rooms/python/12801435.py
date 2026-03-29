from collections import deque

# Read input
n, m = map(int, input().split())
grid = [input() for _ in range(n)]

# Initialize visited array and room counter
visited = [[False] * m for _ in range(n)]
room_count = 0
directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]  # right, left, down, up

# Iterate through each cell in the grid
for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not visited[i][j]:
            # Found a new room
            room_count += 1
            # Start BFS
            queue = deque([(i, j)])
            visited[i][j] = True
            while queue:
                x, y = queue.popleft()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if (0 <= nx < n and 0 <= ny < m and 
                        grid[nx][ny] == '.' and not visited[nx][ny]):
                        queue.append((nx, ny))
                        visited[nx][ny] = True

# Output the number of rooms
print(room_count)