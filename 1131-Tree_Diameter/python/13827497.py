n=int(input())

adj=[[] for _ in range(n)]
for _ in range(n-1):

    a,b=map(int,input().split())
    a-=1
    b-=1

    adj[a].append(b)
    adj[b].append(a)


stack=[(0,-1)]

order=[]
while stack:

    node,par=stack.pop()

    for x in adj[node]:
        if x!=par:
            stack.append((x,node))
    order.append((node,par))

depth=[0]*n
ans=-1
for node,par in order[::-1]:

    m1=0
    m2=0
    for x in adj[node]:
        if node==par:
            pass
        elif depth[x]>m1:
            m2=m1
            m1=depth[x]

        elif depth[x]>m2:
            m2=depth[x]


    ans=max(ans,m1+m2)
    depth[node]=m1+1
print(ans)