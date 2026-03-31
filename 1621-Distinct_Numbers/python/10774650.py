import sys
input = sys.stdin.readline
write = sys.stdout.write

def print(x):
    write(str(x) + '\n')


n = int(input())
l = list(map(int,input().split()))
l.sort()
c = 1
prev = l[0]
for i in range(1,n):
    if l[i]!=prev:
        c+=1
    prev = l[i]
print(c)