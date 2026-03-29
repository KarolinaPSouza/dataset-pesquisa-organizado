from bisect import bisect_right


def solve():
    n = int(input())
    a = []
    for _ in range(n):
        l, r, v = map(int, input().split())
        a.append((r, l, v))
    a.sort(key=lambda x: x[0])
    dp = []

    for i in range(n):
        x, y = a[i][0], a[i][2]
        idx = bisect_right(dp, (a[i][1], 0))
        if idx > 0:
            y += dp[idx - 1][1]
        if i > 0 and dp[-1][1] > y: 
            x, y = dp[-1]
        dp.append((x, y))

    print(dp[n - 1][1])

if __name__ == "__main__":
    # tc = int(input())
    tc = 1
    for _ in range(tc):
        solve()