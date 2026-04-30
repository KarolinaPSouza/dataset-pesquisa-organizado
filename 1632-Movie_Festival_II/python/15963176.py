import sys
 
# Lectura ultra-rápida
input = sys.stdin.read
 
def solve():
    data = input().split()
    if not data: return
    
    iterator = iter(data)
    try:
        n = int(next(iterator))
        k = int(next(iterator))
    except StopIteration:
        return
 
    # --- OPTIMIZACIÓN SUPREMA (O(1)) ---
    # Si tienes más amigos (o los mismos) que películas,
    # simplemente asignas un amigo a cada peli y listo.
    # Esto elimina de golpe el TLE del Test 8 y 12 si K es muy grande.
    if k >= n:
        print(n)
        return
 
    movies = []
    times = set()
    times.add(0) # El tiempo 0 siempre es necesario
    
    for _ in range(n):
        s = int(next(iterator))
        e = int(next(iterator))
        movies.append((s, e))
        times.add(s)
        times.add(e)
        
    # --- 1. COMPRESIÓN DE COORDENADAS ---
    sorted_times = sorted(list(times))
    m = len(sorted_times)
    # Mapeamos tiempo_real -> ranking (1, 2, ... M)
    # Usamos base 1 para el Fenwick Tree (es más cómodo)
    rank_map = {t: i + 1 for i, t in enumerate(sorted_times)}
    
    # Comprimimos las pelis
    # OJO: Greedy sigue siendo clave -> Ordenar por tiempo de FIN
    movies_compressed = [(rank_map[s], rank_map[e]) for s, e in movies]
    movies_compressed.sort(key=lambda x: x[1])
    
    # --- 2. FENWICK TREE (BINARY INDEXED TREE) ---
    # bit[i] guarda el número de personas libres en el rango que cubre i
    bit = [0] * (m + 1)
    
    # Función para añadir valor (delta) en la posición idx
    def update(idx, delta):
        while idx <= m:
            bit[idx] += delta
            idx += idx & (-idx) # Truco bitwise para subir en el árbol
            
    # Función para obtener suma prefija hasta idx
    # Nos dice: "¿Cuánta gente hay libre terminando en tiempo <= idx?"
    def query(idx):
        s = 0
        while idx > 0:
            s += bit[idx]
            idx -= idx & (-idx)
        return s
 
    # Función BINARY LIFTING para encontrar el índice de la k-ésima persona
    # Encuentra el índice más pequeño tal que la suma acumulada sea >= target_k
    # Como buscamos la ÚLTIMA persona disponible, target_k será el total de gente disponible.
    def find_kth_index(target_k):
        idx = 0
        current_sum = 0
        # Empezamos desde la potencia de 2 más alta posible <= m
        # Esto equivale a bajar desde la raíz del árbol implícito
        bit_mask = 1 << (m.bit_length() - 1)
        
        while bit_mask > 0:
            next_idx = idx + bit_mask
            if next_idx <= m:
                if current_sum + bit[next_idx] < target_k:
                    # Si sumando este bloque no llegamos al target,
                    # significa que el target está más a la derecha.
                    # Avanzamos y sumamos lo que hemos saltado.
                    idx = next_idx
                    current_sum += bit[idx]
            bit_mask >>= 1
        return idx + 1
 
    # --- 3. SIMULACIÓN ---
    # Inicialmente, los K amigos están libres en el tiempo 0 (rank 1)
    # rank_map[0] siempre será 1 porque 0 es el menor tiempo
    start_rank = rank_map[0]
    update(start_rank, k)
    
    ans = 0
    
    for s, e in movies_compressed:
        # Paso 1: ¿Cuántos amigos hay libres en total antes o justo cuando empieza la peli?
        available_count = query(s)
        
        if available_count > 0:
            # Paso 2: Si hay alguien, queremos al que terminó MÁS TARDE.
            # Ese corresponde exactamente a la persona número 'available_count' en la lista ordenada.
            # (Ej: si hay 5 personas, queremos la 5ª).
            
            # Usamos binary lifting para encontrar dónde está esa persona
            member_idx = find_kth_index(available_count)
            
            # Paso 3: Asignamos la peli
            ans += 1
            update(member_idx, -1) # Sacamos al amigo de su tiempo viejo
            update(e, 1)           # Lo metemos en su tiempo nuevo (fin de peli)
            
    print(ans)
 
if __name__ == "__main__":
    solve()