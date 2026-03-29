n,m = map(int, input().split())

grid = [list(input().strip()) for _ in range(n)]

directions = [(-1,0),(1,0),(0,-1),(0,1)]
def dfs(x,y): # les coordonnées de la source 
    s = [(x,y)] 
    while s :
        cx , cy = s.pop() 
        grid[cx][cy] = '#' # marquer la position comme visitée 
        for dx , dy in directions :
            nx , ny = cx + dx , cy + dy 
            if 0 <= nx < n and 0<= ny < m and grid[nx][ny] == '.':
                s.append((nx,ny))
room_count = 0
for i in range(n):
    for j in range(m):
        if grid[i][j] == '.':
            dfs(i,j)
            room_count += 1

print(room_count)





