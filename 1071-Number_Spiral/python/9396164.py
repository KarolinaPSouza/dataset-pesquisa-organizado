for j in range(int(input())):
  x,y=map(int,input().split())
  if x>=y:
    print(((x//2)**2)*4+x%2+(y-1)*pow(-1,x+1))
  if y>x:
    print((y-int(y%2==0))**2+int(y%2==0)+(x-1)*pow(-1,y))