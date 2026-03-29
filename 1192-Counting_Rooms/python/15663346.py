n,m=map(int, input().split())
matrica=[]
for i in range(n):
    matrica.append(input())
visited = []
for i in range(n):
    row = []
    for j in range(m):
        row.append(False)
    visited.append(row)
directions = [(-1,0),(1,0),(0,-1),(0,1)]
ans=0 

for i in range(n):
    for j in range(m):
        if matrica[i][j]=="." and not visited[i][j]:
            ans+=1

            st=[(i, j)]
            visited[i][j]=True
            while st:
                x,y=st.pop()
                for dx,dy in directions:
                    nx,ny=x+dx,y+dy
                    if 0<=nx<n and 0<=ny<m:
                        if matrica[nx][ny]=="." and not visited[nx][ny]:
                            st.append((nx,ny))
                            visited[nx][ny]=True
print(ans)