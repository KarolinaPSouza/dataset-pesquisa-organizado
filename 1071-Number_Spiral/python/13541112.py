# t=int(input())
# for jcsn in range(t):
    # n=int(input())
    # a,b=map(int,input().split())
    # s=input()
    # l=list(map(int,input().split()))
n=int(input())
# l=list(map(int,input().split()))
# s=input()
for i in range(n):
    x,y=map(int,input().split())
    if x==y==1:
        print(1)
    elif y<=x:
        if x%2==0:
            print(x**2-y+1)
        else:
            print((x-1)**2+y)
    else:
        top=(y**2)-(y-1)
        if y%2==0:

            print(top-(y-x))
        else:
            print(top+(y-x))