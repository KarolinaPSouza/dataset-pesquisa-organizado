def range_sum(l,r): 
  return (r*(r+1))//2 - (l*(l-1))//2
def solve():
  MOD = 10**9 + 7
  n = int(input())
  ans = 0
  l = 1
  while l<=n:
    q = n//l
    r = n//q
    sumD = range_sum(l,r)
    ans += (sumD*(q)%MOD)%MOD
    l = r+1
  print(ans%MOD)

solve()