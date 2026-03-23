for _ in range(int(input())):
    x, y = map(int, input().split())
    if x==y:
        print(x*x-(x-1))
    elif x>y:
        least = (x-1)**2
        if x%2:
            print(least+y)
        else:
            print(x*x-y+1)
    else:
        least = (y-1)**2
        if y%2:
            print(y*y-x+1)
        else:
            print(least+x)