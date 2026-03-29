import sys
import bisect

def max_earn(n, projects):
    # projects: list of (start, end, reward)
    # 1) sort by end
    projects.sort(key=lambda x: x[1])
    # build ends[] and—just for convenience—1‑based indexing
    ends   = [0] + [e for (_, e, _) in projects]
    start  = [0] + [s for (s, _, _) in projects]
    reward = [0] + [r for (_, _, r) in projects]

    # dp[i] = best you can do using the first i projects in this end‑sorted order
    dp = [0] * (n + 1)

    for i in range(1, n+1):
        # find the last project j whose end < start[i]
        # bisect_right gives insertion point, so j = that index - 1 in 1‑based
        j = bisect.bisect_right(ends, start[i] - 1) - 1
        # two choices: skip i, or take i + dp[j]
        dp[i] = max(dp[i-1], dp[j] + reward[i])

    return dp[n]

def main():
    data = sys.stdin.read().split()
    it = iter(data)
    n = int(next(it))
    projects = [(int(next(it)), int(next(it)), int(next(it)))
                for _ in range(n)]
    print(max_earn(n, projects))

if __name__ == "__main__":
    main()