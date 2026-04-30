#fenwick tree and binary search
import sys 
 
def solve():
 
    def actualizar(i, delta): 
        while i <= m: 
            bit[i] += delta
            i += i&(-i)
 
    def query(i): 
        s = 0
        while i > 0: 
            s+= bit[i]
            i -= i&(-i) 
        return s 
 
    def buscar(v): 
        posicion = 0
        suma = 0
        for i in range(bit_len -1, -1, -1): 
            siguiente = posicion + (1 << i)
            if siguiente <= m and suma + bit[siguiente] < v: 
                posicion = siguiente 
                suma += bit[posicion]
        return posicion+1
 
 
    read = sys.stdin.read().split()
    n = int(read[0])
    k = int(read[1])
 
    p = []
    coor = {0}
    j = 2
    for i in range(n): 
        empieza = int(read[j])
        acaba = int(read[j+1])
        p.append((empieza, acaba))
        coor.add(empieza)
        coor.add(acaba)
        j+=2
 
 
    ordenado = sorted(list(coor))
    r = {val: i+1 for i, val in enumerate(ordenado)}
    m = len(ordenado)
    bit = [0] * (m+1) #fenwick tree
    bit_len = m.bit_length()
 
    actualizar(r[0], k)
    p.sort(key=lambda x: x[1])
 
    total = 0
    
    for s, e in p: 
        i_s = r[s]
        i_e = r[e]
        d = query(i_s)
        
        if d > 0: 
            posicion = buscar(d)
            actualizar(posicion, -1, )
            actualizar(i_e, 1)
            total += 1
 
    print(total)
 
solve()