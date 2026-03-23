n,m,k=map(int,input().split())
ds=list(map(int,input().split()))
apm=(list(map(int,input().split())))
ds=sorted(ds)
apm=sorted(apm)
ds=sorted(ds)
i=0
j=0
ans=0
while i<n and j<m:
    if apm[j]<ds[i]-k:
        j+=1
    elif apm[j]>ds[i]+k:
        i+=1
    else:
        ans+=1
        i+=1
        j+=1
print(ans)

