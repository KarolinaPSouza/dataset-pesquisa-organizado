n,m,k = map(int,input().split())

clients = list(map(int,input().split()))
sizes = list(map(int,input().split()))

clients.sort()
sizes.sort()

c=0
s=0
sol=0

while c<len(clients):
    while s<len(sizes) and sizes[s]<=clients[c]+k:
        if abs(sizes[s]-clients[c])<=k:
            sol+=1
            s+=1
            break
        s+=1
    c+=1

print(sol)