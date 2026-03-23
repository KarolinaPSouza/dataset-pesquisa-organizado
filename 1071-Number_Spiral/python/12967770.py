t = int(input())

for _ in range(t):
    [y, x] = list(map(int, input().split()))

    m = max(y, x)

    n = m * m

    c = n - m + 1

    if y == x:
        print(c)
    elif y > x:
        if y % 2:
            print(c - (m - x))
        else:
            print(c + (m - x))
    else:
        if x % 2:
            print(c + (m - y))
        else:
            print(c - (m - y))