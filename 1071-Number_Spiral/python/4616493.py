test = int(input())

for i in range(test):
 #row, col = map(int, input().split)
 row, col = [int(z) for z in input().split()]

 num = (max(row, col))**2 - (max(row, col)) + 1
 if max(row, col)%2: num+= col-row
 else: num+= row-col

 print(num)


# for i in range(test):
#  strList = input().split()
#  row = int(strList[0])
#  col = int(strList[1])

#  num = (max(row, col) - 1)**2
#  if num%2:
#   if row>col: num+= 2*max(row, col) - min(row, col)
#   else: num+= min(row, col)
#  else:
#   if col>row: num+= 2*max(row, col) - min(row, col)
#   else: num+= min(row, col)

#  print(num)