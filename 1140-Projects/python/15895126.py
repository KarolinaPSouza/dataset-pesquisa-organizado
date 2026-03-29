import bisect

n = int(input())

tasks = []

for _ in range(n):
    list1 = list(map(int, input().split()))
    tasks.append(list1)

tasks.sort(key = lambda x: x[1])

dp = [0] *(n+1)

end_time = [t[1] for t in tasks]

for i in range(1, n+1):
    start, end, points = tasks[i-1]
    idx = bisect.bisect_right(end_time, start-1)

    dp[i] = max(dp[i-1], points+dp[idx])

print(dp[-1])