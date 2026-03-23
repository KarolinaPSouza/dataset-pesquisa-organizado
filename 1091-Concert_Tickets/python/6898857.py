n, m = map(int, input().split())
h = list(map(int, input().split()))
t = list(map(int, input().split()))

h.sort()
seg = [0] * (n*4)
mark = 0
markval = 0

def gomark(x, l, r):
  global mark, markval
  if l == r:
    mark = x
    markval = h[l]
  else:
    mid = (l+r+1)//2
    if (r-mid+1-seg[x*2+1]) > 0:
      gomark(x*2+1, mid, r)
    elif (mid-l-seg[x*2]) > 0:
      gomark(x*2, l, mid-1)

def go(x, l, r, target):
  global mark, markval
  if l == r:
    if target < h[l]:
      return 0
    if seg[x]==0:
      mark = x
      markval = h[l]
    return 1 - seg[x]
  else:
    mid = (l+r+1)//2
    if h[mid] <= target:
      r1 = (mid-l-seg[x*2])
      r2 = go(x*2+1, mid, r, target)
      if mark == 0 and r2 == 0 and r1 > 0:
        gomark(x*2, l, mid-1)
      return r1+r2
    else:
      return go(x*2, l, mid-1, target)

for ticket in t:
  mark = 0
  go(1, 0, n-1, ticket)
  if mark == 0:
    print(-1)
  else:
    print(markval)
  while mark > 0:
    seg[mark] += 1
    mark //= 2