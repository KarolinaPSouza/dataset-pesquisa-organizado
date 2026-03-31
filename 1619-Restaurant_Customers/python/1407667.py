from itertools import chain

n = int(input())

temp = [[int(x) for x in input().split()] for _ in range(n)]
times = sorted(chain.from_iterable(temp))
# Sort times in ascending order of arrival
SortByArrival = sorted(p[0] for p in temp)

customers = 0
maxCustomers = 0

i = len(SortByArrival)
check = False
for x in times:
    if i:
        if x==SortByArrival[-i]:
            customers += 1
            i-=1
            check = True
            continue
    if check:
        if customers > maxCustomers:
            maxCustomers = customers
            check = False
    customers -= 1

print(maxCustomers)

"""
customers = [0]
 i = len(SortByArrival)
for x in times:
    if i:
        if x==SortByArrival[-i]:
            customers[-1] += 1
            i-=1
            continue
    customers.append(customers[-1]-1)
 print(max(customers))
        """