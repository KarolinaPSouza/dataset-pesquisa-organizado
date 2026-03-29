A=map
B=int
C=input
n,x=A(B,C().split())
h=A(B,C().split())
s=list(A(B,C().split()))
d=[0]*(x+1)
i=0
for v in h:
    X=s[i]
    i+=1
    for y in range(x-v,-1,-1):d[y+v]=max(d[y+v],d[y]+X)
print(max(d))