N,K=map(int,input().split())
lista=list(map(int,input().split()))
strony=list(map(int,input().split()))

dp=[0 for _ in range(K+1)]
for x in range(N):
    waga=lista[x]
    cennosc=strony[x]
    for z in range(K,0,-1):
        if z-waga>=0:
            dp[z]=max(dp[z],dp[z-waga]+cennosc)

print(dp[K])