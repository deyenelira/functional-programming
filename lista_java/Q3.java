enum idtGenero{
  CISGENERO, TRANSGENERO, GENERO_FLUIDO, NAO_BINARIO;
}
class Pessoa{
  private String nome;
  private int idade;
  private String grauEscolaridade;
  private idtGenero identidadeGenero;
  private String orientacaoSexual;
  private String sexoBiologico;
  
  public Pessoa(){
    //default
  }
  public Pessoa(String nome, int idade, String grauEscolaridade, idtGenero identidadeGenero, String orientacaoSexual, String sexoBiologico){
    this.nome = nome;
    this.idade = idade;
    this.grauEscolaridade = grauEscolaridade;
    this.identidadeGenero = identidadeGenero;
    this.orientacaoSexual = orientacaoSexual;
    this.sexoBiologico = sexoBiologico;
  }
  public String getnome(){
    return nome;
  }
  public int getidade(){
    return idade;
  }
  public String getgrauEscolaridade(){
    return grauEscolaridade;
  }
  public idtGenero getidentidadeGenero(){
    return identidadeGenero;
  }
  public String getorientacaoSexual(){
    return orientacaoSexual;
  }
  public String getsexoBiologico(){
    return sexoBiologico;
  }
  public void setnome(String nome){
    this.nome = nome;
  }
  public void setidade(int idade){
    this.idade = idade;
  }
  public void setgrauEscolaridade(String grauEscolaridade){
    this.grauEscolaridade = grauEscolaridade;
  }
  public void dormir(){
    System.out.println("mimindo");
  }
  public void cagar(){
    System.out.println("fazendo caquinha");
  }
  public void comer(){
    System.out.println("comendo");
  }
  public void estudar(){
    System.out.println("estudando");
  }
  public void viver(){
    System.out.println("vivendo");
  }
  public void sobreviver(){
    System.out.println("sobrevivendo");
  }
  public void trabalhar(){
    System.out.println("trabalhando");
  }
}
class Main {
  public static void main(String[] args) {
    System.out.println("bem vindo(a) ao meu textinho :)");

    //Pessoa day = new Pessoa();
    Pessoa day = new Pessoa("Dayane", 20, "tec", idtGenero.CISGENERO, "hetero", "F");  
    System.out.println(day.getnome());
    System.out.println(day.getidentidadeGenero()); 
    day.comer(); 
  }
}
