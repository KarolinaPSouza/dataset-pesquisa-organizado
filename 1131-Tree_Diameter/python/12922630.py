n=int(input())
adj=[[] for i in range(n+1)]
for _ in range(n-1):
    a,b=map(int,input().split())
    adj[a].append(b)
    adj[b].append(a)
dist=[0 for i in range(n+1)]
stck=[1]
visited=set()
while stck:
    parent=stck.pop()
    visited.add(parent)
    for child in adj[parent]:
        if child not in visited:
            stck.append(child)
            dist[child]=dist[parent]+1
stck=[dist.index(max(dist))]
if stck==[0]:
    stck=[1]
visited=set()
dist=[0 for i in range(n+1)]
while stck:
    parent=stck.pop()
    visited.add(parent)
    for child in adj[parent]:
        if child not in visited:
            stck.append(child)
            dist[child]=dist[parent]+1
print(max(dist))