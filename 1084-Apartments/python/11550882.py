a=input()
appartmentwants=input()
appartments=input()
#things=a.split(" ")
n, m,  k = a.split()
appartmentwantslist=appartmentwants.split(" ")
appartmentslist=appartments.split(" ")
intappartmentslist=[]
intappartmentwantslist=[]
for i in appartmentslist:
    intappartmentslist.append(int(i))
for i in appartmentwantslist:
    intappartmentwantslist.append(int(i))
apprange=int(k)
numpeople=int(n)
numapparments=int(m)

######################################## main algrithom########################
intappartmentwantslist.sort()
intappartmentslist.sort()
taken=0
index = 0
"""
for wants in intappartmentwantslist:
    for have in intappartmentslist:
        if have > (wants+apprange):
           continue
        elif have < (wants-apprange):
            break  
        elif have>=(wants-apprange) and have<=(wants+apprange):
            taken+=1
            #intappartmentslist.remove(have)
"""
for i in range(numpeople):
    while ( index < numapparments ):
          if intappartmentwantslist[i] > intappartmentslist[index] + apprange :
               index+=1
          elif intappartmentwantslist[i] < intappartmentslist[index] - apprange:
               break
          else:
               index+=1
               taken+=1
               break



print(taken)