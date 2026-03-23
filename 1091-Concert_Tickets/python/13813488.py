import sys
sys.setrecursionlimit(2099999999)

def sch(arr, v, l, r):
    if l > r:
        return -1

    m = (l + r) // 2
    if arr[m] < v:
        rp = sch(arr, v, m + 1, r)
        if rp == -1:
            return m
        return rp
    if arr[m] == v:
        if r == m or arr[m + 1] != v:
            return m
        else:
            return sch(arr, v, m + 1, r)
    return sch(arr, v, l, m - 1)

def get_p(i):
    if i == -1 or es[i] == i:
        return i
    es[i] = get_p(es[i])
    return es[i]


n, m = map(int, input().split())
hs = list(map(int, input().split()))
ts = list(map(int, input().split()))
es = list(range(n))

hs.sort()

for q in ts:
    i = sch(hs, q, 0, n - 1)

    v = get_p(i)
    if v == -1:
        print(-1)
    else:
        es[v] = get_p(v - 1)
        print(hs[v])
