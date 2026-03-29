"""
from collections import deque
 matrix= [['#','#','#','#','#','#','#','#'],
['#','.','.','#','.','.','.','#'],
['#','#','#','#','.','#','.','#'],
['#','.','.','#','.','.','.','#'],
['#','#','#','#','#','#','#','#']
]
"""

#[['########'], ['#..#...#'], ['####.#.#'], ['#..#...#'], ['####.#.#']]
#print(matrix)

# your code goes here
from collections import deque
"""
matrix= [
['#','#','#','#','#','#','#','#'],
['#','.','.','#','.','.','.','#'],
['#','#','#','#','.','#','.','#'],
['#','.','.','#','.','.','.','#'],
['#','#','#','#','#','#','#','#']
]
"""

#print(matrix)

def findRooms(matrix):
    row= len(matrix)
    cols= len(matrix[0])
    outcnt=0
    for i in range(row):
        for j in range(cols):
            #if (i, j) not in visiting_set:
            matvalue= matrix[i][j]
            if matvalue==".":
                outcnt+=1
                bfsmatrix(matrix, (i,j))
                #print(matrix[i][j], end="|")
        #print(" ")  
    return outcnt   

def bfsmatrix(matrix, startIndices):
    #initialize queue and Set
    q= deque()


    rows = len(matrix)
    cols= len(matrix[0])
    q.append(startIndices)
    #visiting_set.add(startIndices)
    matrix[startIndices[0]][startIndices[1]]='#'

    # create path for Left--Up--Right--Down
    # for Rows and columns

    # 
    rowi=[-1, 0, 1, 0]
    colj=[0, 1, 0, -1]

    # iterate values from queue
    while q:
        #pop item from queue
        popped= q.popleft()

        # for matrix get current index
        si = popped[0]
        sj= popped[1]

        #get neighbours
        for i in range(4):
            ni= si+ rowi[i]
            nj = sj+ colj[i]
           # value= 
            if ni< rows and nj< cols and ni>=0 and nj>=0 and matrix[ni][nj]!= '#' :# and (ni, nj) not in visiting_set:
            #if Ni<rows and Ni>=0 and Nj< cols and Nj>=0 and grid[Ni][Nj]!="0" and (Ni, Nj) not in visited:
                q.append((ni,nj))
                #visiting_set.add((ni, nj))
                matrix[ni][nj]='#'
            pass

    # get neighbours and iterate through neighbours

    pass

def wrdsplit(word):
    return [char for char in word]

rows, cols = map(int, input().strip().split(' '))
#visiting_set = set()

matrix=[]
for i in range(rows):
 #for j in range(cols):
  lst= wrdsplit(input().strip())
  matrix.append(lst)

#print(matrix)

print(findRooms(matrix))