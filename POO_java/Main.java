public class Main {
  public static void main(String[] args){
    minhaClasse eu = new minhaClasse("day", 10);
    eu.metodo();
    System.out.println(eu.squareIdade());
    System.out.println(eu.metodoParametro(2,2));
    //static:
    //para todos os objetos criados, professor será "henriquejava"
    minhaSala.professor = "henriqueJava";
    minhaSala aluno1 = new minhaSala();
    aluno1.aluno = "Day";
    System.out.println(aluno1.aluno);
    aluno1.ensinar();
  }
}
