import sys
 
# Usamos sys.stdin.read para leer todo de golpe, es lo más rápido en Python
def solve():
    data = sys.stdin.read().split()
    if not data: return
    
    n = int(data[0])
    k = int(data[1])
    
    movies = []
    coords = {0} # Incluimos el tiempo 0 para los k miembros iniciales
    ptr = 2
    for _ in range(n):
        s = int(data[ptr])
        e = int(data[ptr+1])
        movies.append((s, e))
        coords.add(s)
        coords.add(e)
        ptr += 2
        
    # --- Compresión de Coordenadas ---
    sorted_coords = sorted(list(coords))
    rank = {val: i + 1 for i, val in enumerate(sorted_coords)}
    m = len(sorted_coords)
    
    # --- Estructura Fenwick Tree (BIT) ---
    bit = [0] * (m + 1)
    
    def update(i, delta):
        while i <= m:
            bit[i] += delta
            i += i & (-i)
            
    def query(i):
        s = 0
        while i > 0:
            s += bit[i]
            i -= i & (-i)
        return s
    
    # --- Binary Lifting sobre el BIT ---
    # Encuentra el índice más pequeño 'pos' tal que la suma acumulada sea >= v
    bit_len = m.bit_length()
    def find_kth(v):
        pos = 0
        current_sum = 0
        for i in range(bit_len - 1, -1, -1):
            next_pos = pos + (1 << i)
            if next_pos <= m and current_sum + bit[next_pos] < v:
                pos = next_pos
                current_sum += bit[pos]
        return pos + 1
 
    # Empezamos con k miembros en el tiempo "0"
    update(rank[0], k)
    
    # Greedy: Ordenar por tiempo de fin
    movies.sort(key=lambda x: x[1])
    
    total_movies = 0
    for s, e in movies:
        idx_s = rank[s]
        idx_e = rank[e]
        
        # ¿Cuántos miembros han terminado antes o en el tiempo 's'?
        available_count = query(idx_s)
        
        if available_count > 0:
            # Buscamos al miembro que terminó más tarde (el 'available_count'-ésimo)
            # Esto es lo más eficiente para simular un multiset.upper_bound de C++
            pos = find_kth(available_count)
            
            # Actualizamos: el miembro ya no está en 'pos', ahora está en 'idx_e'
            update(pos, -1)
            update(idx_e, 1)
            total_movies += 1
            
    print(total_movies)
 
solve()