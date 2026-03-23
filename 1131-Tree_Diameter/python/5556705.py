from collections import deque
def bfs(source,f):
  q=deque()
  q.append(source)
  d=[0]*n
  vis=[False]*n
  while(q):
    curr=q.popleft()
    if vis[curr]:continue
    vis[curr]=True
    for v in adj[curr]:
      if vis[v]:continue
      d[v]=d[curr]+1
      q.append(v)
  l=max(d)
  if f==1:return d.index(l)
  return l
n=int(input())
adj = [[] for i in range(n)]
for i in range(n-1):
    u,v = list(map(int,input().split()))
    u-=1;v-=1
    adj[u].append(v)
    adj[v].append(u)
sp = bfs(0,1)
print(bfs(sp,2))
