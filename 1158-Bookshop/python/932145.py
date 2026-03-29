y=input
z=int
b=map
d=list
e=range
x=z(y().split()[1])
h=d(b(z,y().split()))
s=d(b(z,y().split()))
c=[0]*(x+1)
for i,v in enumerate(h):
    i=s[i]
    for j in e(x-v,-1,-1):
        c[j+v]=max(c[j+v],c[j]+i)
print(max(c))