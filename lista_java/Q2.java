class Texto{
  private String texto;
  protected void setTexto(String texto){
    this.texto = texto;
  }
  protected void printTexto(){
    System.out.println(texto);
  }
  protected int numPalavras(){
    String palavras[] = texto.split(" ");
    int num = palavras.length;
    return num;
  }
  protected int freqPalavra(String palavra){
    int freq = 0;
    String txt = texto.replaceAll("[.,;/?!#@$%&*()+=:]","");
    String palavras[] = txt.split(" ");
    int num = palavras.length;
    for(int i=0; i<num; i++){
      if(palavra.compareTo(palavras[i])==0) freq = freq + 1;
    }
    return freq;
  }
  protected String replacePalavra(String palavra1, String palavra2){
     String txt = texto.replaceAll(palavra1,palavra2);
      return txt;
  }
}
class Main {
  public static void main(String[] args) {
    System.out.println("bem vindo(a) ao meu textinho :)");
    Texto meuTexto = new Texto();
    meuTexto.setTexto("testando os metodos da minha classe Texto... day day day day ane ane ane!!!!! nao sei mais o que escrever");
    meuTexto.printTexto();
    System.out.println(meuTexto.numPalavras());
    System.out.println(meuTexto.freqPalavra("day"));
    System.out.println(meuTexto.replacePalavra("day", "ane"));
    System.out.println(meuTexto.replacePalavra("classe", "CLASSE"));

  }
}
