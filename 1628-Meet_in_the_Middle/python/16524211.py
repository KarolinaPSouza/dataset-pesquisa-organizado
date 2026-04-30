import bisect,sys
 
n,k = list(map(int,sys.stdin.readline().split()))
 
movies=[]
for i in range(n):
    movies.append(list(map(int,sys.stdin.readline().split())))
 
movies.sort(key=lambda x:x[1])
 
endtimes = []
 
db = 0
switched = 0
solved = False
if n == k:
    print(n)
else:
    for i,movie in enumerate(movies):
        if len(endtimes) == 0:
            endtimes.append(movie[1])
            db+=1
        else:
            if movie[0] >= endtimes[0]:
                ind = bisect.bisect_left(endtimes,movie[0])
                if endtimes[min(max(ind-1,0)+1,len(endtimes)-1)] != movie[0]:
                    endtimes.pop(max(ind-1,0))
                else:
                    endtimes.pop(min(max(ind-1,0)+1,len(endtimes)-1))
                endtimes.append(movie[1])
                db += 1
                switched += 1
            elif len(endtimes)<k:
                endtimes.append(movie[1])
                db+=1
        if switched + k >= n:
            print(n-i+db-1)
            solved = True
            break
                
    if not solved:
        print(db)