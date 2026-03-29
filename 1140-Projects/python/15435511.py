import sys
import bisect

n = int(input())
projects = [tuple(map(int, input().split())) for _ in range(n)]

# Sort by ending day
projects.sort(key=lambda x: x[1])
ends = [proj[1] for proj in projects]

dp = [0] * n

for i in range(n):
    a, b, p = projects[i]
    # Find the last project that ends before a
    idx = bisect.bisect_right(ends, a - 1) - 1
    if idx >= 0:
        p += dp[idx]
    dp[i] = max(dp[i-1] if i > 0 else 0, p)

print(dp[-1])