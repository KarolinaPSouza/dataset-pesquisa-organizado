import bisect

n = int(input())
projs = []
for _ in range(n):
    projs.append([int(x) for x in input().split()])

dp = [0] * (n+1)

projs.sort(key= lambda x: x[1])

end_times = [p[1] for p in projs]

for i in range(1, n+1):
    sd, ed, reward = projs[i-1]

    compat_i = bisect.bisect_right(end_times, sd-1, hi=i-1)

    max_p = dp[compat_i]

    dp[i] = max(dp[i-1], max_p + reward)

print(dp[-1])

