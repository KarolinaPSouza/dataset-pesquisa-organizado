a=int(input())
for i in range(a):
    c,d=map(int,input().split())
    if c%2==0 and d<=c:
        print(c**2-d+1)
    elif d%2==1 and d>=c:
        print(d**2-c+1)
    elif c%2==1 and c>=d:
        print((c-1)**2+d)
    elif d%2==0 and d>=c:
        print((d-1)**2+c)
    else:
        print(1)