n , m , k = [int(i) for i in input().split()]
a = sorted([int(i) for i in input().split()])
b = sorted([int(i) for i in input().split()])
p1 , p2 = 0 , 0
output = 0
while p2 < m and p1 < n:
    if a[p1]-k > b[p2]:
        p2 += 1
    elif b[p2]-k <= a[p1] <= b[p2]+k:
        output += 1
        p1 += 1
        p2 += 1
    else:
        p1 += 1
print(output)