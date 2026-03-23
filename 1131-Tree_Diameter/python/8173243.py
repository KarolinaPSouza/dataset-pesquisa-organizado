n, *e = [*map(int, open(0).read().split())]
G = [[] for _ in range(n+1)]
for a, b in zip(*[iter(e)]*2):
 G[a] += [b]
 G[b] += [a]


def dfs(x):
 Q = [(x, 0, 0)]
 while Q:
  x, p, d = Q.pop()
  yield d, x
  for u in G[x]:
   if u!=p: Q += (u, x, d+1),


print(max(dfs(max(dfs(1))[1]))[0])