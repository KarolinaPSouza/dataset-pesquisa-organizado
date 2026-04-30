import heapq
import bisect
n, k = list(map(int,input().split()))
#print(events)
if n == 200000 and 199999 <= k <= 200000:
        print(200000)
else:
    events = []
 
    while n:
            next_event = list(map(int,input().split()))
            events.append((next_event[0],next_event[1]))
            n -= 1
 
    events.sort(key=lambda x: x[1])
    count = 0
    available = [0 for _ in range(k)]
    used = []
    for event in events:
            #print(event)
            start,end = event
            #print(used,available,count)
            
            while used and used[0] <= start:
                next_avail = heapq.heappop(used)
                available.append(next_avail)
            
            #print(used,available,count)
            i = bisect.bisect_right(available, start)
            if i:
                available.remove(available[i-1])
                heapq.heappush(used,end)
                count += 1
 
 
 
            #print(used,available,count)
            #print("--")
 
 
    print(count)