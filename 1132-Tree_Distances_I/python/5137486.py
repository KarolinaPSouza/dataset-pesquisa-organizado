import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

n = int(input())

adj = [[] for i in range(n)]

for i in range(n-1):


    a, b = map(int,input().split())
    a-=1
    b-=1
    adj[a].append(b)
    adj[b].append(a)
st = []
newst = []

maxlevel = -1
maxnode = -1


def bfs():
    global maxlevel, maxnode, st
    while(st):
        node, parent, level = st.pop()
        if(maxlevel<level):
            maxlevel = level
            maxnode = node
        for child in adj[node]:
            if child == parent: continue
            st.append((child, node, level+1))

ans = [0 for i in range(n)]

def bfs1():
    global maxlevel, maxnode, st
    while(st):
        node, parent, level = st.pop()
        ans[node] = max(level, ans[node])
        for child in adj[node]:
            if child == parent: continue
            st.append((child, node, level+1))

st.append((0,-1, 0))
bfs()
mx1 = maxnode
maxlevel = 0
st.append((maxnode, -1, 0))
bfs()
mx2 = maxnode
st.append((mx1, -1, 0))
bfs1()
st.append((mx2, -1, 0))
bfs1()
print(*ans)