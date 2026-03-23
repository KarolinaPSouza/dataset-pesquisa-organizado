n, m, k = map(int, input().split())
desired = list(map(int, input().split()))
avail = list(map(int, input().split()))

desired.sort()
avail.sort()

i = j = total = 0

while i < n and j < m:
    if avail[j] < desired[i] - k:
        j += 1  
    elif avail[j] > desired[i] + k:
        i += 1 
    else:
        total += 1  
        i += 1
        j += 1

print(total)