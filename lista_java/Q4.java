class Senha {
  protected String senha1;
  protected int senha2; 

  protected Senha(String senha1, int senha2){
    this.senha1 = senha1;
    this.senha2 = senha2;
  }
  protected void setS1(String sen1){
    this.senha1 = sen1;
  }
  protected void setS2(int sen2){
    this.senha2 = sen2;
  }
  protected String getS1(){
    return senha1;
  }
  protected int getS2(){
    return senha2;
  }
}
class Conta {
  protected int numIdentificacao;
  protected int agencia;
  protected Senha senha;

  protected Conta(int id, int agc, String sen1, int sen2){
    this.numIdentificacao = id;
    this.agencia = agc;
    this.senha = new Senha(sen1, sen2);
  }
  protected void setID(int ID){
    this.numIdentificacao = ID;
  }
  protected void setAgencia(int agc){
    this.agencia = agc;
  }
  protected void setSen(String sen1, int sen2){
    this.senha = new Senha(sen1, sen2);
  }
  protected void setSen1(String sen1){
    this.senha.setS1(sen1);
  }
  protected void setSen2(int sen2){
    this.senha.setS2(sen2);
  }
  protected int getID(){
    return numIdentificacao;
  }
  protected int getAgencia(){
    return agencia;
  }
  protected String getSen1(){
    return senha.senha1;
  }
  protected int getSen2(){
    return senha.senha2;
  }
}

class Main {
  public static void main(String[] args) {
    Conta minhaConta = new Conta(1234, 007,"a1b2c3",123);
    System.out.println(minhaConta.getID());
    System.out.println(minhaConta.getSen1());
    minhaConta.setSen1("dayane");
    System.out.println(minhaConta.getSen1());
  }
}
