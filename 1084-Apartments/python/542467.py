n, m, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort()
i, j = 0, 0
ans = 0
while i < n and j < m:
    if abs(a[i]-b[j]) <= k:
        ans += 1
        i += 1
        j += 1
        continue
    if a[i] > b[j]:
        j += 1
    else:
        i += 1
print(ans)