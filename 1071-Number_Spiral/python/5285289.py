def main(): 

    y, x = map(int, input().split())

    if y > x:
        ma = y*y
        mid = ma - y + 1
        if y % 2 == 0:
            return mid + y - x
        return mid - y + x
    if y == x:
        return x*x-x + 1
    ma = x*x
    mid = ma - x + 1
    if x % 2 == 0:
        return mid - x + y
    return mid + x - y

for i in range(int(input())):
    print(main())