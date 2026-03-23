for _ in range(int(input())):
    y,x=map(int,input().split())
    n=max(x,y)
    if n%2==0:
        if x>=y:
            print((n-1)**2+y)
        else:
            print((n)**2+1-x)
    else:
        if y>=x:
            print((n-1)**2+x)
        else:
            print((n)**2+1-y)