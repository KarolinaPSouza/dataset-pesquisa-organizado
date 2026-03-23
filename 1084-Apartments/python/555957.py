n,m,k=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
r=0
ap=0
bp=0
a.sort()
b.sort()
while True:
    if ap>=n or bp>=m:
        break
    if (a[ap]-k) <= b[bp] <= (a[ap]+k):
        r+=1
        ap+=1
        bp+=1
    else:
        if a[ap] > b[bp]:
            bp+=1
        else:
            ap+=1
print(r)
