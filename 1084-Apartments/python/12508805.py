import math

def ipn(): return int(input())
def ipv(): return map(int, input().split(" "))
def ipa(): return list(ipv())

def main():
  t = 1
  # t = ipn()

  for _ in range(t):
    sov()

# ======================== start sov ========================

def sov():
  n,m,k = ipv()
  a,b = sorted(ipa()),sorted(ipa())
  t = 0
  i = j = 0

  while i < n and j < m:
    if a[i] > b[j] + k:
      j += 1
      continue
    if a[i] < b[j] - k:
      i += 1
      continue
    t += 1
    i += 1
    j += 1

  print(t)

# ======================== end sov ========================

main()