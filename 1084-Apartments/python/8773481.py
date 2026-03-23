n, m, k = map(int, input().split())

parr = list(map(int, input().split()))
arr = list(map(int, input().split()))
parr.sort()
arr.sort()
r = 0
j = 0
i = 0
while i < n and j < m:
    x = (parr[i] - arr[j])
    if abs(x) <= k:
        r += 1
        j += 1
        i += 1
    elif x > k:
        j += 1
    elif x < -k:
        i += 1
print(r)