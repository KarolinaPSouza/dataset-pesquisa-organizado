from bisect import bisect_left

def findn(list,num):
    ind = bisect_left(list,num)
    if ind != 0:
        return list[ind -1]
    return 0

n = int(input())
# table = []
# for i in range(n):
#     row = [0]*n
#     table.append(row)
# for i in range(n):
#     table[0][i]=1
#     table[i][0]=1
maximum = 0
projects = []
endset = set()
starts = dict()
for i in range(n):
    y = [int(a) for a in input().split()]
    # for j in range(n):
    #     if y[j]=='*':
    #         table[i][j]=0
    #     elif i == 0 and j!=0:
    #         table[i][j]=table[i][j-1]
    #     elif i!=0 and j==0:
    #         table[i][j]=table[i-1][j]
    #     elif i!=0 and j!=0:
    #         table[i][j]=table[i][j-1]+table[i-1][j]
    if y[1]>maximum:
        maximum = y[1]
    # projects.append(y)
    l =  starts.get(y[1]-1)
    if l==None:
        starts[y[1]-1] = [(y[0],y[2])]
    else:
        # print(list(starts[y[1]-1]).append((y[0],y[2])))
        l = starts[y[1]-1]
        # print(l)
        l.append((y[0],y[2]))
        # print(l)
        starts[y[1]-1] = l
    endset.add(y[1])
# starts = []
# for i in range(maximum):
#     starts.append([])
# for i in projects:
#     starts[i[1]-1].append((i[0],i[2]))
# print(starts)
endlist = list(endset)
endlist.sort()
prev = dict()
prev[endlist[0]]=0
for i in range(len(endlist)-1):
    prev[endlist[i+1]] = endlist[i]
dp = dict()
dp[0]=0
initial = 0

for i in range(len(endlist)):
    dp[endlist[i]-1]=dp[initial]
    for j in starts[endlist[i]-1]:
        dp[endlist[i]-1]=max(dp[endlist[i]-1],j[1]+dp[max(findn(endlist,j[0])-1,0)])
    initial = endlist[i]-1
# print(dp)
print(dp[endlist[-1]-1])

