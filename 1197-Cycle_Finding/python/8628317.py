#pridobi input
točke, povezave = map(int, input().split()) 

lista_povezav = [] #lista v katero bomo dali vse povezave
for _ in range(povezave):
    a, b, x = map(int, input().split())
    lista_povezav.append((a, b, x))


razdalje = [0]*(točke+1)
predhodniki = [0]*(točke+1)
# Bellman fordov algoritem spremenimo, da išče le negativen cikel v grafu
# za to damo vse razdalje na nič in ne na neskončno, ker iščemo najkrajšo pot od vseh vozlišč (točk) naenkrat
# ta način ne vpliva na to v kakšnem vrstnem redu odkrijemo negativni cikel

# gremo skozi graf n-krat in spremljamo spremenljivko x, ki zapiše katera točka je obiskana 
# če je v grafu negativen cikel se bo v zadnjem prehodu lista razdalj spremenila, kar pomeni
# da je ta točka del negativnega cikla ali pa dosegljiva iz njega
for i in range(točke): #n krat gremo skozi graf
    x = -1 #x označuje točko na keri smo končali,če ostane -1 ni spremembe razdalj
    for povezava in lista_povezav:
        if razdalje[povezava[0]] + povezava[2] < razdalje[povezava[1]]:
            razdalje[povezava[1]] = razdalje[povezava[0]] + povezava[2]
            predhodniki[povezava[1]] = povezava[0]
            x = povezava[1]  # zadnja točka obiskana

if x == -1:
    print("NO")
# če je prisoten negativen cikel
else:
    print("YES")

    y = x
    for i in range(točke):
        y = predhodniki[y]

    pot = []
    zacetek = y

    while True:
        pot.append(zacetek)
        # ko srečamo točko ponovno, po štartu
        if zacetek == y and len(pot) > 2:
            break
        zacetek = predhodniki[zacetek]

    print(*pot[::-1], sep=" ")