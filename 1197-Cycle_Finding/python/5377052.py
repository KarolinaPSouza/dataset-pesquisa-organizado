import sys; R = sys.stdin.readline
from collections import deque

n,m = map(int,R().split())

e = []
for _ in range(m):
    u,v,w = map(int,R().split())
    if u==v and w<0: print("YES"); print(u,u); exit()
    e += (u,v,w),
p = [0]*(n+1)
d = [0]*(n+1)

for _ in range(n-1):
    for u,v,w in e:
        if d[u]+w<d[v]:
            d[v] = d[u]+w
            p[v] = u

for u,v,w in e:
    if d[u]+w<d[v]:
        print("YES")
        for i in range(n): v = p[v]
        res = [v]
        u = p[v]
        while u!=v:
            res += u,
            u = p[u]
        print(v,end= ' ')
        for u in reversed(res): print(u,end=' ')
        exit()
print("NO")