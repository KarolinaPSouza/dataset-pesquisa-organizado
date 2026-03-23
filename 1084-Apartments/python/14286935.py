#klu2300080335
n,m,k=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
a.sort()
b.sort()
i,j=0,0
ans=0
while i<n and j<m:
    if a[i]-k<=b[j]<=a[i]+k:
        ans+=1
        i+=1 
        j+=1
    elif b[j]<a[i]-k:
        j+=1 
    else:
        i+=1
print(ans)