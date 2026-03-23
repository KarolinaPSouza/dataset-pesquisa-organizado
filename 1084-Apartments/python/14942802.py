n, m, k = map(int, input().split())
desire = list(map(int, input().split()))
available = list(map(int, input().split()))
count=0
'''for apart in desire:
    for z in available:
        if z-k<apart<z+k:
            count+=1
print(count)'''
desire.sort()
available.sort()

l, r = 0, 0
count = 0

while l < len(desire) and r < len(available):
    if abs(desire[l] - available[r]) <= k:
        count += 1
        l += 1
        r += 1
    elif available[r] < desire[l] - k:
        r += 1
    else:
        l += 1

print(count)