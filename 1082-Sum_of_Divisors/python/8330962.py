# https://cses.fi/problemset/task/1082

from math import isqrt

MOD = 10 ** 9 + 7
n = int(input())

# OEIS: sum of n rounded down to the nearest multiple of k, for all k = 1..n
def solve(n):
    s = isqrt(n)

    ans = -s ** 2 * (s + 1)
    for k in range(1, s + 1):
        q = n // k
        ans += q * (k * 2 + q + 1)

    return ans * pow(2, -1, MOD) % MOD

print(solve(n))