def add(l, r):
 return (l+r+1)*(r-l)//2
n = int(input())
ans = 0
for i in range(1, int(n**0.5+1)):
 l = n//(i+1)
 r = n//i
 ans += i*(n//i)
 if(i >= r):
  break
 ans += i*add(l, r)
print(ans%1000000007)