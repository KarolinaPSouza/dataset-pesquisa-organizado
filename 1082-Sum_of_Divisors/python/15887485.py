from typing import List
from collections import Counter
import math

MODULUS = 10**9 + 7

def is_prime(n: int) -> bool:
 """Deterministic Miller-Rabin for 64-bit integers."""
 if n < 2:
  return False
 # small primes quick check
 small_primes = [2,3,5,7,11,13,17,19,23,29,31]
 for p in small_primes:
  if n % p == 0:
   return n == p
 # write n-1 as d * 2^s
 d = n - 1
 s = 0
 while d % 2 == 0:
  d //= 2
  s += 1
 # bases good for 64-bit
 for a in (2, 325, 9375, 28178, 450775, 9780504, 1795265022):
  if a % n == 0:
   continue
  x = pow(a, d, n)
  if x == 1 or x == n - 1:
   continue
  composite = True
  for _ in range(s - 1):
   x = (x * x) % n
   if x == n - 1:
    composite = False
    break
  if composite:
   return False
 return True


def factor(n: int) -> List[int]:
 if n <= 1:
  return []
 if is_prime(n):
  return [n]
 ret = []
 i = 2
 while i * i <= n:
  while n % i == 0:
   ret.append(i)
   n //= i
  # check 2 then odds
  i += 1 if i == 2 else 2
 if n > 1:
  ret.append(n)
 return ret

def sum_sigma_upto(n: int) -> int:
    ans = 0
    l = 1
    while l <= n:
        q = n // l
        r = n // q
        cnt = r - l + 1
        s = (l + r) * cnt // 2        # sum of integers from l to r
        ans = (ans+ q * s) % MODULUS
        l = r + 1
    return ans

print(sum_sigma_upto(int(input())))