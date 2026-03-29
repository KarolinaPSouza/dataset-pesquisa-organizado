n,m = [int(t) for t in input().split()]
mp = [['#']*(m+2)]+[list('#'+input()+'#') for _ in range(n)]+[['#']*(m+2)]

def dfs(i,j):
    stack=[(i,j)]
    while stack:
        r,c = stack.pop()
        mp[r][c]='#'
        for x,y in (1,0),(0,-1),(-1,0),(0,1):
            if mp[r+x][c+y]=='.':
                stack.append((r+x,c+y))

ans=0
for i in range(1,n+1):
    for j in range(1,m+1):
        if mp[i][j]=='.':
            dfs(i,j)
            ans+=1

print(ans)