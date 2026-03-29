# PyPy3 solution - Weighted interval scheduling (projects)
import sys
import bisect

def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    if not data:
        return
    it = iter(data)
    n = next(it)

    projects = []
    for _ in range(n):
        a = next(it); b = next(it); p = next(it)
        projects.append((a, b, p))

    # sort by end time
    projects.sort(key=lambda x: x[1])
    ends = [proj[1] for proj in projects]

    # dp[i] = max reward using first i projects (i from 0..n)
    dp = [0] * (n + 1)

    for i in range(1, n + 1):
        a, b, p = projects[i - 1]
        # find number of projects that end < a
        idx = bisect.bisect_left(ends, a)  # idx in [0..n]
        # option1: skip this project -> dp[i-1]
        # option2: take it -> dp[idx] + p
        take = dp[idx] + p
        dp[i] = dp[i - 1] if dp[i - 1] > take else take

    print(dp[n])

if __name__ == "__main__":
    main()