n,m,k = map(int,input().split())
l = list(map(int,input().split()))
l.sort()
b =list(map(int,input().split()))
b.sort()
ans = 0
i = 0
j = 0
while i < n and j < m:
    if abs(l[i]-b[j]) <= k:
        ans += 1
        i += 1
        j += 1
    elif l[i] < b[j]:
        i += 1
    else:
        j += 1
print(ans)