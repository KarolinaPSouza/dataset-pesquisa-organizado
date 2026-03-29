from collections import deque
n, m = tuple(map(int,input().split()))
grid = [list(input()) for _ in range(n)]

def bfs(i, j):
    Q = deque([(i, j)])
    grid[i][j] = '#'
    while Q:
        x, y = Q.popleft()
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == '.':
                grid[nx][ny] = '#'  
                Q.append((nx, ny))

def count_rooms():
    room_count = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.':  
                bfs(i, j)
                room_count += 1
    return room_count

print(count_rooms())