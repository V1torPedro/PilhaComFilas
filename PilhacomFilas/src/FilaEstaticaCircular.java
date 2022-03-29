public class FilaEstaticaCircular implements Enfileiravel {

  private int ponteiroInicio;
  private int ponteiroFim;
  private Object[] dados;
  private int quantidade;

  public FilaEstaticaCircular() {
    this(10);
  }

  public FilaEstaticaCircular(int tamanho) {
    quantidade = 0;
    ponteiroInicio = 0;
    ponteiroFim = -1;
    dados = new Object[tamanho];
  }

  // enqueue
  public void enfileirar(Object dado) {
    if (!estaCheia()) {
      ponteiroFim++;
      ///// patch

      if (ponteiroFim == dados.length)
        ponteiroFim = 0;

      quantidade++;
      ////
      dados[ponteiroFim] = dado;
    } else {
      System.err.println("Fila Cheia!");
    }
  }

  // dequeue
  public Object desenfileirar() {
    Object auxiliar = null;
    if (!estaVazia()) {
      auxiliar = dados[ponteiroInicio];
      ponteiroInicio++;
      //// patch
      if (ponteiroInicio == dados.length)
        ponteiroInicio = 0;

      quantidade--;
      ////
    } else {
      System.err.println("Fila Vazia!");
    }
    return auxiliar;
  }

  // peek
  public Object espiar() {
    Object auxiliar = null;
    if (!estaVazia()) {
      auxiliar = dados[ponteiroInicio];
    } else {
      System.err.println("Fila Vazia!");
    }
    return auxiliar;
  }

  // isFull
  public boolean estaCheia() {
    return (quantidade == dados.length);
  }

  // isEmpty
  public boolean estaVazia() {
    return (quantidade == 0);
  }

  // print
  public String imprimir() {
    String resultado = "[";
    int ponteiroAux = ponteiroInicio;
    for (int i = 0; i < quantidade; i++, ponteiroAux++) {
      ////// patch
      if (ponteiroAux == dados.length)
        ponteiroAux = 0;

      ///////
      resultado += dados[ponteiroAux];
      if (ponteiroAux != ponteiroFim)
        resultado += ",";
    }
    return resultado + "]";
  }

}
