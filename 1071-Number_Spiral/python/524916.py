i=int(input())
while i>0:
  y,x=map(int,input().split(' '))
  m=max(x,y)
  a,b=(m,1) if m%2==1 else (1,m)
  print(m**2-abs(a-x)-abs(b-y))
  i-=1