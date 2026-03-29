# chatGPT wrong implementation for horse, otherwise pretty good
import sys
from heapq import *
input = lambda: sys.stdin.readline().rstrip("\r\n")
sint = lambda: int(input())
mint = lambda: map(int, input().split())
aint = lambda: list(map(int, input().split()))
###############################################
def dij(ss):
    dis=[[big]*(n+1) for _ in range(2)]
    dis[0][ss]=0
    chkd=[[0]*(n+1) for _ in range(2)]
    Q=[(0,ss)]
    while Q:
        v,i=heappop(Q)
        ride=(v!=dis[0][i])
        if chkd[ride][i]:continue
        chkd[ride][i]=1
        for j,w in g[i]:
            nv=v+w
            if nv<dis[ride][j]:dis[ride][j]=nv;heappush(Q,(nv,j))
            if ride==0:
                nv=v+w//2
                if nv<dis[1][j]:dis[1][j]=nv;heappush(Q,(nv,j))
    return dis
#################################################
big=float('inf')
t = 1
for _ in range(t):
    n,m=mint()
    g = [[] for _ in range(n + 1)]  #set up adjacency matrix
    for _ in range(m):
        u, v, w = mint()
        g[u].append((v,w))
    dM=dij(1)
    print(dM[1][n])