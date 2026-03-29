n,m = map(int, input().split())
arr = [ list(input()) for i in range(n)]
ans=0
q=[]
for i in range(n):
    for j in range(m):
        if arr[i][j] == '.':
            q.append((i,j))
            arr[i][j]='#'
            while q:
                x,y = q.pop()
                for a,b in zip([1,0,-1,0],[0,1,0,-1]):
                    if 0<=x+a<n and 0<=y+b<m and arr[x+a][y+b]=='.':
                        q.append((x+a,y+b))
                        arr[x+a][y+b]='#'
            ans+=1
print(ans)
