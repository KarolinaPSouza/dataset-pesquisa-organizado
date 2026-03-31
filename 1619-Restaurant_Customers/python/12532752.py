customers = int(input())

arrive = []
leave = []

for _ in range(customers):
    a,l = map(int,input().split())
    arrive.append(a)
    leave.append(l)

arrive.append(100000000000)
leave.append(100000000000)

arrive.sort()
leave.sort()


a_index = 0
l_index = 0
occupants = 0
max_occupants = -1
while a_index<customers or l_index<customers:
    if arrive[a_index] < leave[l_index]:
        a_index += 1
        occupants += 1
    else:
        l_index += 1
        occupants -= 1

    max_occupants = max(max_occupants,occupants)



print(max_occupants)

