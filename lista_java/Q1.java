abstract class livro{
  private String nome;
  private String autor;
  private int numPaginas;
  private int codigo;
  protected boolean situacao;

  public void setCodigo(int codigo){
    this.codigo = codigo;
  }
  public int getCodigo(){
    return codigo;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public String getNome(){
    return nome;
  }
  public void setAutor(String autor){
    this.autor = autor;
  }
  public String getAutor(){
    return autor;
  }
  public void setnumPaginas(int numPaginas){
    this.numPaginas = numPaginas;
  }
  public int getnumPaginas(){
    return numPaginas;
  }
  public void setSituacao(boolean situacao){
    this.situacao = situacao;
  }
  public abstract void consultarSituacao();
}
class livroBiblioteca extends livro{
  private String nomeDoLeitor;

  public void setNomeLeitor(String nomeLeitor){
    this.nomeDoLeitor = nomeLeitor;
  }
  public String getNomeLeitor(){
    return nomeDoLeitor;
  }
  public void consultarSituacao(){
    if(situacao==true){
      System.out.println("Livro emprestado.");
    }else{
      System.out.println("Livro disponível.");
    }
  }
}
class livroLivraria extends livro{
  private double preco;

  public void setPreco(double preco){
    this.preco = preco;
  }
  public double getPreco(){
    return preco;
  }
  public void consultarSituacao(){
    if(situacao==true){
      System.out.println("Livro vendido.");
    }else{
      System.out.println("Livro disponível para compra.");
    }
  }
}
class Main {
  public static void main(String[] args) {
    System.out.println("bem vindo(a) aos meus livrinhos :)");

    livroBiblioteca meuLivroBib = new livroBiblioteca();   
    livroLivraria meuLivroLiv = new livroLivraria();
    
    meuLivroBib.setNome("Crepusculo");
    meuLivroBib.setAutor("Stephenie Meyer");
    meuLivroBib.setCodigo(123);
    meuLivroBib.setnumPaginas(300);
    meuLivroBib.setNomeLeitor("Dayane");
    meuLivroBib.setSituacao(true);
    meuLivroBib.consultarSituacao();

    meuLivroLiv.setNome("Lua Nova");
    meuLivroLiv.setAutor("Stephenie Meyer");
    meuLivroLiv.setCodigo(321);
    meuLivroLiv.setnumPaginas(300);
    meuLivroLiv.setPreco(50);
    meuLivroBib.setSituacao(false);
    meuLivroBib.consultarSituacao();

  }
}
