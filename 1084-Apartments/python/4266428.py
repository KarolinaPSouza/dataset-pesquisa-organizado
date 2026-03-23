diff = list(map(int, input().strip().split(' ')))[2]
applicants = sorted(list(map(int, input().strip().split(' '))))
apartments = sorted(list(map(int, input().strip().split(' '))))

i = 0
j = 0
ans = 0
last_ap = 0
while i < len(applicants) and j < len(apartments):
    if applicants[i] - diff <= apartments[j] <= applicants[i] + diff:
        ans +=1
        j += 1
        i += 1
    else:
        if apartments[j] > applicants[i] + diff:
            i += 1
        else:
            j += 1
print (ans)