n,m=map(int,input().split())
edges=[]
for _ in range(m):
    u,v,w=map(int,input().split())
    edges.append((u,v,w))

dist=[0]*(n+1)
parent=[-1]*(n+1)
for i in range(n):
    x=-1
    for u,v,w in edges:
        if dist[u]+w<dist[v]:
            dist[v]=dist[u]+w
            parent[v]=u
            x=v


if x==-1:
    print("NO")
    exit()
else:
    for _ in range (n):
        x=parent[x]

    cycle=[]
    curr=x
    while True:
        cycle.append(curr)
        if curr==x and len(cycle)>1:
            break
        curr=parent[curr]

    cycle.reverse()
    print("YES")
    print(*cycle)





