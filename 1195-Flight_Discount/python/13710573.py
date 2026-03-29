import heapq,sys
n,m=map(int,sys.stdin.readline().split())
g=[[] for _ in range(n)]
for _ in range(m):
    a,b,c=map(int,sys.stdin.readline().split())
    a-=1
    b-=1
    g[a].append((b,c))
vs=[10**18]*(n*2)
vs[0]=0
class Q:
    def __init__(self):
        self.d=0
        self.f=0
        self.u=0
    def __lt__(self,o):
        return self.d<o.d
q=[Q()]
while q:
    uu=heapq.heappop(q)
    d=uu.d
    f=uu.f
    u=uu.u
    if d>vs[f*n+u]:
        continue
    for v,c in g[u]:
        if d+c<vs[f*n+v]:
            vs[f*n+v]=d+c
            vv=Q()
            vv.d=d+c
            vv.f=f
            vv.u=v
            heapq.heappush(q,vv)
        if f==0:
            nc=d+c//2
            if nc<vs[n+v]:
                vs[n+v]=nc
                vv=Q()
                vv.d=nc
                vv.f=1
                vv.u=v
                heapq.heappush(q,vv)
print(vs[n+n-1])