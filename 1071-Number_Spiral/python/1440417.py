import sys

coordinates = [None] * int(sys.stdin.readline())
for x in range(len(coordinates)):
 coordinates[x] = list(map(int,sys.stdin.readline().split()))
for x in coordinates:
 if x[0] == max(x): #y coordinate
  if (x[0] % 2 == 0):
   print(x[0]**2-x[1]+1)
  else:
   print((x[0]-1)**2+x[1])
 else: #x coordinate
  if (x[1] % 2 == 1):
   print(x[1]**2-x[0]+1)
  else:
   print((x[1]-1)**2+x[0])