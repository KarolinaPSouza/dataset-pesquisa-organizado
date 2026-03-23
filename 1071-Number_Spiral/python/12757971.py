t = int(input())
for _ in range(t):
    y, x = map(int, input().split())
    n = max(y, x)
    if n % 2 == 0:
        if y == n:
            print(n * n - x + 1)
        else:
            print((n - 1) * (n - 1) + y)
    else:
        if x == n:
            print(n * n - y + 1)
        else:
            print((n - 1) * (n - 1) + x)