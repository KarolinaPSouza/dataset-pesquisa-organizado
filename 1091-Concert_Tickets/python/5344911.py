import bisect as bs
n, m = map(int, input().split())
h = list(map(int, input().split()))
t = list(map(int, input().split()))
h.sort()
L, daban = [i-1 for i in range(n)], [0]*n
for x in t:
    i = bs.bisect_right(h, x) - 1
    csk = [i]
    while i >= 0 and daban[i] == 1:
        i = L[i]
        csk.append(i)
    if i >= 0:
        print(h[i])
        daban[i] = 1
        for x in csk:
            L[x] = i-1
    else:
        print(-1)
        for x in csk:
            L[x] = -1