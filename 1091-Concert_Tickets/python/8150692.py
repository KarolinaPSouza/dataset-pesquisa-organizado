from bisect import *
n, m, *x = [*map(int, open(0).read().split())]
h = sorted(x[:n])
S = int((n+1)**.5)
s = [h[i:i+S] for i in range(0, n+S, S)]
for m in x[n:]:
 for i, b in enumerate(s):
  if b and b[0]>m: break
 i -= 1
 j = bisect_right(s[i], m)-1
 print(-1 if i<0 or j<0 else s[i].pop(j))
 if i>=0 and not s[i]: s.pop(i)