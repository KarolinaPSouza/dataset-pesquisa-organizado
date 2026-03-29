import sys
import bisect

input = sys.stdin.readline

n = int(input())
projects = [tuple(map(int, input().split())) for _ in range(n)]

# Sort by end time
projects.sort(key=lambda x: x[1])

# Extract end times for binary search
end_times = [p[1] for p in projects]

dp = [0] * (n + 1)

for i in range(1, n + 1):
    a, b, p = projects[i-1]
    # Find rightmost project that ends before a
    idx = bisect.bisect_left(end_times, a) - 1
    if idx >= 0:
        dp[i] = max(dp[i-1], dp[idx + 1] + p)
    else:
        dp[i] = max(dp[i-1], p)

print(dp[n])