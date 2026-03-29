from bisect import bisect_left

n = int(input())
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((a, b, p))

projects.sort(key=lambda x: x[1])

idx = [0]
dp = [0]

for a, b, p in projects:
    x = bisect_left(idx, a) - 1
    tmp = dp[x] + p

    if idx[-1] == b and dp[-1] < tmp:
        dp[-1] = tmp
    elif tmp > dp[-1]:
        idx.append(b)
        dp.append(tmp)

print(dp[-1])