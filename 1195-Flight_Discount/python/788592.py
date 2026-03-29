import sys
from heapq import *
input=sys.stdin.readline
n,m = map(int,input().split())
ef=[[] for _ in range(n+1)]
eb=[[] for _ in range(n+1)]
for _ in range(m):
    a,b,c=map(int,input().split())
    ef[a].append((b,c))
    eb[b].append((a,c))

df=[float("inf")]*(n+1)
db=[float("inf")]*(n+1)

def djk(i,d,e):
    d[i]=0
    q=[(0,i)]
    while q:
        p,a = heappop(q)
        if p==d[a]:
            for b,c in e[a]:
                if d[b]>p+c:
                    d[b]=p+c
                    heappush(q,(d[b],b))

djk(1,df,ef)
djk(n,db,eb)

d = float("inf")
for a in range(1,n+1):
    for b,c in ef[a]:
        d = min(d, c//2+df[a]+db[b])

print(d)