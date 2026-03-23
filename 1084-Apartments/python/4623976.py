n, m, k = map(int, input().split())
applicants = [int(i) for i in input().split()]
apartments = [int(i) for i in input().split()]

applicants.sort()
apartments.sort()

res = 0
lb = 0
for i in range(n):
    for j in range(lb,m):
        if applicants[i]-k > apartments[j]:
            lb = j
            continue
        if applicants[i]+k < apartments[j]:
            break
        if applicants[i]+k >= apartments[j] and applicants[i]-k <= apartments[j]:
            res += 1
            lb = j+1
            break
print(res)
