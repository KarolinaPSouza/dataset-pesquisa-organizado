t=int(input())
for _ in range (t):
 y,x=map(int,input().split())
 if y>=x:
  r=(y&1)*((y-1)*(y-1) + x) +((y-1)&1)*(y*y -x +1)
 else:
  r=((x-1)&1)*((x-1)*(x-1) + y)+((x)&1)*(x*x -y +1)
 print(r)