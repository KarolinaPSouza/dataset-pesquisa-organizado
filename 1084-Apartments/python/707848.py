import sys
import math
from  collections import defaultdict

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

def solve(test):
 n, m, k = map(int, input().split())
 p = list(map(int, input().split()))
 a = list(map(int, input().split()))
 p.sort()
 a.sort()
 i, j = 0, 0
 ans = 0
 while i < n and j < m:
  if a[j] - k <= p[i] <= a[j] + k:
   ans += 1
   i += 1
   j += 1
  elif p[i] > a[j]:
   j += 1
  elif p[i] < a[j]:
   i += 1
 print(ans)


if __name__ == "__main__":
 test_cases = 1
 for t in range(1, test_cases + 1):
  solve(t)