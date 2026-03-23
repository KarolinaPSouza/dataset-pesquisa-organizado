import sys
from bisect import bisect_right
n, m = map(int, input().split())
h = sorted(list(map(int, input().split())))
t = list(map(int, input().split()))

sys.setrecursionlimit(200000)
endpoints = list(range(n))

def get_endpoints(x):
    if x == -1 or x == endpoints[x]:
        return x
    endpoints[x] = get_endpoints(endpoints[x])
    return endpoints[x]

for i in t:
    pos = get_endpoints(bisect_right(h, i) - 1)
    if pos == -1:
        print(-1)
    else:
        print(h[pos])
        endpoints[pos] = pos - 1