def sumd(N):
    p = 10**9+7
    B = int(N**0.5)
    d0 = N//(B+1)+1
    S = sum(N//d*d for d in range(1,d0)) % p
    for k in range(1,B+1):
        D1=N//(k+1)+1
        D2=N//k
        S+= k*(D1+D2)*(D2-D1+1)//2 % p
    return S % p
#print([sumd(N) for N in range(1,10)])
N = int(input())
print(sumd(N))
