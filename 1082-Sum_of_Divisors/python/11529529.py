def solve(n):
    ans = 0
    d = 1
    while d <= n:
        q = n // d
        dd = n // q + 1
        c = (dd - 1) * dd // 2 - (d - 1) * d // 2
        ans += c * q
        d = dd
    return ans % 1000000007

if __name__ == "__main__":
    n = int(input())
    print(solve(n))