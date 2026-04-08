from sys import stdin
raw_input = lambda: stdin.readline().rstrip()
input = lambda: int(raw_input())
I=lambda: list(map(int, raw_input().split()))

def f(lst, k):
 rLst = []
 prev0 = 0
 prev2 = 0
 for w in range(1<<k):
  q = 0
  if w%4==1:
   rLst.append(prev0+lst[0])
   continue
  elif w%4==3:
   rLst.append(prev2+lst[0])
   continue
  elif w%4==2:
   q = prev0+lst[1]
   rLst.append(q)
   prev2 = q
   continue
  for i in range(k):
   if (1<<i)&w:
    q += lst[i]
  rLst.append(q)
  prev0 = q
 rLst.sort()
 cur = rLst[0]
 resLst = []
 i = 0
 for x in rLst:
  if x==cur:
   i += 1
  else:
   resLst.append((cur, i))
   i = 1
   cur = x
 resLst.append((cur, i))
 return resLst


n,x = I()
a = I()

res = 0
if n <= 20:
 lst = f(a,n)
 # print(lst)
 for t in lst:
  q,i = t
  if q==x:
   res = i
   break
else:
 a1 = a[:20]
 a2 = a[20:]
 lst1 = f(a1,20)
 lst2 = f(a2,n-20)
 # print(lst1)
 # print(lst2)
 n1 = len(lst1)
 n2 = len(lst2)
 i2 = n2-1
 for i1 in range(n1):
  y1,j1 = lst1[i1]
  if y1>x:
   break
  # elif y1==x:
   # res += j1
   # break
  else:
   while i2>=0:
    y2,j2 = lst2[i2]
    if y1+y2<x:
     break
    elif y1+y2==x:
     res += (j1*j2)
     break
    else:
     i2 -= 1
 # for i2 in range(n2):
  # y2,j2 = lst2[i2]
  # if y2==x:
   # res += j2
   # break
  # elif y2>x:
   # break
print(res)     