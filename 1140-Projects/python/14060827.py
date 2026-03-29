import bisect

n = int(input())
projects = []
for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((a, b, p))


projects.sort(key=lambda x: x[1])
ends = [proj[1] for proj in projects]

dp = [0] * (n + 1)

for i in range(1, n + 1):
    a, b, p = projects[i - 1]

    idx = bisect.bisect_left(ends, a) - 1
    dp[i] = max(dp[i - 1], dp[idx + 1] + p)

print(dp[n])