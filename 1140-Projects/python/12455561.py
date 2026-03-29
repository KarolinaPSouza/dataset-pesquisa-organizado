import bisect as B
I = input
n = int(I())
D = {}
l = [(0,0)]
while n:
    n -= 1
    a, b, p = map(int, I().split())
    D.setdefault(b, []).append((a, p))

for b in sorted(D):
    for a, p in D[b]:
        x, y = l[B.bisect(l, (a, -1)) - 1]
        l += (b, max(y + p, l[-1][1])),
        n = max(n, y + p)
print(n)
