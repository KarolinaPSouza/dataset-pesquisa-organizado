k = int(input())
bn = input().split()
c = {}
for i in bn:
    if i in c:
        c[i] += 1
    else:
        c[i] = 1
print(len(c))          
