import bisect

n = int(input())
jobs = []
for i in range(n):
    jobs.append([int(x) for x in input().split()])
jobs.sort(key=lambda x: x[1])
end = []
for job in jobs:
    end.append(job[1])

money = [0 for _ in range(n+1)]

for i in range(1,n+1):
    j = bisect.bisect_right(end, jobs[i-1][0]-1)
    money[i] = max(jobs[i-1][2] + money[j], money[i-1])

print(money[n])