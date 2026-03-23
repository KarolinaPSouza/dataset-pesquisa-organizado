n = int(input())
res = 0
mod = (10 ** 9) + 7
div = 1
while n // div != 0:
    d = n // div
    rest = n % div
    up = (rest // d) + 1
    res += (d * up * (2 * div + up - 1)) // 2
    res %= mod
    div += up
print(res)