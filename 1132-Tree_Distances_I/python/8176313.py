n, *e = map(int, open(0).read().split())
G = [[] for _ in -~n*' ']
for a, b in zip(*[iter(e)]*2):
 G[a] += b,
 G[b] += a,


def d(x):
 Q = [(x, 0, 0)]
 m = (0, 0)
 while Q:
  x, p, d = Q.pop()
  m = max(m, (d, x))
  Q += [(u, x, d+1) for u in G[x] if u!=p]
 return m


def f(x, t):
 Q = [(x, -1)]
 while Q:
  x, p = Q[-1]
  if V[x]:
   V[x] = 0
   Q += [(u, x) for u in G[x] if u!=p]
  else:
   if x==t: T[x] = 1
   for u in G[x]:
    if T[u]:
     P[u] = x
     T[x] = 1
   Q.pop()


def g(x, t):
 Q = [(x, 0, t)]
 while Q:
  x, p, d = Q.pop()
  D[x] = d
  Q += [(u, x, d+1) for u in G[x] if u!=p and not T[u]]


_, a = d(1)
L, b = d(a)
D = -~n*[0]
T = -~n*[0]
P = -~n*[0]
V = -~n*[1]
f(a, b)
l = 0
while b!=0:
 D[b] = max(L-l, l)
 g(b, D[b])
 b = P[b]
 l += 1
print(' '.join(map(str, D[1:])))