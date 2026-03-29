import sys
from bisect import bisect_right
def max_earnings(n, projects):
    projects.sort(key=lambda x: x[1])
    end_days = [b for _, b, _ in projects]
    dp = [0] * (n + 1) 
    for i in range(1, n + 1):
        a, b, p = projects[i - 1]
        idx = bisect_right(end_days, a - 1) 
        dp[i] = max(dp[i - 1], p + dp[idx])
    return dp[n]
n = int(sys.stdin.readline().strip())
projects = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
print(max_earnings(n, projects))