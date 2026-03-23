from math import isqrt
def A024916(n): return (-(s:=isqrt(n))**2*(s+1) + sum((q:=n//k)*((k<<1)+q+1) for k in range(1, s+1)))>>1
print(A024916(int(input()))%1000000007)