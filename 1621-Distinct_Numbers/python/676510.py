n = int(input())
b= [int(x) for x in input().split()]
b.sort(reverse = False)
i = 0
count = 0

while i<(n-1):
    if b[i] == b[i+1]:
        i = i+1
    else:
        count = count+1
        i = i+1

print(count+1)