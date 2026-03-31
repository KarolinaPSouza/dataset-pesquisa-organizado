#CSES  Restaurant Customers
import sys
input = sys.stdin.buffer.readline
read = sys.stdin.buffer.read

n=int(input())
a=[]
d=[]
for i in range(n):
    x,y=(map(int,input().split()))
    a.append(x)
    d.append(y)
a.sort()
d.sort()
i,j=0,0
c=0
z=0
while i<n and j<n:
    if a[i]<d[j]:
        c+=1
        i+=1
    else:
        z=max(c,z)
        c-=1
        j+=1
z=max(c,z)
print(z)


