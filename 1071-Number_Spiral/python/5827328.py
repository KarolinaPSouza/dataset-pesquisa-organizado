t=int(input())
for i in range(t):   
    y,x=map(int,input().split())
    if x>y:
        k=x**2-x+1
        if x%2==0:
            print(k-abs(x-y))
        else:
            print(k+abs(x-y))
    else:
        k=y**2-y+1
        if y%2==0:
            print(k+abs(x-y))
        else:
            print(k-abs(x-y))