# i messed up in last two as the search part was O(m+n) which still was slow, so last option was O(max(m,n)), sort part didnt add to time much
nmk = input().split()
n_array = [int(i) for i in input().split()]
m_array = [int(i) for i in input().split()]
n_array.sort();m_array.sort()
p1,p2 = 0,0
alloc = 0
k = int(nmk[2])
while True:
 if(p2 == len(m_array) or p1 == len(n_array)):
  break
 if(abs(m_array[p2]-n_array[p1]) <= k):
  alloc += 1
  p1 += 1
  p2 += 1
 elif(m_array[p2] > n_array[p1]):
  p1 += 1
 else:
  p2 += 1


print(alloc)
