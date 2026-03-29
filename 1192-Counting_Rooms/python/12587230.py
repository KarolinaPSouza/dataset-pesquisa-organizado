from collections import deque

def bfs(i, j, l, visited, queue):
    while queue:
        x,y = queue.popleft()
        if (x < len(l) and x >= 0) and (y < len(l[0]) and y >= 0):
            if l[x][y] == '.' and not visited[x][y]:
                visited[x][y] = True
                queue.append((x+1,y))
                queue.append((x-1,y))
                queue.append((x,y+1))
                queue.append((x,y-1))


n, m = map(int, input().split())
l = []
for i in range(n):
    l.append(list(input()))
visited = [[False for i in range(m)] for i in range(n)]
queue = deque()
c = 0
for i in range(n):
    for j in range(m):
        if l[i][j] == '.' and not visited[i][j]:
            c+=1
            queue.append((i,j))
            bfs(i,j,l,visited,queue)
print(c)