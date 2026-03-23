t=int(input())

for i in range(t):
    #print("i",i)
    x_y=list(map(int,input().split()))

    x=x_y[0]-1
    y=x_y[1]-1
    r=max(x_y)
    #print("x,y,r",x,y,r)
    if r%2==0:
        if x==y:
            print((r)**2-r+1)
        elif x>y:
            print((r)**2-y)
        else:
            print((r)**2+x-y-r+1)
    else:
        if x==y:
            print((r)**2-r+1)
        elif x>y:
            print((r)**2-x+y-r+1)
        else:
            print((r)**2-x)