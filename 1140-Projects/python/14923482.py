import bisect

def solve():
    n = int(input())
    projects = []
    for _ in range(n):
        a, b, c = map(int, input().split())
        projects.append((a, b, c))
    projects.sort(key=lambda x: x[1])
    dp = [0] *(n+1)
    ends = [p[1] for p in projects]
    for i in range(1, n+1):
        curr = projects[i-1]
        a,b, c = curr
        dp[i] = dp[i-1]
        j = bisect.bisect_right(ends, a-1)
        dp[i] = max(dp[i], c + dp[j])
    print(dp[n])
solve()