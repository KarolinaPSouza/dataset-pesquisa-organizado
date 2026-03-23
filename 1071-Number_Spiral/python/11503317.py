for _ in range(int(input())):
    y,x=map(int,input().split())

    if x>=y:
        if x%2==0:
            print(pow(x-1,2)+y)
        else:
            print(pow(x,2)-y+1)
    elif y>x:
        if y%2!=0:
            print(pow(y-1,2)+x)
        else:
            print(pow(y,2)-x+1)