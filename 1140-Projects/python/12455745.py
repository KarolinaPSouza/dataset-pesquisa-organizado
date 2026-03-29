from bisect import *
I = input
n = int(I())
D = {}
l = [0]
while n:
    n -= 1
    a, b, p = map(int, I().split())
    D[b*1e6 + n] = a, p

S = sorted(D)

for b in S:
    a, p = D[b]
    l += max(l[-1], l[bisect_left(S, a*1e6)] + p),

print(l[-1])
