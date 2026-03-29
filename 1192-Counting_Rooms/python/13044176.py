n,m=map(int,input().split())
matrix=[]
for i in range(n):
    ch=list(input())
    matrix.append(ch)

visited=[[False for j in range(m)]for i in range(n)]
def canMove(i,j):
    return 0<=i<n and 0<=j<m

def dfs(x,y):

    dy=[0,0,-1,1]
    dx=[-1,1,0,0]
    p=[[x,y]]
    visited[x][y] = True
    while(p):
        coords=p.pop()
        a=coords[0]
        b=coords[1]
        for k in range(4):
                i=a+dx[k]
                j=b+dy[k]
                if canMove(i,j) and  visited[i][j]==False and matrix[i][j]!="#":
                    visited[i][j]=True
                    p.append([i,j])


c=0
i=0
for i in range(n):
    j=0
    for j in range(m):
        if visited[i][j] or matrix[i][j]=="#":
            continue
        dfs(i,j)
        c+=1
print(c)
