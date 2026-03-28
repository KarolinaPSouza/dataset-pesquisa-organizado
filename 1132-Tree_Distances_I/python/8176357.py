n, *e = map(int, open(0).read().split())
n += 1
G = [[] for _ in n*' ']
for a, b in zip(*[iter(e)]*2):
 G[a] += b,
 G[b] += a,
D = n*[0]


def d(_, x):
 Q = [(x, 0, 0)]
 while Q:
  x, p, d = Q.pop()
  if d>D[x]: D[x] = d
  yield d, x
  Q += [(u, x, d+1) for u in G[x] if u!=p]


max(d(*max(d(*max(d(0, 1))))))
print(*D[1:])