k = int(input())
c = 1
while k >= c:
    l = list(map(int, input().split()))
    y = l[0]
    x = l[1]
    if x == y:
        n = 1+x*(x-1)
    else:
        if x > y:
            if x % 2 == 0:
                n = 1+x*(x-1)-(x-y)
            else:
                n = 1+x*(x-1)+x-y
        else:
            if y % 2 == 0:
                n = 1+y*(y-1)+y-x
            else:
                n = 1+y*(y-1)-(y-x)
    c += 1
    print(n)