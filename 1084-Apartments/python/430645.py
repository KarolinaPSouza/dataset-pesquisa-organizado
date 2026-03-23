n, m, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort()

result = 0

aidx, bidx = 0, 0
while aidx < n and bidx < m:
    cur_diff = abs(a[aidx]-b[bidx])
    if cur_diff <= k:
        result += 1
        aidx += 1
        bidx += 1
    elif a[aidx] < b[bidx]:
        aidx += 1
    elif a[aidx] > b[bidx]:
        bidx += 1
print(result)