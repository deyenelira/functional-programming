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
        double a = Double.valueOf(aux.avaliar(expr.substring(0,i))).doubleValue();
        double b = Double.valueOf(aux.avaliar(expr.substring(i+2))).doubleValue();
        if(a==b){
          result = "False";
          break;
        }else{
          result = "True";
          break;
        }
      }else if(expr.charAt(i)=='!'){
        double a = Double.valueOf(aux.avaliar(expr.substring(0,i))).doubleValue();
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
class ExprTernaria implements Expression {
  public String avaliar(String expr){
    //String expr = exprLogica ? ExprQualquer : ExprQualquer
    String ret = "";
    for(int i=0; i<expr.length(); i++){
      if(expr.charAt(i)=='?'){
        String expLogica = expr.substring(0,i);
        ExprLogica exp = new ExprLogica();
        String entr = new StringBuilder(expLogica).reverse().toString();
        String resp = exp.avaliar(entr);


        if(resp=="True"){
          for(int j=i; j<expr.length(); j++){
            if(expr.charAt(j)==':'){
              String p1 = expr.substring(i+1,j);
              String tipo = "arit";

              for(int k=0; k<p1.length(); k++){
                if(p1.charAt(k)=='<' || p1.charAt(k)=='>' || p1.charAt(k)=='!' || p1.charAt(k)=='='){
                  tipo = "logic";
                  break;
                }
              }
              if(tipo=="arit"){
                ExprAritmetica arit = new ExprAritmetica();
                String inv = new StringBuilder(p1).reverse().toString();
                ret = arit.avaliar(inv);
              }else{
                ExprLogica logic = new ExprLogica();
                String inv = new StringBuilder(p1).reverse().toString();
                ret = exp.avaliar(inv);
              }
            }
          }
        }else{
          for(int j=i; j<expr.length(); j++){
            if(expr.charAt(j)==':'){
              String p1 = expr.substring(j+1);
              String tipo = "arit";

              for(int k=0; k<p1.length(); k++){
                if(p1.charAt(k)=='<' || p1.charAt(k)=='>' || p1.charAt(k)=='!' || p1.charAt(k)=='='){
                  tipo = "logic";
                  break;
                }
              }
              if(tipo=="arit"){
                ExprAritmetica arit = new ExprAritmetica();
                String inv = new StringBuilder(p1).reverse().toString();
                ret = arit.avaliar(inv);
              }else{
                ExprLogica logic = new ExprLogica();
                String inv = new StringBuilder(p1).reverse().toString();
                ret = exp.avaliar(inv);
              }
            }
          }
        }
      }
    }
    return ret;
  }
  public String imprimirArvore(String expr){
    String ret = "";
    String fst = "";
    String snd = "";
    String trd = "";
    //exprLogica ? ExprQualquer : ExprQualquer
    for(int i=0; i<expr.length(); i++){
      if(expr.charAt(i)=='?'){
        fst = expr.substring(0, i);
        for(int j=0; j<expr.length(); j++){
          if(expr.charAt(j)==':'){
            snd = expr.substring(i+1, j);
            trd = expr.substring(j+1);
            i = expr.length() + 1;
            break;
          }
        }
      }
    }
    System.out.println(fst);
    System.out.println(snd);
    System.out.println(trd);
    ExprLogica logic = new ExprLogica();
    ExprAritmetica arit = new ExprAritmetica();

    String tipo = "arit";

    for(int i=0; i<snd.length(); i++){
      if(snd.charAt(i)=='<' || snd.charAt(i)=='>' || snd.charAt(i)=='!' || snd.charAt(i)=='='){
        tipo = "logic";
        break;
      }
    }
    if(tipo=="arit"){
      String inv = new StringBuilder(snd).reverse().toString();
      snd = arit.imprimirArvore(inv);
    }else{
      snd = arit.imprimirArvore(snd);
    }

    for(int i=0; i<trd.length(); i++){
      if(trd.charAt(i)=='<' || trd.charAt(i)=='>' || trd.charAt(i)=='!' || trd.charAt(i)=='='){
        tipo = "logic";
        break;
      }
    }
    if(tipo=="arit"){
      String inv = new StringBuilder(trd).reverse().toString();
      trd = arit.imprimirArvore(inv);
    }else{
      trd = arit.imprimirArvore(trd);
    }
    fst = arit.imprimirArvore(fst);
    String resp = fst + '?' + snd + ':' + trd;
    return resp;
  }
}
class Main {
  public static void main(String[] args) {
    //(((2)*(3))+((4)/(6)))!=((3)/(4))?((96)+((45)*(3))):((((26)*(7))*((6)/(4)))+(3))
    String ent = "2*3+4/6!=3/4?96+45*3:26*7*6/4+3";
    ExprTernaria a = new ExprTernaria();
    System.out.println(a.imprimirArvore(ent));
  }
  
}
