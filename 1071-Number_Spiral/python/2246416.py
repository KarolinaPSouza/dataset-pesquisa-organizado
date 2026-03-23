for i in range(0,int(input())):
    y,x=map(int,input().split())
    if x==y :
        print(1+x*(x-1))
    else:
        c=max(y,x)
        d=(c-1)**2
        e=c**2+1
        if y>x and y%2==1:
            #for j in range(0,x):
            d+=x
            print(d)
        elif y>x and y%2!=1:
            #for j in range(0,x):
            e-=x
            print(e)
        elif x>y and x%2==1:
            #for j in range(0,y):
            e-=y
            print(e)
        else:
            #for j in range(0,y):
            d+=y
            print(d)

