t=int(input())
for i in range(t):
    y,x=map(int,input().split())
    if(y>x):
        s=(y-1)*(y-1)
        if(y%2!=0):
            d=x
        else:
            d=2*y-x
        print(s+d)
    else:
        s=(x-1)*(x-1)
        if(x%2==0):
            d=y
        else:
            d=2*x-y
        print(d+s)