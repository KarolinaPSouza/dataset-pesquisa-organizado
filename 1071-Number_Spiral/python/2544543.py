import sys
def read(t=int):
 s = sys.stdin.readline()
 return list(map(t,s.strip().split(' ')))

def readint():
 return read()[0]

def go(x,y):
 ring = max(x,y)
 start = (ring-1) ** 2 + 1
 if ring%2 ==0:
  if x==ring:
   return start+y-1
  else:
   # y==ring
   return ring**2-x+1
 else:
  if y==ring:
   return start+x-1
  else:
   return ring**2-y+1


q = readint()
for i in range(q):
 y,x = read()
 print(go(x,y))