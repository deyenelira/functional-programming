import java.util.Scanner;
interface Expression {
  public String avaliar(String expr);
  public String imprimirArvore(String expr);
}
class ExprAritmetica implements Expression {
  public String avaliar(String expr){
    String result = "";
    if(expr.length()==1){
      result = expr;
    }
    else{
      int mult=0, div=0, soma=0, sub=0;
      for(int i=0; i<expr.length(); i++){
        if(expr.charAt(i)=='*') mult = mult + 1;
        else if(expr.charAt(i)=='/') div = div + 1;
        else if(expr.charAt(i)=='+') soma = soma + 1;
        else if(expr.charAt(i)=='-') sub = sub + 1;
      }
      if(mult==0 && div==0 && soma==0 && sub==0){
        String aux = new StringBuilder(expr).reverse().toString();
        result = aux;
      }else{
        for(int i=0; i<expr.length(); i++){
          if(expr.charAt(i)=='-'){
            sub = sub - 1;
            double resp = (Double.valueOf(avaliar(expr.substring(i+1))).doubleValue()) - (Double.valueOf(avaliar(expr.substring(0,i))).doubleValue());
            result = Double.toString(resp);
            i = expr.length() + 1;
          }else if(expr.charAt(i)=='+'&& sub<=0){
            soma = soma - 1;
            double resp = (Double.valueOf(avaliar(expr.substring(0,i))).doubleValue()) + (Double.valueOf(avaliar(expr.substring(i+1))).doubleValue());
            result = Double.toString(resp); 
            //System.out.println(expr.substring(0,i));
            i = expr.length() + 1;
          }else if(expr.charAt(i)=='/' && soma<=0 && sub<=0){
              div = div - 1;
              double resp = (Double.valueOf(avaliar(expr.substring(i+1))).doubleValue()) / (Double.valueOf(avaliar(expr.substring(0,i))).doubleValue());
              result = Double.toString(resp); 
              //System.out.println(result);
              i = expr.length() + 1;
          }else if(expr.charAt(i)=='*' && soma<=0 && sub <=0){
            mult = mult - 1;
            double resp = (Double.valueOf(avaliar(expr.substring(0,i))).doubleValue()) * (Double.valueOf(avaliar(expr.substring(i+1))).doubleValue());
            result = Double.toString(resp);
            i = expr.length() + 1;
          }
        }
      }
    }
    //Double.valueOf(expr).doubleValue()
    return result;
  }
  public String imprimirArvore(String expr){
    String result = "";
    if(expr.length()==1){
      result = "(" + expr + ")";
    }
    else{
      int mult=0, div=0, soma=0, sub=0;
      for(int i=0; i<expr.length(); i++){
        if(expr.charAt(i)=='*') mult = mult + 1;
        else if(expr.charAt(i)=='/') div = div + 1;
        else if(expr.charAt(i)=='+') soma = soma + 1;
        else if(expr.charAt(i)=='-') sub = sub + 1;
    }
      if(mult==0 && div==0 && soma==0 && sub==0){
          String aux = new StringBuilder(expr).reverse().toString();
          result = "(" + aux + ")";
      }else{
        for(int i=0; i<expr.length(); i++){
          if(expr.charAt(i)=='-'){
            sub = sub - 1;
            result = "(" + imprimirArvore(expr.substring(i+1)) + "-" + imprimirArvore(expr.substring(0,i)) + ")";
            i = expr.length() + 1;
          }else if(expr.charAt(i)=='+'&& sub<=0){
            soma = soma - 1;
            result = "(" + imprimirArvore(expr.substring(i+1)) + "+" + imprimirArvore(expr.substring(0,i)) + ")";
            i = expr.length() + 1;
          }else if(expr.charAt(i)=='/' && soma<=0 && sub<=0){
              div = div - 1;
              result = "(" + imprimirArvore(expr.substring(i+1)) + "/" + imprimirArvore(expr.substring(0,i)) + ")";
              i = expr.length() + 1;
          }else if(expr.charAt(i)=='*' && soma<=0 && sub <=0){
            mult = mult - 1;
            result = "(" + imprimirArvore(expr.substring(i+1)) + "*" + imprimirArvore(expr.substring(0,i)) + ")";
            i = expr.length() + 1;
          }
        }
      }
    }
    return result;
  }
}
class ExprLogica implements Expression {
  public String avaliar(String expr){
    ExprAritmetica aux = new ExprAritmetica();
    String result = "";
    for(int i=0; i<expr.length(); i++){

      if(expr.charAt(i)=='>'){
        if(expr.charAt(i+1)=='='){
          double a = Double.valueOf(aux.avaliar(expr.substring(0,i+1))).doubleValue();
          double b = Double.valueOf(aux.avaliar(expr.substring(i+2))).doubleValue();
          if(a>=b){
            result = "False";
            break;
          }else{
            result = "False";
            break;
          }
        }else{
          double a = Double.valueOf(aux.avaliar(expr.substring(0,i))).doubleValue();
          double b = Double.valueOf(aux.avaliar(expr.substring(i+1))).doubleValue();
          if(a>b){
            result = "False";
            break;
          }else{
            result = "True";
            break;
          }
        }
      }else if(expr.charAt(i) == '<'){
        if(expr.charAt(i+1)=='='){
          double a = Double.valueOf(aux.avaliar(expr.substring(0,i+1))).doubleValue();
        double b = Double.valueOf(aux.avaliar(expr.substring(i+2))).doubleValue();
          if(a<=b){
            result = "False";
            break;
          }else{
            result = "True";
            break;
          }
        }else{
          double a = Double.valueOf(aux.avaliar(expr.substring(0,i))).doubleValue();
          double b = Double.valueOf(aux.avaliar(expr.substring(i+1))).doubleValue();
          if(a<b){
            result = "False";
            break;
          }else{
            result = "True";
            break;
          }
        }
      }else if(expr.charAt(i) == '='){
        double a = Double.valueOf(aux.avaliar(expr.substring(0,i+1))).doubleValue();
        double b = Double.valueOf(aux.avaliar(expr.substring(i+2))).doubleValue();
        if(a==b){
          result = "False";
          break;
        }else{
          result = "True";
          break;
        }
      }else if(expr.charAt(i)=='!'){
        double a = Double.valueOf(aux.avaliar(expr.substring(0,i+1))).doubleValue();
        double b = Double.valueOf(aux.avaliar(expr.substring(i+2))).doubleValue();
        if(a!=b){
          result = "False";
          break;
        }else{
          result = "True";
          break;
        }
      }
    }
  return result;
  }
  public String imprimirArvore(String expr){
    ExprAritmetica aux = new ExprAritmetica();
    String ret = "";
    for(int i=0; i<expr.length(); i++){
      if(expr.charAt(i)=='='){
        if(expr.charAt(i+1)=='='){
          String inv1 = new StringBuilder(expr.substring(0,i+1)).reverse().toString();
          String inv2 = new StringBuilder(expr.substring(i+2)).reverse().toString();
          String a = aux.imprimirArvore(inv1);
          String b = aux.imprimirArvore(inv2);
          ret = a + "==" + b;
          break;
        }else if(expr.charAt(i) == '>'){
          String inv1 = new StringBuilder(expr.substring(0,i+1)).reverse().toString();
          String inv2 = new StringBuilder(expr.substring(i+2)).reverse().toString();
          String a = aux.imprimirArvore(inv1);
          String b = aux.imprimirArvore(inv2);
          ret = a + ">=" + b;
          break;
        }else if(expr.charAt(i) == '<'){
          String inv1 = new StringBuilder(expr.substring(0,i+1)).reverse().toString();
          String inv2 = new StringBuilder(expr.substring(i+2)).reverse().toString();
          String a = aux.imprimirArvore(inv1);
          String b = aux.imprimirArvore(inv2);
          ret = a + "<=" + b;
          break;
        }else if(expr.charAt(i)=='!'){
          String inv1 = new StringBuilder(expr.substring(0,i+1)).reverse().toString();
          String inv2 = new StringBuilder(expr.substring(i+2)).reverse().toString();
          String a = aux.imprimirArvore(inv1);
          String b = aux.imprimirArvore(inv2);
          ret = a + "!=" + b;
          break;
        }
      }else if(expr.charAt(i) == '>'){
        String inv1 = new StringBuilder(expr.substring(0,i)).reverse().toString();
        String inv2 = new StringBuilder(expr.substring(i+1)).reverse().toString();
        String a = aux.imprimirArvore(inv1);
        String b = aux.imprimirArvore(inv2);
        ret = a + ">" + b;
        break;
      }else if(expr.charAt(i)=='<'){
        String inv1 = new StringBuilder(expr.substring(0,i)).reverse().toString();
        String inv2 = new StringBuilder(expr.substring(i+1)).reverse().toString();
        String a = aux.imprimirArvore(inv1);
        String b = aux.imprimirArvore(inv2);
        ret = a + "<" + b;
        break;
      }
    }
    ret = "(" + ret + ")";
    return ret;
  }
}
class Main {
  public static void main(String[] args) {

    System.out.println("Digite a entrada");
    Scanner entrada = new Scanner(System.in);
    String str = entrada.nextLine();
    entrada.close();
    Main func = new Main();
    String tipo = func.avaliaExp(str);

    if(tipo=="arit"){
      ExprAritmetica exp = new ExprAritmetica();
      String entr = new StringBuilder(str).reverse().toString();
      System.out.println(exp.avaliar(entr));
      System.out.println(exp.imprimirArvore(entr));
    }else{
      ExprLogica exp = new ExprLogica();
      String entr = new StringBuilder(str).reverse().toString();
      System.out.println(exp.avaliar(entr));
      System.out.println(exp.imprimirArvore(str));
    }
  }
  public String avaliaExp(String str){
    String tipo = "arit";

    for(int i=0; i<str.length(); i++){
      if(str.charAt(i)=='<' || str.charAt(i)=='>' || str.charAt(i)=='!' || str.charAt(i)=='='){
        tipo = "logic";
        break;
      }
    }
    return tipo;
  }
}
