import sys
from collections import deque
input=sys.stdin.readline
n=int(input())
g=[[] for _ in range(n)]
for _ in range(n-1):
    a,b=map(int,input().split())
    g[a-1].append(b-1)
    g[b-1].append(a-1)
def bfs(s):
    d=[-1]*n
    q=deque([s])
    d[s]=0
    while q:
        u=q.popleft()
        for v in g[u]:
            if d[v]==-1:
                d[v]=d[u]+1
                q.append(v)
    far=max(range(n), key=lambda x: d[x])
    return far,d
u,_=bfs(0)
v,du=bfs(u)
_,dv=bfs(v)
print(' '.join(str(max(du[i],dv[i])) for i in range(n)))