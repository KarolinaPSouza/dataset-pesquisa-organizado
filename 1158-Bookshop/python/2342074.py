f=lambda:map(int,input().split())
k,C=f()
d=[0]*(C+1)
for w,v in zip(f(),f()): 
 for c in range(C,w-1,-1): 
  d[c]=max(d[c],d[c-w]+v)
print(d[C])