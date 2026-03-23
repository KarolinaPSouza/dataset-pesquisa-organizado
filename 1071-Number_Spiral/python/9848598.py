t = int(input())
for i in range(t):
    x, y = list(map(int, input().split()))
    if x > y:
        if x % 2 == 0:
            print(x ** 2 - (y - 1))
        else:
            print((x - 1) ** 2 + y)
    elif x < y:
        if y % 2 == 0:
            print((y - 1) ** 2 + x)
        else:
            print(y ** 2 - (x - 1))
    else:
        print(x**2 - x + 1)