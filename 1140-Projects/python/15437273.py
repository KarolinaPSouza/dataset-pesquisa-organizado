import sys
import bisect

input = sys.stdin.readline

n = int(input())
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((a, b, p))

# Sort by ending time
projects.sort(key=lambda x: x[1])

# Create array of ending times for binary search
ends = [proj[1] for proj in projects]

# dp[i] = best value using first i projects (1-indexed)
dp = [0] * (n + 1)

for i in range(1, n + 1):
    a, b, p = projects[i-1]

    # find rightmost project ending < a
    j = bisect.bisect_left(ends, a)  # j projects end before a
    # j is index => dp[j] is best up to that

    dp[i] = max(dp[i-1], dp[j] + p)

print(dp[n])