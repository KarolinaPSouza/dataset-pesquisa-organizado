I = lambda: [int(i) for i in input().split()]
import io, os, sys
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

#n = int(input())
#l1 = list(map(int,input().split()))
#n,x = map(int,input().split())
#s = input()
mod =  1000000007
import bisect


n,m,k = map(int,input().split())
l1 = list(map(int,input().split()))
l2 = list(map(int,input().split()))
i=0
j=0
c=0
l1.sort()
l2.sort()
while(i<n and j<m):
    if l1[i]<l2[j]:
        if l2[j]-l1[i]<=k:
            c+=1
            i+=1
            j+=1
        else:
            i+=1
    else:
        if l1[i]-l2[j]<=k:
            c+=1
            i+=1
            j+=1
        else:
            j+=1
print(c)


















