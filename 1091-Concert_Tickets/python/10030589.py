# 1 <= n, m <= 2 * 10^5
# 1 <= h_i, t_i <= 10^9
import sys
sys.setrecursionlimit(200000)


from bisect import *

def get_root(x):
    if x == -1 or roots[x] == x:
        return x
    roots[x] = get_root(roots[x])
    return roots[x]

n, m = (int(x) for x in input().split())
h = list(int(x) for x in input().split()) # tickets
h = sorted(h)
t = list(int(x) for x in input().split()) # queries

roots = list(range(n))
for query in t:
    ticket_position = bisect(h, query) - 1
    ticket = get_root(ticket_position)
    if ticket >= 0:
        print(h[ticket])
        roots[ticket] = ticket - 1
    else:
        print(-1)