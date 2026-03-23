n=int(input())
MOD=10**9+7
result=0
i=1
while i<=n:
    q=n//i
    j=n//q
    result=(result + q*(i+j)*(j-i+1)//2)%MOD
    i=j+1
print(result)