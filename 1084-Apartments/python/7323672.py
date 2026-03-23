from bisect import bisect_right
n,m,k = map(int,input().split())
a = sorted([*map(int,input().split())])
b = sorted([*map(int,input().split())])
ans = 0
j = 0
for i in range(n):
    while b[j] < a[i] - k:
        j += 1
        if j >= m:
            break
    if j >= m:
        break
    if b[j] <= a[i] + k:
        ans += 1
        j += 1
    if j >= m:
        break
print(ans)