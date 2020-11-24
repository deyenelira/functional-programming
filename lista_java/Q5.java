interface Colecao {
  public void inserir(Pessoa p);
  public int tamanhoColecaoNaoNull();
}
class colecaoVetor implements Colecao{
  Pessoa[] vetPessoas = new Pessoa[5];

  public colecaoVetor(){
    Pessoa a = new Aluno("a", "a", "a", "a");
    for(int i=0; i<5; i++){
      vetPessoas[i] = a;
    }
  }
  public void inserir(Pessoa p){
    Pessoa a = new Aluno("a", "a", "a", "a");
    for(int i=0; i<5; i++){
      if(vetPessoas[i].getNome().compareTo(a.getNome())==0){
        vetPessoas[i] = p;
        break;
      }
    }
  }
  public int tamanhoColecaoNaoNull(){
    int num=0;
    Pessoa a = new Aluno("a", "a", "a", "a");
    for(int i=0; i<5; i++){
      if(vetPessoas[i].getNome().compareTo(a.getNome())!=0){
        num = num + 1;
        System.out.println(vetPessoas[i].getNome());
      }
    }
    return (5-num);
  }
}
abstract class Pessoa {
  protected String nome;
  protected String cpf;

  public Pessoa(){

  }
  public String getNome(){
    return nome;
  }
  public String getCpf(){
    return cpf;
  }
  public abstract void setNome(String nome);
  public abstract void setCpf(String cpf);
}
class Aluno extends Pessoa{
  
  private String matricula;
  private String curso;

  public Aluno(String nome, String cpf, String mat, String curso){
    this.matricula = mat;
    this.curso = curso;
    this.cpf = cpf;
    this.nome = nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  
  public void setCpf(String cpf){
    this.cpf = cpf;
  }
  public void setMatricula(String mat){
    this.matricula = mat;
  }
  public void setCurso(String curso){
    this.curso = curso;
  }
  public String getMatricula(){
    return matricula;
  }
  public String getCurso(){
    return curso;
  }
}
class Professor extends Pessoa{
  private String formacao;
  private String area;

  public Professor(String nome, String cpf, String formacao, String area){
    this.nome = nome;
    this.cpf = cpf;
    this.formacao = formacao;
    this.area = area;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setCpf(String cpf){
    this.cpf = cpf;
  }
  public void setFormacao(String formacao){
    this.formacao = formacao;
  }
  public void setArea(String area){
    this.area = area;
  }
  public String getFormacao(){
    return formacao;
  }
  public String getArea(){
    return area;
  }

}
class Main {
  public static void main(String[] args) {
    colecaoVetor colecao = new colecaoVetor();
    Pessoa day = new Aluno("Day", "123", "321", "Engenharia");
    colecao.inserir(day);
    System.out.println(colecao.tamanhoColecaoNaoNull());
    Pessoa aninha = new Aluno("Aninha", "123", "321", "Engenharia");
    colecao.inserir(aninha);
    System.out.println(colecao.tamanhoColecaoNaoNull());
    Pessoa alice = new Aluno("Alice", "123", "321", "Engenharia");
    colecao.inserir(alice);
    System.out.println(colecao.tamanhoColecaoNaoNull());


  }
}
