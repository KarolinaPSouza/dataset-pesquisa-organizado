import bisect

n = int(input())
arr = []

for _ in range(n):
    a, b, p  = map(int, input().split())
    arr.append((a, b, p))

arr.sort(key = lambda x:x[1])


def binary_search(projects):
    n = len(projects)
    starts = [projects[i][0] for i in range(n)]
    ends = [projects[i][1] for i in range(n)]
    rewards = [projects[i][2] for i in range(n)]

    dp = [0] * (n+1)

    for i in range(1, n+1):
        s, e, r = starts[i-1], ends[i-1], rewards[i-1]

        j = bisect.bisect_right(ends, s-1)

        dp[i] = max(dp[i-1], dp[j]+r)

    return dp[n]

ans = binary_search(arr)
print(ans)