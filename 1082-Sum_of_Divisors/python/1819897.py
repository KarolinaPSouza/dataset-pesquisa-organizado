import math
def som(x,y):
    return ((y*(y+1))//2-(x*(x+1))//2)

n=int(input())
MOD=pow(10,9)+7
sr=math.floor(math.sqrt(n))
ans=0
x,y=1,n
for i in range(2,sr+1):
    t=n//i
    ans+=y*x
    ans+=x*som(t,y)
    x,y=i,t
if y==sr:
    ans+=sr*(n//sr)
else:
    t=n//sr
    ans+=sr*t
    ans+=x*som(sr,y)
print(ans%MOD)