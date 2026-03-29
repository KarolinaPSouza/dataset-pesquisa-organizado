from collections import deque

n, m = map(int, input().split())

grid = []

for _ in range(n):
    line = input().strip()
    grid.append(line)

visited = []
for _ in range(n):
    row = []
    for _ in range(m):
        row.append(False)
    visited.append(row)


out = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not visited[i][j]:
            out += 1
            queue = deque()
            queue.append((i,j))
            visited[i][j] = True

            while queue:
                x,y = queue.popleft()

                for moveX,moveY in [(1,0),(0,1),(-1,0),(0,-1)]:
                    newX,newY = x+moveX, y+moveY

                    if 0 <= newX < n and 0 <= newY < m:
                        if grid[newX][newY] == '.' and not visited[newX][newY]:
                            visited[newX][newY] = True
                            queue.append((newX, newY))

print(out)