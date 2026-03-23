n=int(input())

adj=[[] for _ in range(n)]

for i in range(n-1):

    a,b=map(int,input().split())

    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

stack=[]

order=[]

stack.append((0,-1))

while stack:
    node,par=stack.pop()
    order.append((node,par))

    for x in adj[node] :
        if x!=par:
            stack.append((x,node))
dp=[0]*n
ans=0
for node,par in reversed(order):


    m1=0
    m2=0


    for x in adj[node]:

            if x!=par:

                if dp[x]>=m1:
                    m2=m1
                    m1=dp[x]
                elif dp[x]>m2:
                    m2=dp[x]

    dp[node]=1+m1
    ans=max(ans,m1+m2)

print(ans)                    
