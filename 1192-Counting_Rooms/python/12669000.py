l1=input().split()
n=int(l1[0])
m=int(l1[1])
mat=[[]for _ in range (n)]
for i in range(n):
    mat[i]=input()

visited=[[0 for _ in range(m)]for _ in range(n)]

def dfs(i,j,mat,visited):
    q=[]
    q.append([i,j])
    visited[i][j]=1
    while q:
        item=q.pop()
        for di,dj in [[1,0],[-1,0],[0,1],[0,-1]]:
            if 0<=item[0]+di<n and 0<=item[1]+dj<m:
                if mat[item[0]+di][item[1]+dj]=='.' and visited[item[0]+di][item[1]+dj]==0 :
                    q.append([item[0]+di,item[1]+dj])
                    visited[item[0]+di][item[1]+dj]=1
cnt=0    
for i in range(n):
    for j in range(m):
        if mat[i][j]=='.' and visited[i][j]==0:
            dfs(i,j,mat,visited)
            cnt+=1
print(cnt)
