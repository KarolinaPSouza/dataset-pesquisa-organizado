import sys; input=sys.stdin.readline
n=int(input())
g=[[] for j in range(n)]
for j in range(n-1):
  u,v=map(int,input().split())
  g[u-1].append(v-1)
  g[v-1].append(u-1)
s=[0]
vis=[0]*n
vis[s[0]]=1
dp1=[0]*n
while s:
  parent=s.pop()
  for child in g[parent]:
    if not(vis[child]):
      vis[child]=1
      s.append(child)
      dp1[child]=dp1[parent]+1
s=[max([(dp1[j],j) for j in range(n)])[1]]
vis=[0]*n
vis[s[0]]=1
dp2=[0]*n
while s:
  parent=s.pop()
  for child in g[parent]:
    if not(vis[child]):
      vis[child]=1
      s.append(child)
      dp2[child]=dp2[parent]+1
s=[max([(dp2[j],j) for j in range(n)])[1]]
vis=[0]*n
vis[s[0]]=1
dp3=[0]*n
while s:
  parent=s.pop()
  for child in g[parent]:
    if not(vis[child]):
      vis[child]=1
      s.append(child)
      dp3[child]=dp3[parent]+1
print(*[max(dp2[j],dp3[j]) for j in range(n)])