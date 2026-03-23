mod = 1000000007
def f(a, b):
    return ((b * (b + 1) - a * (a - 1)) // 2) % mod
n = int(input())
d = 1
ans = 0
while d * d <= n:
    ans += d * (n // d)
    ans %= mod
    if d == n // d:
        d += 1
        continue
    x = n // (d + 1) + 1
    y = n // d
    ans += d * f(x, y)
    ans %= mod
    d += 1
print(ans)