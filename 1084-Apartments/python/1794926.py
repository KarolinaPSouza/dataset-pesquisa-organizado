a,b,c=map(int,input().split())
d=iter(sorted(map(int,input().split())))
e=iter(sorted(map(int,input().split())))
n=0
n2=1
n3=1

k=next(d)
kk=next(e)
while True:
    if k-c <= kk <= k+c:
        n+=1
        if n2 != a and n3 != b :
            k=next(d)
            kk=next(e)
            n2+=1
            n3+=1
        else:break
    else:
        if kk < k-c:
            if n3 != b :
                kk=next(e)
                n3+=1
            else:break
        elif kk> k+c:
            if n2 != a:
                k=next(d)
                n2+=1
            else:break
print(n)
