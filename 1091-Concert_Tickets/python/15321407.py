import sys
import bisect

data = sys.stdin.buffer.read().split()
it = iter(data)
n = int(next(it))
m = int(next(it))

h = [int(next(it)) for _ in range(n)]
t = [int(next(it)) for _ in range(m)]

h.sort()

# Build unique prices and counts
U = []
cnt = []
for x in h:
    if not U or U[-1] != x:
        U.append(x)
        cnt.append(1)
    else:
        cnt[-1] += 1

k = len(U)

# parent[i] = representative index for i (or -1 if none)
parent = list(range(k))

def find(x):
    """Iterative find with path compression.
       returns representative index or -1."""
    if x < 0:
        return -1
    # find root
    root = x
    while True:
        pr = parent[root]
        if pr == root:
            break
        if pr == -1:
            root = -1
            break
        root = pr
    # path compress
    cur = x
    while cur != -1 and parent[cur] != cur:
        nxt = parent[cur]
        parent[cur] = root
        cur = nxt
    return root

out_lines = []
for want in t:
    i = bisect.bisect_right(U, want) - 1
    if i < 0:
        out_lines.append("-1")
        continue
    rep = find(i)
    if rep == -1 or cnt[rep] == 0:
        out_lines.append("-1")
    else:
        out_lines.append(str(U[rep]))
        cnt[rep] -= 1
        if cnt[rep] == 0:
            # union this slot with rep-1 (next available to the left)
            parent[rep] = find(rep - 1)

sys.stdout.write("\n".join(out_lines))