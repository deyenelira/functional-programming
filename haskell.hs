
import Prelude hiding (Maybe (..))

import Prelude hiding (Maybe (..))
vendas semana = semana
val = 1
printaVendas semana = vendas semana ++ "     " ++ vendas semana

totalVendas s sem | s == vendas sem = val + totalVendas s (sem-1)
                  | otherwise = 0

verifica a b c | (a<b) && (a<c) = True
               | otherwise = False

aux n i | i == n = True
        | mod n i == 0 = False
        | otherwise =  aux n (i+1)

func n = aux n 2        

-- funcao pra saber quem eh menor
mini a b | a < b = a
        | otherwise = b

primo a b i | i == (mini a b) = True
            | (mod a i == 0) && (mod b i == 0) = False
            | otherwise = primo a b (i+1)

primos a b = primo a b 2
--4*3*2*1
fatorial a | a == 1 = 1
           | otherwise = a * fatorial (a-1)
--retornar quantos parametros sao iguais
iguais a b | a == b = 2
           | otherwise = 0

qtIguais a b c | (a==b) && (b==c) = 3 
               | otherwise = (iguais a b) + (iguais a c) + (iguais b c)


addEspacos n | n > 0 = " " ++ addEspacos(n-1)
             | otherwise = ""

paraDireita:: Int -> String -> String
paraDireita n x = addEspacos n ++ x

sumList as | as == [] = 0
           | otherwise = (head as) + sumList (tail as)


dobrarElem lista | lista == [] = []
                 | otherwise = (head lista)*2 : dobrarElem (tail lista)

memberShip lista num | lista == [] = False
                     | head lista == num = True
                     | otherwise = memberShip (tail lista) num

sumPairs lista1 lista2 | lista1 == [] || lista2 == [] = []
                       | otherwise = head lista1 + head lista2 : sumPairs (tail lista1) (tail lista2)

--Fn = F(n-1) + F(n-2)
--F1 = 1, F2 = 1

fibonacci n | (n==2 || n==1) = 1
            | otherwise = fibonacci(n-1)+fibonacci(n-2)

fiboPar n i j | (j <= n) && ((fibonacci i `mod` 2)==0) = fibonacci i : fiboPar n (i + 1) (j+1)
              | (j <= n) && ((fibonacci i `mod` 2)/=0) = fiboPar n (i + 1) j
              | otherwise = []

somaDigitos a | a < 10 = a
              | a >= 10 = mod a 10 + somaDigitos (div a 10)

--maiorNum : ordenaLista lista maiorNum
qsort [] = []
qsort (x:xs) = qsort lesser ++ [x] ++ qsort greater
    where
        lesser  = filter (< x) xs
        greater = filter (>= x) xs

--menorMaior que recebe 3 inteiros e retorna uma tupla com o menor e o maior deles kk
menorMaior a b c | a>=b && a>=c && b<=c = (a, b)
                 | a>=b && a>=c && c<=b = (a, c)
                 | b>=a && b>=c && a<=c = (b, a)
                 | b>=a && b>=c && c<=b = (b, c)
                 | c>=a && c>=b && a<=b = (c, a)
                 | c>=a && c>=b && b<=a = (c, b)

ordenaTripla (a, b, c) | a>=b && a>=c && b<=c = (b, c, a)
                       | a>=b && a>=c && c<=b = (c, b, a)
                       | b>=a && b>=c && a<=c = (a, c, b)
                       | b>=a && b>=c && c<=b = (c, a, b)
                       | c>=a && c>=b && a<=b = (a, b, c)
                       | c>=a && c>=b && b<=a = (b, a, c)

type Ponto = (Float, Float)
type Reta  = (Ponto, Ponto)
retornaCoord1 :: Ponto -> Float
retornaCoord1 (a, b) = fst (a, b)
retornaCoord2 :: Ponto -> Float
retornaCoord2 (a, b) = snd (a, b)

vertical :: Reta -> Bool
vertical ((a,b), (c,d)) | retornaCoord1(a,b) == retornaCoord1(c,d) = True
                        | otherwise                                = False
--["Dayane","Lira"];
--transformar todo mundo numa lista so
--"Dayanelira"
--fazer um caso pra cada letra do alfabeto

--isso aqui conta quantas vezes a letra aparece

contador = 1;
contaLista lista c | lista == [] = 0
                   | head lista == c = contador + (contaLista (tail lista) c)
                   | otherwise         = contaLista (tail lista) c
--preciso tirar todos as letras do resto da string
retiraChar lista c | lista == [] = []
                   | head lista == c = retiraChar (tail lista) c
                   | otherwise = head lista:retiraChar (tail lista) c

auxiliarLista lista | lista == [] = []
                    | head lista == 'a' = ('a', contaLista lista 'a'):auxiliarLista (retiraChar (tail lista) 'a')
                    | head lista == 'd' = ('d', contaLista lista 'd'):auxiliarLista (retiraChar (tail lista) 'd')
                    | head lista == 'y' = ('y', contaLista lista 'y'):auxiliarLista (retiraChar (tail lista) 'y')
                    | head lista == 'n' = ('n', contaLista lista 'n'):auxiliarLista (retiraChar (tail lista) 'n')
                    | head lista == 'e' = ('e', contaLista lista 'e'):auxiliarLista (retiraChar (tail lista) 'e')
                    | head lista == 'l' = ('l', contaLista lista 'l'):auxiliarLista (retiraChar (tail lista) 'l')
                    | head lista == 'i' = ('i', contaLista lista 'i'):auxiliarLista (retiraChar (tail lista) 'i')
                    | head lista == 'r' = ('r', contaLista lista 'r'):auxiliarLista (retiraChar (tail lista) 'r')

                    | otherwise         = []

agrupar lista = auxiliarLista (junt lista)

junt :: Eq t => [[t]] -> [t]
junt lista | lista == [] = []
             | otherwise   = (head lista) ++ (junt (tail lista))

funcTeste n = n*2
isCrescent :: (Int -> Int) -> Int -> Bool
isCrescent f n = auxCrescent f n 0
auxCrescent f n aux | aux == n = True
                    | (f aux) > (f (aux+1)) = False
                    | otherwise = auxCrescent f n (aux+1)

elevaQuad a = a*a
elevaQuadrado lista = map elevaQuad lista
somaQuadrado lista = foldr (+) 0 (elevaQuadrado lista)
maiorZero lista = filter teste lista
        where teste n = (n>0)
{--
map :: (t->u)->[t]->[u]
map f []     = []
map f (a:as) = f a : map f as

foldr :: (t->u->u)->u->[t]->u
foldr f s [] = s
foldr f s (a:as) = f a (foldr f s as)
--}
naosei l = foldr (++) [] (map sing l)
        where sing a = [a]


maiores :: [[Int]] -> [Int]
maiores [] = []
maiores (a:xs) = foldr max 0 a : maiores xs

takeDay :: (a->Bool)->[a]->[a]
takeDay p [] = []
takeDay p (a:as) | p a = a : takeDay p as
                 | otherwise = []

dropDay :: (a->Bool)->[a]->[a]
dropDay p [] = []
dropDay p (a:as) | p a = dropDay p as
                 | otherwise = (a:as)

dropSpace :: String -> String
dropSpace [] = []
dropSpace (x:xs)
                | x == ' ' = dropSpace xs
                | otherwise = x : dropSpace xs

iter :: Int -> (t -> t) -> (t -> t)
iter 0 f = id
iter n f = (iter (n-1) f).f

double x = 2*x

concatTupla :: [(Char, Char)] -> (Char, Char) -> [(Char, Char)]
concatTupla tuplaLista tupla | tuplaLista == [] = tupla:[]
                             | otherwise = (head tuplaLista):(concatTupla(tail tuplaLista) tupla)

decEnigma :: String -> [(Char, Char)] -> String
decEnigma string tuplas | string == [] = []
                        | head string == (fst (head tuplas)) = (snd (head tuplas)): decEnigma (tail string) (concatTupla (tail tuplas) (head tuplas))
                        | otherwise = decEnigma string (concatTupla (tail tuplas) (head tuplas))

isReplica :: String -> Int -> Char -> Bool
isReplica string num char | (string == []) && (num==0) = True
                          | (string == []) || (num==0) = False
                          | head string == char = isReplica (tail string) (num-1) char
                          | otherwise = False

btoi :: String -> Int
btoi string = auxBtoi (reverse string) 1
auxBtoi :: String -> Int -> Int
auxBtoi string n | string == [] = 0
                 | head string == '1' = (n*1) + auxBtoi (tail string) (n*2)
                 | otherwise = auxBtoi (tail string) (n*2)

mul2 :: [Int] -> [Int] -> [Int]
mul2 l1 l2 | l1 == [] && l2 == [] = []
           | l1 == [] = 0:mul2 l1 (tail l2)
           | l2 == [] = 0:mul2 (tail l1) l2
           | otherwise = (head l1 * head l2):mul2 (tail l1) (tail l2)

auxExecuta :: String -> Char
auxExecuta string = head string

auxExecuta2 :: String -> Char
auxExecuta2 string = auxExecuta (tail string)

executa :: [(String, Int)] -> Int
executa tuplas = executaAux tuplas 0 0
executaAux tuplas n exp | tuplas == [] = exp
                        | auxExecuta (fst (head tuplas)) == 'M' && n == 0 = executaAux (tail tuplas) 1 0
                        | auxExecuta (fst (head tuplas)) == 'M' && n == 1 = executaAux (tail tuplas) 1 (exp*(snd (head tuplas)))
                        | auxExecuta (fst (head tuplas)) == 'S' && n == 0 && auxExecuta2 (fst (head tuplas)) == 'o' = executaAux (tail tuplas) 1 (exp+(snd (head tuplas)))
                        | auxExecuta (fst (head tuplas)) == 'S' && n == 1 && auxExecuta2 (fst (head tuplas)) == 'o' = executaAux (tail tuplas) 1 (exp+(snd (head tuplas)))
                        | auxExecuta (fst (head tuplas)) == 'S' && n == 0 && auxExecuta2 (fst (head tuplas)) == 'u' = executaAux (tail tuplas) 1 (exp-(snd (head tuplas)))
                        | auxExecuta (fst (head tuplas)) == 'S' && n == 1 && auxExecuta2 (fst (head tuplas)) == 'u' = executaAux (tail tuplas) 1 (exp-(snd (head tuplas)))
                        | auxExecuta (fst (head tuplas)) == 'D' && n == 0 && (snd (head tuplas))==0 = -666
                        | auxExecuta (fst (head tuplas)) == 'D' && n == 0  = executaAux (tail tuplas) 1 0
                        | auxExecuta (fst (head tuplas)) == 'D' && n == 1 && (snd (head tuplas))==0 = -666
                        | auxExecuta (fst (head tuplas)) == 'D' && n == 1 = executaAux (tail tuplas) 1 (exp `div` (snd (head tuplas)))


palavrinha = "14 JAN;Amazon;40.32;15 JAN;Uber;14.84;25 JAN;Uber;34.24;02 FEV;Spotify;8.50;06 FEV;Uber;6.94;05 MAR;Burger;29.90;10 MAR;Burger;24.99;15 MAR;UCI;19.00;08 ABR;Itunes;3.50;13 ABR;Picpay;20.00;"
type Palavra = String

separadores = " !@#&()–[{}]:;%`',?/*~$^+=<>\""

ehSeparador :: Char -> String -> Bool
ehSeparador c "" = False
ehSeparador c (a:as)
        | c == a    = True
        | otherwise = ehSeparador c as 

ehUmSeparador :: Char -> String -> Bool
ehUmSeparador c sep = (length . (filter (== c))) sep > 0 

ehUmSeparadorAlt :: Char -> String -> Bool
ehUmSeparadorAlt c sep = length [x | x <- sep, x == c] > 0

getPalavra :: String -> Palavra
getPalavra "" = ""
getPalavra (c:cs) 
        | ehSeparador c separadores  = ""
        | otherwise = c:getPalavra cs

dropPalavra :: String -> String
dropPalavra "" = ""
dropPalavra texto@(c:cs)
        | not (ehSeparador c separadores)  = dropPalavra cs
        | otherwise = texto

dropEspaco :: String -> String
dropEspaco "" = ""
dropEspaco texto@(c:cs) 
        | ehSeparador c separadores  = dropEspaco cs
        | otherwise = texto

splitPalavras :: String -> [Palavra]
splitPalavras "" = []
splitPalavras texto = 
        let textoOk = dropEspaco texto
        in (getPalavra textoOk) : splitPalavras (dropEspaco (dropPalavra textoOk))

pegaValor string | string == [] = []
                 | otherwise = head (tail string)

logMes2 :: String -> [String] -> [Double]
logMes2 mes string | mes == [] = []
                  | string == [] = []
                  | head string == mes = (read (pegaValor (tail string)) :: Double):(logMes2 mes (tail string))
                  | otherwise = logMes2 mes (tail string)
                  
logMes3 :: [String] -> [Double]
logMes3 string  | string == [] = []
                | head string == "JAN" = (read (pegaValor (tail string)) :: Double):(logMes3 (tail string))
                | head string == "FEV" = (read (pegaValor (tail string)) :: Double):(logMes3 (tail string))
                | head string == "MAR" = (read (pegaValor (tail string)) :: Double):(logMes3 (tail string))
                | head string == "ABR" = (read (pegaValor (tail string)) :: Double):(logMes3 (tail string))
                | otherwise = logMes3 (tail string)

logMes4 string = logMes3 (splitPalavras string)
{--
logMes :: String -> String -> Double
logMes string string2 = foldl1 (+) (logMes2 string (splitPalavras string2))
--}
maiorListinha :: [Double] -> Double 
maiorListinha lista = foldr max 0 lista

menorListinha :: [Double] -> Double
menorListinha lista | lista ==  [] = 9999
                    | (head lista) < (menorListinha (tail lista)) = head lista
                    | otherwise = menorListinha (tail lista)

minMaxCartao :: String -> (Double, Double)
minMaxCartao string = auxMinMaxCartao (logMes4 string)

auxMinMaxCartao :: [Double] -> (Double, Double)
auxMinMaxCartao string = (menorListinha string, maiorListinha string)


data Shape =  Circle Float
             | Rectangle Float Float

area :: Shape -> Float
area (Circle n) = (n*n)*3.14
area (Rectangle n m) = n*m

data Expr =  Lit Int |
             Add Expr Expr |
             Sub Expr Expr
             deriving (Show)

showExpr :: Expr -> String
showExpr exp = show exp
--showExpr (Add (Lit 12) (Lit 4))

{-

data Tree t = Nilt | Node t (Tree t) (Tree t)
              deriving (Read)
collapse :: Tree t -> [t]
collapse (Nilt) = []
collapse (Node n t1 t2) = (n:(collapse t1)) ++ (collapse t2)

depth :: Tree t -> Int
depth (Nilt) = 0
depth (Node n t1 t2) = 1 + (maximoDepth (depth t1) (depth t2))

maximoDepth n m | n > m = n
                | otherwise = m
-}
{-(Node SUM (Node MUL (Nilt 5) (Nilt 3)) (Node SUB (Nilt 10) (Nilt 5)))


data Ops = SUM | MUL | SUB
           deriving (Read)
     
data IntTree = Nilt Int |
               Node Ops IntTree IntTree
               deriving (Read)

evalTree :: IntTree -> Int
evalTree (Nilt n) = n
evalTree (Node SUM t1 t2) = (evalTree t1 + evalTree t2)
evalTree (Node MUL t1 t2) = ((evalTree t1)*(evalTree t2))
evalTree (Node SUB t1 t2) = (evalTree t1 - evalTree t2)

North
[Forward 2, TurnLeft, TurnLeft, Forward 1]

               
data List t = Nil | Cons t (List t)
                deriving (Show, Eq)

toList :: List t -> [t]
toList (Nil) = []
toList (Cons n xs) = n:toList(xs)

fromList :: [t] -> List t
fromList [] = (Nil)
fromList (x:xs) = (Cons x (fromList xs))

data Command = Forward Int | Backward Int | TurnLeft | TurnRight 
               deriving (Eq, Show, Read)

data Direction = North | South | West | East
                 deriving (Read, Show)

faces :: Direction -> [Command] -> Direction
faces (North) list = auxFaces 90 list
faces (South) list = auxFaces 270 list
faces (West) list = auxFaces 0 list
faces (East) list = auxFaces 180 list

auxFaces n list | list == [] && n==90 = North
                | list == [] && n==0 = East
                | list == [] && n==360 = East
                | list == [] && n==180 = West
                | list == [] && n==270 = South
                | head list == (TurnLeft) && (n == 360) = auxFaces 90 (tail list) 
                | head list == (TurnLeft) = auxFaces (n+90) (tail list)
                | head list == (TurnRight) && (n==0) = auxFaces 270 (tail list)
                | head list == (TurnRight) = auxFaces (n-90) (tail list)
                | otherwise = auxFaces n (tail list)



data Direction = North | South | West | East
                 deriving (Read, Show)

data Command = Forward Int | Backward Int | TurnLeft | TurnRight 
               deriving (Eq, Show, Read)


faces :: Direction -> [Command] -> Direction
faces (North) list = auxFaces 90 list
faces (South) list = auxFaces 270 list
faces (West) list = auxFaces 180 list
faces (East) list = auxFaces 0 list

auxFaces n list | list == [] && n==90 = North
                | list == [] && n==0 = East
                | list == [] && n==360 = East
                | list == [] && n==180 = West
                | list == [] && n==270 = South
                | head list == (TurnLeft) && (n == 360) = auxFaces 90 (tail list) 
                | head list == (TurnLeft) = auxFaces (n+90) (tail list)
                | head list == (TurnRight) && (n==0) = auxFaces 270 (tail list)
                | head list == (TurnRight) = auxFaces (n-90) (tail list)
                | otherwise = auxFaces n (tail list)
               
destination :: (Int,Int) -> [Command] -> (Int,Int) 
destination (a,b) list = destinationAux North (a,b) list

destinationAux:: Direction -> (Int,Int) -> [Command] -> (Int,Int)
destinationAux North (a,b) (Forward n:xs) = destinationAux North (a,b+n) xs
destinationAux South (a,b) (Forward n:xs) = destinationAux South (a,b-n) xs
destinationAux West (a,b) (Forward n:xs) = destinationAux West (a-n,b) xs
destinationAux East (a,b) (Forward n:xs) = destinationAux East (a+n,b) xs
destinationAux North (a,b) (Backward n:xs) = destinationAux North (a,b-n) xs
destinationAux South (a,b) (Backward n:xs) = destinationAux South (a,b+n) xs
destinationAux West (a,b) (Backward n:xs) = destinationAux West (a+n,b) xs
destinationAux East (a,b) (Backward n:xs) = destinationAux East (a-n,b) xs
destinationAux d (a,b) (x:xs) = destinationAux (faces d [x, Forward 1]) (a,b) xs
destinationAux d (a,b) [] = (a,b)

              
data List t = Nil | Cons t (List t)
                deriving (Show, Eq)

toList :: List t -> [t]
toList (Nil) = []
toList (Cons n xs) = n:toList(xs)

fromList :: [t] -> List t
fromList [] = (Nil)
fromList (x:xs) = (Cons x (fromList xs))
-}
inserir n (Nilt) = (Node n Nilt Nilt)
inserir n (Node m t1 t2) | n > m = (Node m t1 (inserir n t2))
                         | otherwise = (Node m (inserir n t1) t2)

data Tree t = Nilt | Node t (Tree t) (Tree t)
             deriving (Read, Show)
        
insertList :: Ord t => Tree t -> [t] -> Tree t
insertList arvore [] = arvore
insertList (Node n t1 t2) (x:xs) = (compara n x t1 t2 xs) 
insertList (Nilt) (x:xs) = insertList (Node x (Nilt) (Nilt)) xs

compara n x t1 t2 xs | x > n = insertList (Node n t1 (inserir x t2)) xs
                     | otherwise = insertList (Node n (inserir x t1) t2) xs

auxBST1 m (Nilt) = True
auxBST1 m (Node o t3 t4) | m > o = (auxBST1 m t3) && (auxBST1 m t4)
                         | otherwise = False

auxBST2 m (Nilt) = True
auxBST2 m (Node o t3 t4) | m < o = (auxBST2 m t3) && (auxBST2 m t4)
                         | otherwise = False

isBST :: Ord t => Tree t -> Bool
isBST (Nilt) = True
isBST (Node n t1 t2) | ((auxBST1 n t1) && (auxBST2 n t2)) = ((isBST t1) && (isBST t2))
                     | otherwise = False

data Cmd = Cursor Int
           | Backspace Int
           | Delete Int
           | Insert String
           deriving (Read)

insertAux string1 string n m c | m < n = insertAux (head string:string1) (tail string) n (m+1) c
                               | otherwise = reverse string1 ++ c ++ string

deleteAux string1 string cursor contador numDel | contador < cursor = deleteAux (head string:string1) (tail string) cursor (contador+1) numDel
                                                | otherwise = reverse string1 ++ deleteAux2 string 0 numDel

deleteAux2 string contador numDel | contador < numDel = deleteAux2 (tail string) (contador+1) numDel
                                  | otherwise = string

backSpaceAux string1 string cursor contador numDel | contador < cursor = backSpaceAux (head string:string1) (tail string) cursor (contador+1) numDel
                                                   | otherwise = (reverse (backSpaceAux2 string1 0 numDel))  ++ string
backSpaceAux2 string contador numDel | contador < numDel = backSpaceAux2 (tail string) (contador+1) numDel
                                     | otherwise = string

editText :: String -> [Cmd] -> String
editText string (x:xs) = editTextAux string (x:xs) 0

editTextAux string (Backspace n:xs) cursor = editTextAux (backSpaceAux [] string cursor 0 n) xs cursor
editTextAux string (Delete n:xs) cursor = editTextAux (deleteAux [] string cursor 0 n) xs cursor
editTextAux string (Insert a:xs) cursor = editTextAux (insertAux [] string cursor 0 a) xs cursor
editTextAux string (Cursor n:xs) cursor = editTextAux string xs (cursor+n)
editTextAux string [] cursor = string


data Maybe a = Just a |
               Nothing
               deriving(Show)

safeSecond :: [a] -> Maybe a
safeSecond [] = Nothing
safeSecond list  = safe (tail list)
safe (a:as) = Just a
safe [] = Nothing

safeCalc :: String -> IO ()
safeCalc list = print(separa [] [] list)

separa num1 num2 [] = Nothing
separa num1 num2 list | (head list) == 's' && head (tail (tail list))=='b' = fazOp (reverse num1) (tail (tail (tail list))) 1
                      | (head list) == 's' && head (tail (tail list))=='m' = fazOp (reverse num1) (tail (tail (tail list))) 2
                      | (head list) == 'd' && (contaZeros (tail (tail (tail list))))==0 = fazOp (reverse num1) "0" 3
                      | (head list) == 'd' = fazOp (reverse num1) (tail (tail (tail list))) 3
                      | (head list) == 'm' = fazOp (reverse num1) (tail (tail (tail list))) 4
                      | otherwise = separa (head list:num1) num2 (tail list)

fazOp num1 num2 1 = Just ((read num1::Int) - (read num2::Int))
fazOp num1 num2 2 = Just ((read num1::Int) + (read num2::Int))
fazOp num1 "0" 3 = Nothing
fazOp num1 num2 3 = Just ((read num1::Int) `div` (read num2::Int))
fazOp num1 num2 4 = Just ((read num1::Int) * (read num2::Int))

contaZeros :: String -> Int
contaZeros [] = 0
contaZeros ('0':xs) = 0 + contaZeros xs
contaZeros ('1':xs) = 1 + contaZeros xs
contaZeros ('2':xs) = 2 + contaZeros xs
contaZeros ('3':xs) = 3 + contaZeros xs
contaZeros ('4':xs) = 4 + contaZeros xs
contaZeros ('5':xs) = 5 + contaZeros xs
contaZeros ('6':xs) = 6 + contaZeros xs
contaZeros ('7':xs) = 7 + contaZeros xs
contaZeros ('8':xs) = 8 + contaZeros xs
contaZeros ('9':xs) = 9 + contaZeros xs



