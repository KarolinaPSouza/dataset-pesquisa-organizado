def pagina(n, presupuesto, precios, paginas):
    dp = [0] * (presupuesto + 1)

    for i in range(n):
        costo = precios[i]
        beneficio = paginas[i]
        for j in range(presupuesto, costo - 1, -1):
            if dp[j - costo] + beneficio > dp[j]:
                dp[j] = dp[j - costo] + beneficio

    return dp[presupuesto]

def main():
    n, presupuesto = map(int, input().split())
    precios = list(map(int, input().split()))
    paginas = list(map(int, input().split()))

    resultado = pagina(n, presupuesto, precios, paginas)
    print(resultado)



main()