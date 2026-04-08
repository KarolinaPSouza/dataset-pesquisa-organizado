import sys
from bisect import bisect_left, bisect_right
from collections import Counter

data = list(map(int, sys.stdin.buffer.read().split()))
it = iter(data)
n, target = next(it), next(it)
arr = [next(it) for _ in range(n)]

mid = n // 2
left, right = arr[:mid], arr[mid:]

# enumerate subset sums of left half
left_sums = [0]
for v in left:
    left_sums += [s + v for s in left_sums]

# enumerate subset sums of right half
right_sums = [0]
for v in right:
    right_sums += [s + v for s in right_sums]

# count duplicates of right sums once
cntR = Counter(right_sums)

# combine
ans = 0
for s in left_sums:
    ans += cntR.get(target - s, 0)

print(ans)