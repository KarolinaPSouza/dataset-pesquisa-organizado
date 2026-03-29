from bisect import bisect_right
m, d = [], []
for _ in range(int(input())):
    n, a, p = map(int, input().split(' '))
    m.append((a, n, p))
m.sort(key=lambda x: x[0])
for i in range(len(m)):
    x, y = m[i][0], m[i][2]
    t = bisect_right(d, (m[i][1], 0))
    if t > 0:
        y += d[t - 1][1]
    if i > 0 and d[-1][1] > y:
        x, y = d[-1]
    d.append((x, y))
print(d[len(m) - 1][1])