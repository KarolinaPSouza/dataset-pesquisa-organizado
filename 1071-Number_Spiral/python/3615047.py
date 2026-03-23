for y in range(int(input())):
    a,b=map(int,input().split())
    maxx=max(a,b)
    t=(maxx-1)**2
    if t%2==0:
        t=t+b+(maxx-a)
    else:
        t=t+maxx-b+a
    print(t)