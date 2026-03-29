n,m=map(int,input().split())
visited=[[False for _ in range(m)] for _ in range(n)]
grid=[input() for _ in range(n)]
res=0

def ffill(r,c):
    global visited
    frontier=[(r,c)]
    while frontier:
        r,c=frontier.pop()
        if r<0 or r>=n or c<0 or c>=m or grid[r][c]!='.' or visited[r][c]:
            continue
        visited[r][c]=True
        frontier.append((r+1,c))
        frontier.append((r-1,c))
        frontier.append((r,c+1))
        frontier.append((r,c-1))
for row in range(n):
    for col in range(m):
        if grid[row][col]=='.' and not visited[row][col]:
            ffill(row,col)
            res+=1
print(res)