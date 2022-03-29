public class teste {
  public static void main(String[] args) {
    Empilhavel pf = new PilhaComFilas(4);
    System.out.println("Vazia = " + pf.estaVazia());
    System.out.println("Cheia = " + pf.estaCheia());
    // ----
    pf.empilhar(1);
    pf.empilhar(2);
    pf.empilhar(3);
    pf.empilhar(4);
    System.out.println(pf.imprimir()); // [4,3,2,1]
    System.out.println(pf.desempilhar());
    System.out.println(pf.imprimir()); // [3,2,1]
    pf.empilhar(5);
    System.out.println(pf.espiar());
    System.out.println(pf.espiar());
    pf.desempilhar(); // [5,3,2,1] --> [3,2,1]
    pf.empilhar(6);
    System.out.println(pf.imprimir()); // ----Resultado = [6,3,2,1]

    System.out.println("Vazia = " + pf.estaVazia());
    System.out.println("Cheia = " + pf.estaCheia());
  }
}
