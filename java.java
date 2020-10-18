class Main {
  //comentario, apenas
  /*varias linhas*/
  public static void main(String[] args) {
    System.out.println("Hello world!");
    //tipos:
    String meuNome = "Dayane";
    int idade = 20;
    double peso = 47.0;
    char letra = 'a';
    boolean meuBool = true;
    //concatenando apenas
    meuNome = meuNome + " Lira";
    //para imprimir:
    System.out.println("meu nome é "+ meuNome + " e minha idade é " + idade);
    System.out.println(idade);
    System.out.println(peso);
    System.out.println(letra);
    System.out.println(meuBool);
    //condicionais rs
    if(true){
      System.out.println("Tudo");
    }else if(!true){
      System.out.println("Igual");
    }else{
      System.out.println("a C");
    }
    //Switch igual a c tambem apenas
    int diaSemana = 10;
    String nomeDoDia;
    switch (diaSemana){
    case 1: nomeDoDia = "Segunda"; break;
    default: nomeDoDia = "Dayday"; break;
    }
    System.out.println(nomeDoDia);
    //lacinhossssssss
    int loop = 10;
    //essa poha n da pra meter um loop-- to triste
    while(loop>0){
      System.out.println(loop);
      loop--;
    }
    loop = 10;
    do{
      System.out.println(loop);
      loop--;
    }while(loop>0);
    //forzinho humilde
    for(loop=1; loop<=10; loop++){
      System.out.println(loop);
    }
    //fazendo array em javinha
    String[] array;
    array = new String[10];
    array[0] = "Dayane";
    array[1] = "Lira";

    for(loop=0; loop<10; loop++){
      System.out.println(array[loop]);
    }
    //array de inteirinhos
    int[] arrayInt;
    arrayInt = new int[10];
    for(loop=0; loop<10; loop++){
      arrayInt[loop] = loop;
      System.out.println(arrayInt[loop]);
    }
    /*outro jeito de inicializar o array:
    int[] array = {1,2,3,45,6,77};
    */
    //foreach: percorre os elementos do array
    for(int num: arrayInt){
      System.out.println(num);
    }
    //matriz
    int[][] matriz;
    matriz = new int[2][2];

  }
}
