n=int(input())
for i in range(n):
    a,b=map(int,input().split())
    if a>b and a%2==0:
        print(a**2-(b-1))
    if a>b and a%2==1:
        print((a-1)**2+b)
    if b>a and b%2==1:
        print(b**2-(a-1))
    if b>a and b%2==0:
        print((b-1)**2+a)
    if a==b:
        print((a**2)-(a-1))
