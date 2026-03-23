N=int(input())
cont=0
s=0
num=0
M=10**9+7
for i in range (1,int(N**0.5)+1):
    cont=(N//i)*i
    s+=cont
    s=s%M

    num=((N//i)-((int(N**0.5))))
    d=((int(N**0.5)+1)+(N//i))
    if d%2==0:
        d//=2
    else:
        num=num//2


    s+=(num*d)%M
    s=s%M

print(s)