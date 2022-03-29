public interface Empilhavel {
  void empilhar(Object elemento);

  Object desempilhar();

  Object espiar(); // Topo

  boolean estaCheia();

  boolean estaVazia();

  String imprimir();
}
