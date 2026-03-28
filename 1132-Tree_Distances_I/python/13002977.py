import sys
input = lambda: sys.stdin.readline().rstrip()
n=int(input())
adj=[[] for i in range(n+1)]
for _ in range(n-1):
    a,b=map(int,input().split())
    adj[a].append(b)
    adj[b].append(a)
stck=[1]
visited=[0 for i in range(n+1)]
dist=[0 for i in range(n+1)]
mx=[0,0]#node dist
while stck:
    parent=stck.pop()
    visited[parent]=1
    for child in adj[parent]:
        if visited[child]==0:
            dist[child]=dist[parent]+1
            if dist[child]>mx[1]:
                mx=[child,dist[child]]
            stck.append(child)
diamiter_points=[mx[0]]
stck=[mx[0]]
visited=[0 for i in range(n+1)]
dist=[0 for i in range(n+1)]
mx=[0,0]#node dist
while stck:
    parent=stck.pop()
    visited[parent]=1
    for child in adj[parent]:
        if visited[child]==0:
            dist[child]=dist[parent]+1
            if dist[child]>mx[1]:
                mx=[child,dist[child]]
            stck.append(child)
diamiter_points.append(mx[0])
ans=[0 for i in range(n+1)]
for a in diamiter_points:
    stck=[a]
    visited=[0 for i in range(n+1)]
    dist=[0 for i in range(n+1)]
    while stck:
        parent=stck.pop()
        visited[parent]=1
        for child in adj[parent]:
            if visited[child]==0:
                dist[child]=dist[parent]+1
                ans[child]=max(ans[child],dist[child])
                stck.append(child)
print(*ans[1:])