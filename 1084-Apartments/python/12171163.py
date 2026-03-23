n,m,k = list(map(int,input().split()))
a = list(map(int,input().split()))
b = list(map(int,input().split()))
a.sort()
b.sort()

c = 0
ai = 0
bi = 0 
while ai<n and bi<m:
    if(abs(b[bi]-a[ai])<=k):
        ai += 1
        bi += 1
        c += 1

    else:
        if(b[bi]>a[ai]):
            ai += 1
        else:
            bi += 1


print(c)     
