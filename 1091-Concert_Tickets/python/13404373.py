import sys, bisect

# ---------- read input ----------
buf   = sys.stdin.buffer.read().split()
n, m   = map(int, buf[:2])
price  = sorted(map(int, buf[2:2 + n]))        # ticket prices     (sorted)
query  = map(int, buf[2 + n:])                 # customers' bids   (original order)

# ---------- DSU helpers ----------
parent = list(range(n))                        # parent[i] == i  ⇒ ticket i still unsold

def find(i: int) -> int:
    """return right-most unsold index ≤ i, or –1 if none"""
    while i != -1 and parent[i] != i:
        i_parent = parent[i]
        if i_parent == -1:                     # reached sentinel
            return -1
        parent[i] = parent[i_parent]           # path compression (safe)
        i = parent[i]
    return i                                   # either –1 or root

def erase(i: int) -> None:
    """mark ticket i as sold"""
    parent[i] = find(i - 1) if i else -1       # next candidate to the left

# ---------- process customers ----------
out = []
for bid in query:
    j = bisect.bisect_right(price, bid) - 1    # right-most price ≤ bid
    j = find(j)                                # skip sold ones
    if j == -1:
        out.append("-1")
    else:
        out.append(str(price[j]))
        erase(j)

sys.stdout.write("\n".join(out))