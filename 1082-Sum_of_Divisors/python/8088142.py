n = int(input())

md = (10**9)+7
s = 0

def ss(l, r):
    return  0 if l>=r else (r*(r+1)//2) - (l*(l+1)//2) 

for e in range(1, int(n**0.5)+1):
    s += ss(e, n//e)%md 
    s += e*(n//e - e + 1)%md


print(s%md)