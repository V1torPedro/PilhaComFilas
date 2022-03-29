public interface Enfileiravel {
  void enfileirar(Object elemento);

  Object desenfileirar();

  Object espiar(); // Topo

  boolean estaCheia();

  boolean estaVazia();

  String imprimir();
}