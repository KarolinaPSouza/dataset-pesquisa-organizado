n, m, k = map(int,input().split())
apl = list(map(int,input().split()))
apt = list(map(int,input().split()))

apl.sort()
apt.sort()

i = 0
j = 0
count = 0
while i < m and j < n:
    if abs(apt[i] - apl[j]) <= k:
        count += 1
        i += 1
        j += 1
    elif apt[i] < apl[j] - k:
        i += 1
    else:
        j += 1  
print(count)