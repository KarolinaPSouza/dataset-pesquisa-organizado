from collections import deque

n, m = [int(e) for e in input().split()]
grid, vi = [], [[False] * m for _ in range(n)]
cnt = 0

def bfs(initi, initj) :
    q = deque()
    q.append((initi, initj))
    while(len(q) != 0) :
        i, j = q.popleft()
        if(i < 0 or i >= n or j < 0 or j >= m or vi[i][j] == True or grid[i][j] == '#') :
            continue
        vi[i][j] = True
        q.append((i + 1, j))
        q.append((i - 1, j))
        q.append((i, j + 1))
        q.append((i, j - 1))

for i in range(n) :
    grid.append(input())
for i in range(n) :
    for j in range(m) :
        if(grid[i][j] == '#' or vi[i][j] == True) :
            continue
        bfs(i, j)
        cnt += 1
print(cnt)