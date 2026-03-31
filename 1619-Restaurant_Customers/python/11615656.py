d = {}
for _ in range(int(input())):
    a, b = map(int, input().split())
    if a not in d:
        d[a] = 1
    elif a in d:
        d[a] += 1
    if b+1 in d:
        d[b+1] -= 1
    else:
        d[b+1] = -1

maxi = 0
s = 0
for i in sorted(d.keys()):
    s += d[i]
    maxi = max(maxi, s)
print(maxi)
