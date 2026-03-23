def total(n):
    return (n * (n + 1)) // 2


if __name__ == '__main__':
    n = int(input())
    res = 0
    i = 1
    while i <= n:
        largest = n // (n // i)
        res += (n // i) * (total(largest) - total(i - 1))
        i = largest + 1
    print(res % int(1e9+7))