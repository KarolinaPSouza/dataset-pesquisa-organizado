n = int(input())

for _ in range(n):
    x, y = [int(a) for a in input().split(" ")]
    m = max(x, y)
    start = (m - 1) * (m - 1)
    if m % 2 == 0:
        if (y < x):
            print((m * m) - (y - 1))
        else:
            print(start + x)
    else:
        if ( y < x):
            print(start + y)
        else:
            print((m*m) - (x -1))