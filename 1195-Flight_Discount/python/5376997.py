import sys; R = sys.stdin.readline
from heapq import heappop, heappush

n,m = map(int,R().split())
edge = [[] for _ in range(n+1)]
for _ in range(m):
    u,v,w = map(int,R().split())
    edge[u] += (w,v),

d1 = [float("inf")]*(n+1)
d2 = [float("inf")]*(n+1)
d1[1] = d2[1] = 0
que = [(0,1,0)]
while que:
    d,u,x = heappop(que)
    if d1[u]==d or d2[u]==d+x:
        for w,v in edge[u]:
            dd,xx = (d+x+w//2,(w+1)//2) if (w+1)//2>x else (d+w,x)
            if d1[v]>dd or d2[v]>dd+xx:
                d1[v] = min(d1[v],dd)
                d2[v] = min(d2[v],dd+xx)
                heappush(que,(dd,v,xx))
print(d1[n])