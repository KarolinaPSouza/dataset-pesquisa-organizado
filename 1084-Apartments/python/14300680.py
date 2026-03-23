n, m, k = map(int, input().split())
a=list(map(int,input().split()))
b=[int(x) for x in input().split()]

a.sort()
b.sort()
ans,i,j=0,0,0

while i<n and j<m:
    if b[j]>=a[i]-k and b[j]<=a[i]+k:
        i+=1
        j+=1
        ans+=1
    elif a[i]<b[j]:
        i+=1
    else:
        j+=1
print(ans)


