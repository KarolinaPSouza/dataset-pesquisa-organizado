import bisect 

n = int(input())

projects = []
for _ in range(n):

    s, e, r = map(int, input().split())
    projects.append((s, e, r))

projects.sort(key=lambda x:x[1])
end_time = [p[1] for p in projects]

dp = [0] * (n + 1)
for i in range(1, n + 1):

    start, end, reward = projects[i - 1]

    j = bisect.bisect_right(end_time, start - 1)
    dp[i] = max(dp[i - 1], dp[j] + reward)


print(dp[n])