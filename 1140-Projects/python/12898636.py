from bisect import bisect_right

n = int(input())
pr = [tuple(map(int, input().split())) for _ in range(n)]
pr.sort(key=lambda t: t[1])

ends = [job[1] for job in pr]
dp = [0] * n

for i in range(n):
    start, end, profit = pr[i]
    idx = bisect_right(ends, start - 1) - 1
    include = profit
    if idx != -1:
        include += dp[idx]
    dp[i] = max(dp[i - 1] if i > 0 else 0, include)

print(dp[-1])