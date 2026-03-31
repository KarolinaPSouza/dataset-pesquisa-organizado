n=int(input())
ar1=[]
ar2=[]
for i in range(n):
    a,b=map(int,input().split())
    ar1.append(a)
    ar2.append(b)
ar1.sort()
ar2.sort()
i1=0
i2=0
s=0
maxi=0
while i1!=n:
    if ar1[i1]<ar2[i2]:
        s+=1
        if s>maxi:
            maxi=s
        i1+=1
    elif ar1[i1]>ar2[i2]:
        s-=1
        if s>maxi:
            maxi=s
        i2+=1
    else:
        i1+=1
        i2+=1
print(maxi)