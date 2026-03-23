n,m,k=list((input().split()))
n=int(n) #number of applicants
m=int(m) #number of apartments
k=int(k) #leeway
desired_size=list(input().split())
desired_size=[int(x) for x in desired_size]
apt_size=list(input().split())
apt_size=[int(x) for x in apt_size]
apt_size.sort()
desired_size.sort()
counter=index=0
for i in range(n):
    while index<m:
        if apt_size[index]+k<desired_size[i]:
            index+=1
        elif apt_size[index]-k>desired_size[i]:
            break
        else:
            index+=1
            counter+=1
            break
print(counter)

