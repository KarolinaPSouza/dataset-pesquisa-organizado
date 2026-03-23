import sys
from bisect import bisect_right
n, m = map(int, input().split())
h = list(map(int, input().split()))
h.sort()
P = list(range(n + 1))
p = []
for t in list(map(int, input().split())):
    old_a = a = bisect_right(h, t)
    while a != P[a]:
        a = P[a]
    while old_a != a:
        P[old_a], old_a = a, P[old_a]
    if a:
        p.append(str(h[a - 1]))
        P[a] = a - 1
    else:
        p.append('-1')
print('\n'.join(p))