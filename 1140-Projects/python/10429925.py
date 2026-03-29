from bisect import *
n=int(input())
V=[]
fi=[]
en=[0]*n
st=[0]*n
pay=[0]*n
for _ in range(n):
    a,b,p=map(int,input().split())
    V.append((a,b,p))
    fi.append(b)
j=0
for i in sorted(range(n),key=lambda k:fi[k]):
    en[j]=fi[i]
    st[j]=V[i][0]
    pay[j]=V[i][2]
    j+=1
dp=[0]*(n+1)
for i in range(n):
    ix=bisect_left(en,st[i])
    dp[i+1]=max(dp[i],dp[ix]+pay[i])
    #print(i,st[i],en[i],ix,dp)
print(dp[-1])