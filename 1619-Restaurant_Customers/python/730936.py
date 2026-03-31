n=int(input())
a=[]
b=[]
for i in range(n):
    c,d=map(int,input().split())
    a.append(c)
    b.append(d)

a.sort()
b.sort()

count=0
ans=0
x=0
y=0

while(x<n and y<n):
    if(a[x]<b[y]):
        count=count+1
        x=x+1
    else:
        count=count-1
        y=y+1
    if(ans<count):
        ans=count

print(ans)