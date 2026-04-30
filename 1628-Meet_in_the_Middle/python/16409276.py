import sys
from bisect import bisect_right, insort
 
def solve():
    # 使用快速讀取
    input_data = sys.stdin.read().split()
    if not input_data: return
    n = int(input_data[0])
    k = int(input_data[1])
    
    # 電影按結束時間排序
    movies = []
    for i in range(n):
        movies.append((int(input_data[2*i+3]), int(input_data[2*i+2])))
    movies.sort()
    
    # 分塊列表優化：將 staff_availability 拆分成多個小 list
    # bucket_size 取 1000 到 2000 之間通常在 Python 表現最好
    bucket_size = 1400 
    buckets = [[0] * k]
    
    ans = 0
    for end, start in movies:
        # 1. 尋找目標桶子 (由後往前找第一個最小值 <= start 的桶子)
        found_bucket = -1
        for i in range(len(buckets) - 1, -1, -1):
            if buckets[i][0] <= start:
                found_bucket = i
                break
        
        if found_bucket != -1:
            target_b = buckets[found_bucket]
            # 2. 在桶子內找到 <= start 的最大值索引
            idx = bisect_right(target_b, start) - 1
            # 3. 移除舊時間並計數
            target_b.pop(idx)
            ans += 1
            
            # 4. 插入新的結束時間
            # 為了省去複雜的 rebalance，直接插入對應位置
            # 如果桶子空了就移除；如果太滿了就拆分
            if not target_b:
                buckets.pop(found_bucket)
            
            # 插入到哪裡？為了維護桶子間的順序，我們找第一個最大值 >= end 的桶子
            inserted = False
            for i in range(len(buckets)):
                if not buckets[i] or end <= buckets[i][-1]:
                    insort(buckets[i], end)
                    if len(buckets[i]) > bucket_size * 2:
                        # 拆分桶子
                        mid = len(buckets[i]) // 2
                        buckets.insert(i + 1, buckets[i][mid:])
                        buckets[i] = buckets[i][:mid]
                    inserted = True
                    break
            
            if not inserted:
                if not buckets:
                    buckets.append([end])
                else:
                    insort(buckets[-1], end)
                    if len(buckets[-1]) > bucket_size * 2:
                        mid = len(buckets[-1]) // 2
                        buckets.append(buckets[-1][mid:])
                        buckets[-1] = buckets[-2][:mid] # 這裡修正了分割邏輯
 
    sys.stdout.write(str(ans) + '\n')
 
solve()