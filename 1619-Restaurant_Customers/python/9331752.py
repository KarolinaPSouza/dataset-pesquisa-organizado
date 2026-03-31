n = int(input())

start_times = []
end_times = []
for i in range(n):
    x,y = [int(i) for i in input().split()]
    start_times.append(x)
    end_times.append(y)

start_times.sort()
end_times.sort()

max_cust = 0
cust = 0

while len(start_times) and len(end_times):
    if not len(start_times):
        start_times.pop()
        cust += 1
        max_cust = max(cust, max_cust)
    elif not len(end_times):
        print(max_cust)
        exit()
    else:
        end = end_times[-1]
        start = start_times[-1]
        if end > start:
            end_times.pop()
            cust += 1
            max_cust = max(max_cust, cust)
        else:
            start_times.pop()
            cust -= 1

print(max_cust)