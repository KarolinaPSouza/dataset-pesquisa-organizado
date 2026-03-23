MOD = 10**9 + 7

def sum_sigma(n: int) -> int:
    res = 0
    d = 1
    while d <= n:
        q = n // d
        r = n // q
        # soma dos inteiros de d até r
        cnt = r - d + 1
        sum_d = (cnt * (d + r) // 2) % MOD
        res = (res + (q % MOD) * sum_d) % MOD
        d = r + 1
    return res

if __name__ == "__main__":
    n = int(input().strip())
    print(sum_sigma(n))