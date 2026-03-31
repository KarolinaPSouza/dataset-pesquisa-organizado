n=int(input())
x=list(map(int,input().split()))
x.sort()
c=1
ini=x[0]
for i in range(1,n):
    if x[i]==ini:
        continue
    else:
        ini=x[i]
        c+=1
print(c)