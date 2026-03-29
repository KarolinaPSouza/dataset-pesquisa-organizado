n,x=[int(x) for x in input().split()]
weight=[int(x) for x in input().split()]
value=[int(x) for x in input().split()]


prev=[0 for j in range(x+1)]
next=[0 for j in range(x+1)]

for i in range(n+1):
    price=weight[i-1]
    profit=value[i-1]
    for s in range(x+1):
        next[s]=prev[s]
        if price<=s:
            next[s]=max(next[s],prev[s-price]+profit)
    prev,next=next,prev

print(next[x])