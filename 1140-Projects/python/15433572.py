import bisect

n = int(input())
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((a, b, p))

# 1. Sort by ending day
projects.sort(key=lambda x: x[1])

# Extract only end times for binary search
end_times = [b for (_, b, _) in projects]

# DP array: dp[i] = best reward using first i projects
dp = [0] * (n + 1)

for i in range(1, n + 1):
    a, b, p = projects[i - 1]

    # Option 1: skip project i
    skip = dp[i - 1]

    # Option 2: take project i → find last project ending < a
    idx = bisect.bisect_right(end_times, a - 1)
    take = dp[idx] + p

    dp[i] = max(skip, take)

print(dp[n])