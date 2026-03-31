import bisect
n = int(input());a = [];b = [];
for i in range (0,n):
    x,y = map(int,input().split())
    a.append(x); b.append(y);
a = sorted(a);b = sorted(b)

m = 0;current = 1;i=1;j=0;
al = len(a); bl = len(b);
while(i<al and j<bl):
    if a[i]<b[j]:
        i+=1;current+=1;
        if current>m:
            m = current
    elif a[i]==b[j]:
        i+=1;j+=1;
    else:
        j+=1;current+=-1;
print(m)