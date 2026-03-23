T=int(input())

while T>0:
  T-=1
  a,b=[int(i) for i in input().split()]
  x=max(a,b)
  diag=1+x*(x-1)
  # print(diag)
  if x%2==0:
    if x==a:
      print(diag+(x-b))
    else:
      print(diag-(x-a))
  else:
    if x==a:
      print(diag-(x-b))
    else:
      print(diag+(x-a))