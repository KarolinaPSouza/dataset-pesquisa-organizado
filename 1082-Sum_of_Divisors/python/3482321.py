def ff(num):

 s = 0
 for i in range(1,int(num**0.5)+1):
  t1 = i * (num // i - i + 1) 
  t2 = (((num // i) * (num // i + 1)) // 2) - ((i * (i + 1)) // 2)
  s += t1 + t2
 return s
s = ff(int(input()))
print(s % (10**9+7))