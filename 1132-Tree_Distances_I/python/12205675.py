def dfs(x):
  s = [x]
  vis = [0]*(n+1)
  d = [0]*(n+1)
  vis[x]=1
  mx = x
  while s:
    x = s.pop()
    for v in g[x]:
      if vis[v]: continue
      d[v]=d[x]+1
      if d[v]>d[mx]: mx=v
      vis[v]=1
      s.append(v)
  return mx,d

n = int(input())
g = [[] for i in range(n+1)]
for i in range(n-1):
  u,v = map(int, input().split())
  g[u].append(v)
  g[v].append(u)
a,d1 = dfs(1)
b,da = dfs(a)
a,db = dfs(b)
ans = []
for i in range(1,n+1):
  ans.append(max(da[i], db[i]))
print(*ans)