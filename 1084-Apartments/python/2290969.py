n,m,k = map(int,input().split())
ais = list(map(int,input().split()))
bis = list(map(int,input().split()))

ais.sort()
bis.sort()

allocated = 0
i=j=0
while i<n and j < m:
    if ais[i]+k>=bis[j] and ais[i]-k <= bis[j] :
        allocated+=1
        j+=1
        i+=1
    elif bis[j]>ais[i]:
        i+=1
    elif bis[j]<ais[i]:
        j+=1
print(allocated)