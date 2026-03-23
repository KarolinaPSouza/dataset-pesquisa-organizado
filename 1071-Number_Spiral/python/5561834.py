t = int(input())
for i in range(t):
    x, y = map(int, input().split())
    if x >= y:
        if x & 1:
            print((x - 1) * (x - 1) + y)
        else:
            print(x * x - (y - 1))
    else:
        if y & 1:
            print(y * y - (x - 1))
        else:
            print((y - 1) * (y - 1) + x)