import sys
input=sys.stdin.readline
from collections import deque
import heapq
n,m=map(int,input().split())
L=[]
for i in range(m):
    u,v,w=map(int,input().split())
    L.append((u,v,w))
dist=[10**20]*(n+1)
dist[1]=0
par=[-1]*(n+1)
for i in range(n-1):
    for j in range(len(L)):
        u,v,w=L[j]
        if(dist[u]+w<dist[v]):
            dist[v]=dist[u]+w
            par[v]=u
l=[]
end=-1
for i in range(len(L)):
    u,v,w=L[i]
    if(dist[u]+w<dist[v]):
        dist[v]=dist[u]+w
        l.append(v)
        par[v]=u
        end=v
if(end==-1):
    print("NO")
else:
    print("YES")
    for i in range(n):
        end=par[end]
    v=par[end]
    ans=[end]
    # print(par,end)
    while(v!=end):
        ans.append(v)
        v=par[v]
    ans.append(end)
    ans.reverse()
    print(*ans)

    # ans=[end]
    # v=par[end]
    # # print(par,dist,end)
    # vis=[0]*(n+1)
    # vis[end]=1
    # start=-1
    # while(True):
    #     vis[v]=1
    #     ans.append(v)
    #     v=par[v]
    #     if(vis[v]==1):
    #         ans.append(v)
    #         start=v
    #         break
    # lst=[start]
    # ans.reverse()
    # for i in range(1,len(ans)):
    #     lst.append(ans[i])
    #     if(ans[i]==start):
    #         break
    # print(*lst)