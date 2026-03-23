n, m, k = map(int, input().split())
nuh = list(map(int, input().split()))
dih = list(map(int, input().split()))
nuh.sort()
dih.sort()
i = 0         
j = 0    
c = 0         
while i<n and j<m:
    if dih[j]<nuh[i]-k:
        j+=1
    elif dih[j]>nuh[i]+k:
        i+=1
    else:
        c+=1
        i+=1
        j+=1
print(c)