import sys
import bisect

input = sys.stdin.readline

n = int(input())
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((b, a, p))

# Sort by ending day
projects.sort()

ends = [proj[0] for proj in projects]

dp = [0] * (n + 1)

for i in range(1, n + 1):
    end_i, start_i, reward_i = projects[i - 1]

    # find rightmost project that ends < start_i
    j = bisect.bisect_left(ends, start_i)  # j is number of valid projects

    dp[i] = max(dp[i - 1], dp[j] + reward_i)

print(dp[n])