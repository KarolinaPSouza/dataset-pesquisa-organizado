from collections import deque
def MakeFile(s : str) :
    import sys
    sys.stdin = open(f'{s}.in', 'r')
    sys.stdout = open(f'{s}.out', 'w')
n=int(input())

l=[];ll=[]
for _ in range(n):
    a,b=map(int,input().split())
    l.append(a) 
    ll.append(b)

l.sort()
l=deque(l)
ll.sort()
ll=deque(ll)
cnt=0;mx=0
while ll and l:
    if l[0]<ll[0]:
        cnt+=1
        mx=max(mx,cnt)
        l.popleft()
    elif l[0]>ll[0]:
        cnt-=1
        ll.popleft()
    else:
        l.popleft()
        ll.popleft()
print(mx)
