I=input
R=range
n,m=map(int,I().split())
G=[[i=="."for i in I()]for _ in R(n)]
S=0
for i in R(n):
 for j in R(m):
  if G[i][j]:
   S+=1
   D=[(i,j)]
   while D:
    y,x=D.pop()
    for Y,X in((0,1),(1,0),(0,-1),(-1,0)):
     Y+=y
     X+=x
     if n>Y>=0<=X<m and G[Y][X]:
      G[Y][X]=0
      D.append((Y,X))
print(S)