from bisect import bisect_right

n, m = map(int, input().split())
h = [*map(int, input().split())]
t = [*map(int, input().split())]

p = [*range(n + 1)]

h.sort()

for ti in t:
    i = bisect_right(h, ti)
    if i == len(h) or h[i] != ti:
        i -= 1
    while p[i] != i:
        p[i], i = p[p[i]], p[i]
    if i == len(h):
        print(-1)
    else:
        print(h[i])
        p[i] -= 1