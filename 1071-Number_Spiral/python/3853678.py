t = int(input())

for aaa in range(t):
 y,x = map(int,input().split())
 count = 0

 if(x>y):
  if(x%2 != 0):
   count = x**2
   count = count - y + 1
  else:
   count = (x-1)**2
   count = count + y

 else:
  if(y%2 == 0):
   count = y**2
   count = count - x + 1
  else:
   count = (y-1)**2
   count = count + x

 print(count)