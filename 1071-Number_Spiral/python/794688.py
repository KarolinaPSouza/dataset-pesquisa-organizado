for _ in range(int(input())):
    y,x=map(int,input().split())
    if y>x:
        if y%2==0:
            print(y*y-x+1)
        else:
            print((y-1)*(y-1)+x)
    elif x>y:
        if x%2==0:
            print((x-1)*(x-1)+y)
        else:
            print(x*x-y+1)
    else:
        if x>1:
            print(x*x-(x-1))
        else:
            print(1)



