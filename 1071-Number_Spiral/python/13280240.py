for iq in range(int(input())):
    x,y=map(int,input().split())
    mini=min(x,y)
    ans=-1
    if y<=x:
        if x%2==0:
            ans=(x**2)-(y-1)
        else:
            ans=(((x-1)**2)+1)+(y-1)
    else:
        if y%2==1:
            ans=(y**2)-(x-1)
        else:
            ans=(((y-1)**2)+1)+(x-1)
    print(ans)














