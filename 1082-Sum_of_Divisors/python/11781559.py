M=10**9+7
T=pow(2,-1,M)
def f(s,e):return ((((e-s+1)%M)*((s+e)%M)%M)*T%M)
n=int(input())
t,a=0,1
while a<=n:b=n//a;c=n//b;t=(t+b*f(a,c))%M;a=c+1
print(t)