import sys; input=sys.stdin.readline
dx=[(1,0),(-1,0),(0,1),(0,-1)]
n,m=map(int,input().split())
a=[input() for j in range(n)]
v=[[0 for k in range(m)] for j in range(n)]
cnt=0
for j in range(n):
  for k in range(m):
    if not(v[j][k]) and a[j][k]=='.':
      v[j][k]=1
      s=[(j,k)]
      cnt+=1
      while s:
        u=s.pop()
        for t in dx:
          x,y=u[0]+t[0],u[1]+t[1]
          if 0<=x<n and 0<=y<m and not(v[x][y]) and a[x][y]=='.':
            s.append((x,y))
            v[x][y]=1
print(cnt)