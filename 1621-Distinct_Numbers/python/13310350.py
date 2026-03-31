import sys

data=list(map(int,sys.stdin.buffer.read().split()))
n=data[0]
x=data[1:]
x.sort()
dis=1
for i in range(n-1):
    if x[i]!=x[i+1]:
        dis+=1
print(dis)