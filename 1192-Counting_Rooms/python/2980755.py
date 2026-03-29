n,m = map(int,input().split())
building = [[c == '.' for c in input()] for _ in range(n)]

def DFS(x,y):
    stack = [(x,y)]
    while stack:
        x, y = stack.pop()
        if 0 <= x < n and 0 <= y < m:
            if building[x][y]:
                building[x][y] = False
                stack.append((x-1, y))
                stack.append((x+1,y))
                stack.append((x,y-1))
                stack.append((x,y+1))

rooms = 0
for i in range(n):
    for j in range(m):
        if building[i][j]:
            rooms += 1
            DFS(i,j)

print(rooms)