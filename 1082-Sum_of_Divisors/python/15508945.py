n=int(input())
m=10**9+7
i=1; s=0

while i<=n:
    v=n//i
    j=n//v
    s=(s+v*(i+j)*(j-i+1)//2)%m
    i=j+1

print(s)