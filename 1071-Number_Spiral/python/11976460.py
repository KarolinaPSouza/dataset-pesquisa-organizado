for _ in range(int(input())):
    x, y = map(int, input().split())
    if x > y:
        if x % 2 == 0:
            print(x*x - y + 1)
        else:
            print((x-1)*(x-1) + y)
    else:
        if y % 2 == 1:
            print(y*y - x + 1)
        else:
            print((y-1)*(y-1) + x)