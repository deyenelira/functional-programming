public class minhaClasse{
  String meuNome = "day";
  int minhaIdade = 20;
  void metodo(){
    System.out.println(minhaIdade);
  }
  int squareIdade(){
    return (minhaIdade*minhaIdade);
  }
  int metodoParametro(int a, int b){
    return a*b;
  }
  //funções com número N de parametros
  int somaNum(int ... numeros){
    int soma = 0;
    for(int n : numeros){
      soma+=n;
    }
    return soma;
  }
  //construtor: quando a classe inicia ele estabelece as configurações
  minhaClasse(String a, int b){
    meuNome = a;
    minhaIdade = b;
    System.out.println("Iniciei!");
  }
}
