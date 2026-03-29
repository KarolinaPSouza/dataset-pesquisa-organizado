import sys
import bisect


it = map(int, sys.stdin.buffer.read().split())


def solve() -> str:
    n = next(it)
    intervals = sorted(
        ((next(it), next(it), next(it)) for _ in range(n)),
        key=lambda x: x[1],
    )

    if n == 0:
        return "0"

    ends = [b for _, b, _ in intervals]
    dp = [0] * n
    dp[0] = intervals[0][2]

    for i in range(1, n):
        a, _, w = intervals[i]
        best = dp[i - 1]
        j = bisect.bisect_left(ends, a) - 1
        if j >= 0:
            best = max(best, dp[j] + w)
        else:
            best = max(best, w)

        dp[i] = best

    return str(dp[-1])


sys.stdout.write(solve())
# out = [solve() for _ in range(next(it))]
# sys.stdout.write("\n".join(out))