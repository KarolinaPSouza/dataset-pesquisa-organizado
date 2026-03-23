for i in range(int(input())):
    y,x = list(map(int,input().split()))
    m = max(x,y)
    curr = m**2
    maxpar = m%2
    if maxpar == 0:
        if m == x:
            curr -= (m-1)
            curr -= (m-y)
        else:
            curr -= (x-1)
    else:
        if m == x:
            curr -= (y-1)
        else:
            curr -= (m-1)
            curr -= (m-x)
    print(curr)