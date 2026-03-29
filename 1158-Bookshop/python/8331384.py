n, x, *e = map(int, open(0).read().split())
R = -~x*[0]
for h, s in zip(e[:n], e[n:]):
 t = x
 while t>=h:
  R[t] = max(R[t], R[t-h]+s)
  t -= 1
print(R[x])