# https://discuss.codechef.com/t/sum-of-divisors-of-all-numbers-less-than-n-in-less-than-o-n-time/65944/29
# https://discuss.codechef.com/t/sum-of-divisors-of-all-numbers-less-than-n-in-less-than-o-n-time/65944/32

#https://codeforces.com/blog/entry/72945?#comment-572053

n = int(input())
ans = 0

MOD = 10**9 + 7 
l = 1
while l <= n:
  r = n//(n//l)
  term = ((r-l+1) * (l+r)) // 2
  add  = (term * (n//l)) % MOD
  ans=(ans+add) % MOD
  l = r + 1
print(ans)