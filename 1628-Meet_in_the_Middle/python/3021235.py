n,x = map(int,input().split())
arr = [int(x) for x in input().split()]

countDic = {}
def dfs(index,total,shouldReturn,limit):
    if index==limit:
        if shouldReturn:
            if x-total in countDic:
                return countDic[x-total]
            return 0
        if total not in countDic:
            countDic[total] = 0
        countDic[total]+=1
        return 0
    return dfs(index+1,total+arr[index],shouldReturn,limit) + dfs(index+1,total,shouldReturn,limit)

dfs(len(arr)//2,0,False,len(arr))
print(dfs(0,0,True,len(arr)//2))