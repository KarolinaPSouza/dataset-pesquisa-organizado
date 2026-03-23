n,m,k = map(int,input().split())
dsize = list(map(int,input().split()))
asize = list(map(int,input().split()))
dsize.sort()
asize.sort()
count = 0
i,j = 0,0
while(i<n and j<m):
    if (abs(dsize[i] - asize[j]) <= k):
        count+=1
        i+=1
        j+=1
    elif(dsize[i]<asize[j]):
        i+=1
    else:
        j+=1
print(count)
