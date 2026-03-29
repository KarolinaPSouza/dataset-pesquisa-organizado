import sys
import bisect
input = sys.stdin.readline

n = int(input())

v = []
for _ in range(n):
    a, b, p = map(int, input().split())
    v.append((a, b, p))

# Sort by end time
v.sort(key=lambda x: x[1])

# ends array for binary search
ends = [b for a, b, p in v]

dp = [0] * (n + 1)  # dp[0] = 0

for i in range(1, n + 1):
    a, b, p = v[i - 1]
    # find largest j < i such that ends[j-1] < a
    j = bisect.bisect_right(ends, a - 1, 0, i - 1)
    dp[i] = max(dp[i - 1], dp[j] + p)

print(dp[n])
# end