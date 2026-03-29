from collections import deque

n,m=map(int,input().split())
ans=[0]*(n+1)
l=[]
parent=[-1]*(n+1)
graph=[[] for _ in range(n+1)]
for _ in range(m):
    u,v,w=map(int,input().split())
    l.append([u,v,w])
    graph[u].append((v,w))
ans[1]=0
for _ in range(n):
    for u,v,w in l:
        if ans[v]>ans[u]+w:
            ans[v]=ans[u]+w
            parent[v]=u


cycle_start=-1
for u, v, w in l:
    if ans[v] > ans[u] + w:
        cycle_start=u
        break

if cycle_start!=-1:
    for _ in range(n):
        cycle_start=parent[cycle_start]
    des=u
    cycle=[]
    v = cycle_start
    cycle.append(v)
    v = parent[v]
    while v != cycle_start:
        cycle.append(v)
        v = parent[v]
    cycle.append(cycle_start)
    cycle.reverse()
    print("YES")
    print(*cycle)

else:
    print("NO")


