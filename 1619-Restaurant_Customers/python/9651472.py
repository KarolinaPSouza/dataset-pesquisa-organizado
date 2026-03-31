import sys 
input = sys.stdin.readline
print = sys.stdout.write 

# 3
# 5 8
# 2 4
# 3 9
times_arrival = []
times_end = []
n = int(input())
for i in range(n):
    start, end = map(int, input().split())
    times_arrival.append(start)
    times_end.append(end)

times_end.sort()
times_arrival.sort() 

count = i = j = max = 0
while i < n and j < n:
    if times_arrival[i] < times_end[j]: 
        count += 1 
        i+= 1 
        if count > max : 
            max = count 
    elif times_arrival[i] > times_end[j]: 
        count -= 1 
        j+=1 
    pass

print(str(max)+"\n")