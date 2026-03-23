#23mce006
n = int(input())
maxnode = -1
maxlevel = -1
adj = [[] for i in range(n)]
for i in range(n-1):
    a, b = map(int, input().split())
    adj[a-1].append(b-1)
    adj [b-1].append(a-1)

def bfs(node):
    global maxlevel, maxnode
    st = [(node, -1, 0)]
    while(st):
        nod, par, lev = st.pop()
        if(lev>maxlevel):
            maxlevel = lev
            maxnode = nod
        for child in adj[nod]:
            if(child == par): continue
            st.append((child, nod, lev+1))
bfs (0)
maxlevel = -1
bfs(maxnode)
print(maxlevel)