n, m, k = [int(i) for i in input().split()]
c, ap = sorted([int(i) for i in input().split()]), sorted([int(i) for i in input().split()])
ans = 0
# print(c)
# print(ap)
pre = 0
i, j = 0, 0
while i < n and j < m:
    if abs(c[i] - ap[j]) <= k:
        i += 1
        j += 1
        ans += 1
    else:
        if c[i] < ap[j]:
            i += 1
        else:
            j += 1
print(ans)