n = int(input()) 
arr = list(map(int,input().split()))
arr.sort()  

counter = 1
prev = arr[0]
for num in arr:
    if num != prev: 
        counter += 1 
        prev = num
print(counter)