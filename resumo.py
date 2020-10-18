#criando funções:
def nomeDaFuncao(parametro):
    #coisas
    return parametro
def printaNome(parametro):
    print("oi", parametro)

nomeDaFuncao(10)
print(nomeDaFuncao(10))

variavel = "Day"
printaNome(variavel)
#comando if:
condicao = 1
if condicao:
    print("oi")
elif condicao:
    print("oi")
else: print("oi")

#operadores lógicos:
if not condicao:
    print("oi")
if condicao and condicao:
    print("oi")
if condicao or condicao:
    print("oi")
#função input lê como string tudo que o usuário digitar antes de "ENTER":
umString = input("qual o seu nome?")
#para transformar em outros tipos é só fazer:
int(umString)
float(umString)
bool(umString)

#lacinhos em py, o range vai de 0 até 9 nesse caso
for i in range(0,10):
    print(i)
#outros jeitos:
#aqui, printa todos os elementos de itens
itens = [1,2,3,4,5]
for item in itens:
    print(item)
#aqui, printa todas as letras de DAYANE
minhaString = "DAYANE"
for c in minhaString:
    print(c)
    
#Exemplos usando range:
range(0,10) #Inteiros de 0 a 9
range(10) #Inteiros de 0 a 9
range(0,10,2) #Inteiros pares de 0 a 9
range(0,-10,-1) #Inteiros de 0 a -9, nessa ordem
maximo = 18
minimo = 10
range(minimo,maximo+1,2) #10,12,14,16,18

#Listas podem ter vários tipos juntos:
itens.append(6) #adiciona 6 no fim da minha lista
itens.len() #retorna o tamanho da minha lista
#criando uma cópia de uma parte
#de uma lista
a = ['f','g','h','i','j']
b = a[1:3] #b=['g','h']
c = a[0:len(a)] #c=['f','g','h','i','j']
d = c[3:] #d=['i','j']
#concatenando listas
c = a + b #['f','g','h','i','j','g','h']
cavaleiros = ["Seiya", "Hyoga", "Shiryu", "Shun", "Ikki"]
cavaleiros.pop(4) # remove da posição 4 e devolve
'Ikki'
cavaleiros
['Seiya', 'Hyoga', 'Shiryu', 'Shun']
cavaleiros.insert(0, "Aioria") # inclui no começo
cavaleiros
['Aioria', 'Seiya', 'Hyoga', 'Shiryu', 'Shun']
cavaleiros.insert(5, "Miro") # depois da última posição!
cavaleiros
['Aioria', 'Seiya', 'Hyoga', 'Shiryu', 'Shun', 'Miro']

#Dicionarios:
codigos = {'BR':55, 'US':1, 'JP':81,'UK':44, 'VU':678, 'UY':598, ...}

codigos.get('VU', -1) # devolve 678
# Se tivermos certeza que 'VU' está lá:
codigos['VU'] # devolve 678

#ORIENTAÇÃO A OBJETOS:
#uma classe:

class Tempo:
    #construtor da classe
    def __init__(self, h: int, m: int, s: int):
    self.segundo = s
    self.minuto = m
    self.hora = h
    #definindo outra função para a classe:
    #todas as funções de uma classe possuem SELF como primeiro parâmetro!!!!
    def segundos(self):
        return self.hora*3600+self.minuto*60+self.segundo

t:Tempo = Tempo(21,42,24)

#Tratamento de erro em pyzada:
entradas = []
while entradas == []:
    #caso o usuario digite coisas estranhas, a função vai retornar o erro!
    entradas = lerNumeros()
    try: #caso dê tudo certo, executa o try
    oMaior = maiorElemento(entradas) #região protegida
    print(oMaior)
    break
    except RuntimeError as err: #caso dê tudo errado, entra no except, printa o erro e segue a vida
    print("Forneça pelo menos um número.")  #tratador
#variações do except :)

# captura por tipo, objeto é acessível no tratador
except RuntimeError as err:
print("Forneça pelo menos um número.")
# captura por tipo, objeto não é acessível
except RuntimeError:
print("Forneça pelo menos um número.")
# captura independentemente do tipo
except:
print("Forneça pelo menos um número.")

#a função pode ter vários erros diferentes
def maiorElemento(numeros):
    if len(numeros) == 0:
        raise RuntimeError("lista vazia")
    maior = numeros[0]
    for x in numeros:
        if type(x) != int:
            raise TypeError("elemento não é inteiro.")
        if x > maior:
            maior = x
    return maior

#dá pra tratar todos os erros juntinhos desse jeito:
except (RuntimeError, TypeError) as err:
    print("Lista de números inválida.")

#mais tratamento de erro, n aguento mais\zzzz
def lerLinhasArquivo(nome:str) -> List[str]:
    try:
        f = open(nome, "r")
        linhas = f.readlines()
        return linhas
    finally: #isso sempre executa, independente do que aconteça na zona protegida zz
        f.close()
