import sys

x = list(map(int,input().split()))
ppl = list(map(int,input().split()))
apt = list(map(int,input().split()))

ppl.sort()
apt.sort()

i = 0
j = 0
count = 0

while i < len(ppl) and j<len(apt):
    if ppl[i] >= apt[j]-x[2] and ppl[i] <= apt[j]+x[2]:
        count+=1
        i+=1
        j+=1
    elif ppl[i] < apt[j]-x[2]:
        i+=1
    else:
        j+=1

print(count)