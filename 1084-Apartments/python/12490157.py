def apartments(n,m,k):
    desired_size=list(map(int,input().split()))
    apartment_size=list(map(int,input().split()))
    apartment_size.sort()
    desired_size.sort()
    i,j=0,0
    count=0
    while i<n and j<m:
        upper=desired_size[i]+k
        lower=desired_size[i]-k
        if apartment_size[j]>=lower and apartment_size[j]<=upper:
            count+=1
            i+=1
            j+=1
        elif apartment_size[j]<lower:
            j+=1
        else:
            i+=1
    return count
n,m,k=map(int,input().split())
print(apartments(n,m,k))