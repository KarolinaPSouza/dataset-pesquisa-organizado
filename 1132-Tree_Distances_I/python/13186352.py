from collections import deque
n=int(input())
adj=[[] for i in range(n)]
for i in range(n-1):
    a,b=map(int,input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)
q=deque()
q.append(0)
vis=[0 for i in range(n)]
vis[0]=1
lastvis=0
while q:
    x=q.popleft()
    for v in adj[x]:
        if vis[v]==0:
            vis[v]=1
            q.append(v)
            lastvis=v
q=deque()
last=lastvis
q.append(lastvis)
vis=[0 for i in range(n)]
dis2=[0]*n
vis[lastvis]=1
level=0
while q:
    y=len(q)
    level+=1
    while y:
        y-=1
        x=q.popleft()
        for v in adj[x]:
            if vis[v]==0:
                vis[v]=1
                q.append(v)
                last=v
                dis2[v]=level

dis1=[0 for i in range(n)]
level=0
vis=[0]*n
vis[last]=1
q=deque()
q.append(last)
while q:
    y=len(q)
    level+=1
    while y:
        y-=1
        x=q.popleft()
        for v in adj[x]:
            if vis[v]==0:
                vis[v]=1
                q.append(v)
                dis1[v]=level


dis=[max(dis1[i],dis2[i]) for i in range(n)]
print(*dis)