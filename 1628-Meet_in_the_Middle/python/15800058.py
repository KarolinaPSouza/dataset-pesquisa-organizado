import sys

input = sys.stdin.readline

n, x = map(int, input().split())
a = list(map(int, input().split()))

mid = n // 2
L = a[:mid]
R = a[mid:]

# Generate subset sums iteratively (no recursion)
lsums = [0]
for v in L:
    lsums += [s + v for s in lsums]

rsums = [0]
for v in R:
    rsums += [s + v for s in rsums]

lsums.sort()
rsums.sort()

# Two-pointer count
i = 0
j = len(rsums) - 1
ans = 0

while i < len(lsums) and j >= 0:
    s = lsums[i] + rsums[j]
    if s == x:
        li = i
        rj = j
        while li < len(lsums) and lsums[li] == lsums[i]:
            li += 1
        while rj >= 0 and rsums[rj] == rsums[j]:
            rj -= 1
        ans += (li - i) * (j - rj)
        i = li
        j = rj
    elif s < x:
        i += 1
    else:
        j -= 1

print(ans)