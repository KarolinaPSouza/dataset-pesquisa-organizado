import sys 
from collections import defaultdict,deque
input=sys.stdin.buffer.readline
n=int(input())
g=defaultdict(list)
for _ in range(n-1):
    a,b=map(int,input().split())
    g[a].append(b)
    g[b].append(a)

q=deque([[1,0]])
vis=set()
while q:
    u=q.popleft()
    vis.add(u[0])
    for v in g[u[0]]:
        if v not in vis:
            q.append([v,u[1]+1])
u=u[0]
q=deque([[u,0]])
vis=set()
while q:
    u=q.popleft()
    vis.add(u[0])
    for v in g[u[0]]:
        if v not in vis:
            q.append([v,u[1]+1])
print(u[1])
