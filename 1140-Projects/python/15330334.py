import bisect

n = int(input())
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())
    projects.append((a, b, p))

# sort by end time
projects.sort(key=lambda x: x[1])

ends = [p[1] for p in projects]
dp = [0] * (n + 1)

for i in range(1, n + 1):
    a, b, p = projects[i - 1]

    # find last project that ends before 'a'
    j = bisect.bisect_right(ends, a - 1)

    # option 1: skip the project
    op1 = dp[i - 1]

    # option 2: take the project
    op2 = dp[j] + p

    dp[i] = max(op1, op2)

print(dp[n])