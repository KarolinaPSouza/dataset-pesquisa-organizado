import sys
input = lambda: sys.stdin.readline().strip()
inp = lambda: list(map(int, input().split()))
from collections import defaultdict, deque,Counter
import heapq
MOD = 10**9 + 7
INF = 10**18
 
 
n,m = inp()
a = inp()
sz = 1<<(n-1).bit_length()
 
def join(ind1,ind2):
    ma1,l1,r1,su1 = ls1[ind1],ls2[ind1],ls3[ind1],ls4[ind1]
    ma2,l2,r2,su2 = ls1[ind2],ls2[ind2],ls3[ind2],ls4[ind2]
    return (max(ma1,ma2,r1+l2), max(l1,su1+l2),max(r2,su2+r1),su1+su2)
 
def join_l(left,ind2):
    ma1,l1,r1,su1 = left
    ma2,l2,r2,su2 = ls1[ind2],ls2[ind2],ls3[ind2],ls4[ind2]
    return (max(ma1,ma2,r1+l2), max(l1,su1+l2),max(r2,su2+r1),su1+su2)
 
def join_r(ind1,right):
    ma1,l1,r1,su1 = ls1[ind1],ls2[ind1],ls3[ind1],ls4[ind1]
    ma2,l2,r2,su2 = right
    return (max(ma1,ma2,r1+l2), max(l1,su1+l2),max(r2,su2+r1),su1+su2)
 
 
ls1 = [0]*(2*sz)
ls2 = [0]*(2*sz)
ls3 = [0]*(2*sz)
ls4 = [0]*(2*sz)
 
def upd(i,v):
    i+=sz
    ls1[i],ls2[i],ls3[i],ls4[i] = (max(0,v),max(0,v),max(v,0),v)
    i>>=1
    while i:
        ls1[i],ls2[i],ls3[i],ls4[i] = join(i<<1,i<<1|1)
        i>>=1
 
def query(u,v):
    u+=sz
    v+=sz
    left = (0,0,0,0)
    right = (0,0,0,0)
    while u<=v:
        if u&1:
            left = join_l(left,u)
            u+=1
        if not v&1:
            right = join_r(v,right)
            v-=1
        u>>=1
        v>>=1
    return max(left[0],right[0],left[2]+right[1])
 
 
 
for i,v in enumerate(a):
    j = i+sz
    ls1[j],ls2[j],ls3[j],ls4[j] = (max(0,v),max(0,v),max(v,0),v)
 
for i in range(1,sz)[::-1]:
    ls1[i],ls2[i],ls3[i],ls4[i] = join(i<<1,i<<1|1)
 
ans = []
 
for _ in range(m):
    k,x = inp()
    k-=1
    upd(k,x)
    ans.append(ls1[1])
 
print("\n".join(map(str,ans)))