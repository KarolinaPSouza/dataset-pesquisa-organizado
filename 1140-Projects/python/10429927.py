from bisect import *
n=int(input())
V=[]
fi=[]
en=[]
st=[]
pay=[]
for _ in range(n):
    a,b,p=map(int,input().split())
    V.append((a,b,p))
    fi.append(b)
for i in sorted(range(n),key=lambda k:fi[k]):
    en.append(fi[i])
    st.append(V[i][0])
    pay.append(V[i][2])
dp=[0]*(n+1)
for i in range(n):
    ix=bisect_left(en,st[i])
    dp[i+1]=max(dp[i],dp[ix]+pay[i])
print(dp[-1])