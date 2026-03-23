n=int(input())
r=0
i=1
while i<=n:
 q=n//i
 j=n//q+1
 r+=q*(j-i)*(i+j-1)//2
 i=j
print(r%(10**9+7))