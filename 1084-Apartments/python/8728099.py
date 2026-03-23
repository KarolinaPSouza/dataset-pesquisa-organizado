def inpu():
    return map(int,input().split())
n,m,k=inpu()
nl=list(inpu())
ml=list(inpu())
nl.sort()
ml.sort()

i,j=0,0
ct=0
while i<n and j<m:
    if nl[i]-ml[j]>k:
        j+=1
    elif nl[i]-ml[j]<-k:
        i+=1
    else:
        ct+=1
        i+=1
        j+=1
print(ct)