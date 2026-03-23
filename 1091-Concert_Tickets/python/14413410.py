import sys
import bisect


it = map(int, sys.stdin.buffer.read().split())
out = []

n, m = next(it), next(it)
h = sorted(next(it) for _ in range(n))
parent = list(range(n + 1))

for _ in range(m):
    ti = next(it)
    i = bisect.bisect(h, ti)
    while i != parent[i]:
        parent[i], i = parent[parent[i]], parent[i]

    if i > 0:
        out.append(str(h[i - 1]))
        parent[i] -= 1
    else:
        out.append("-1")

sys.stdout.write("\n".join(out))
