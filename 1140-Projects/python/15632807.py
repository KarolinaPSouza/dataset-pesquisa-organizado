import bisect

n = int(input())
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((b, a, p))  # (end, start, profit)

# 1) sort by end day
projects.sort()

# 2) dp[i] = max profit using projects[0..i]
dp = [0] * n

# store end days for binary search
ends = [projects[i][0] for i in range(n)]

for i in range(n):
    end, start, profit = projects[i]

    # option 1: take this project
    val = profit

    # find last project with end < start
    j = bisect.bisect_left(ends, start) - 1
    if j >= 0:
        val += dp[j]

    # option 2: skip this project
    if i > 0:
        dp[i] = max(dp[i - 1], val)
    else:
        dp[i] = val

print(dp[-1])