q=n=int(input())
i=0
s=n*n
while i<q:i+=1;d=q-n//-~i;v=n%i*d+i*d*~-d//2;q-=d;s-=v+n%i
s+=q-i&v
print(s%(10**9+7))