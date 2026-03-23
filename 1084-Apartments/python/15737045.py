import sys
n,m,k=map(int,sys.stdin.readline().split())
apply=list(map(int,sys.stdin.readline().split()))
size=list(map(int,sys.stdin.readline().split()))
apply.sort()
size.sort()
i=j=0
count=0
while i<n and j<m:
    if abs(apply[i]-size[j])<=k:
        count+=1
        i+=1
        j+=1
    elif size[j]<apply[i]-k:
        j+=1
    else:
        i+=1
print(count)


#10 10 0
#37 62 56 69 34 46 10 86 16 49
#50 95 47 43 9 62 83 71 71 7