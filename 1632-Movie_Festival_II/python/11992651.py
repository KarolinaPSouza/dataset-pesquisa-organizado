import bisect
a = input().split()
n, k = int(a[0]), int(a[1])
movies = []
for i in range(n):
    a = input().split()
    movies.append([int(a[0]), int(a[1])])
 
def second(x):
    return x[1]
 
movies.sort(key=second)
 
times = []
pointers = list(range(n))
ppl = 0
watched = 0
 
def find_greatest_less(x):
    global times
    most = -1
    for i, thing in enumerate(times):
        if thing <= x:
            most = i
        else:
            break
    return most
 
def delete(pos):
    global times, pointers
    if pointers[pos] == pos:
        pointers[pos] -= 1
        return pointers[pos]
    else:
        if pointers[pos] < 0:
            return -2
        else:
            a = delete(pointers[pos])
            pointers[pos] = a
            return a
 
for movie in movies:
    if ppl != 0:
        pos = bisect.bisect(times, movie[0])
        if pos != 0:
            thing = delete(pos - 1)
            if thing != -2:
                ppl -= 1
    if ppl == k:
        continue
    ppl += 1
    watched += 1
    times.append(movie[1])
 
print(watched)