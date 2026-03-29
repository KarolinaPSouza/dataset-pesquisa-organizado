import sys
from collections import deque as dek
def print(a):
    sys.stdout.write(str(a)+'\n')
def input():
    return sys.stdin.readline()
rm=[-1,1,0,0]
cm=[0,0,1,-1]
def bfs(i,j):
    q=dek()
    q.append((i,j))
    mat[i][j]='#'
    while q:
        x,y=q.popleft()

        for k in range(4):
            xn=x+rm[k]
            yn=y+cm[k]
            if xn>=0 and yn>=0 and xn<r and yn<c and mat[xn][yn] =='.':
                q.append((xn,yn))
                mat[xn][yn]='#'
r,c=map(int,input().split())
mat=[]
count=0
for i in range(r):
    mat.append(list(input()))
for i in range(r):
    for j in range(c):
        if mat[i][j]=='.':
            bfs(i,j)
            count+=1
            # ~ wMat(mat)
print(count)