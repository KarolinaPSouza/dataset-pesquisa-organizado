from collections import deque

n=int(input())
op=[]
cl=[]

for i in range (n):
    o,c=map(int,input().split())
    op.append(o)
    cl.append(c)

op.sort()
cl.sort()
op=deque(op)
cl=deque(cl)

count=0
maxcount=0
while (len(op)):
    #print(op,cl)
    o,c=op[0],cl[0]
    if o<c:
        count+=1
        if count>maxcount:
            maxcount=count
        op.popleft()
    else:
        count-=1
        cl.popleft()
    #print(o,c,count,maxcount)

print(maxcount)