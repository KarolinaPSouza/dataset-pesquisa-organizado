def main():

    n,x = map(int,input().split())
    arr = list(map(int,input().split()))

    if sum(arr) < x:
        print(0)
        return 

    arr.sort()

    arr1 = arr[:n//2]
    arr2 = arr[n//2:]

    dic = {}

    ans = [0]

    def getnext(index, nums, accu,flag):

        if accu > x:  return 
        if index==len(nums):
            if flag:
                if accu not in dic:  dic[accu] = 0
                dic[accu] += 1
            else:
                if x-accu in dic:  ans[0] += dic[x-accu]
            return 
        getnext(index+1, nums, accu+nums[index], flag)
        getnext(index+1, nums, accu, flag)  





    getnext(0,arr1,0,True)
    getnext(0,arr2,0,False)






    print(ans[0])

main()