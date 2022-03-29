public class PilhaComFilas implements Empilhavel {

	private FilaEstaticaCircular f1;
	private FilaEstaticaCircular f2;

	public PilhaComFilas() {
		this(10);
	}

	public PilhaComFilas(int tamanho) {
		f1 = new FilaEstaticaCircular(tamanho);
		f2 = new FilaEstaticaCircular(tamanho);
	}

	public void empilhar(Object elemento) {
		while (f2.estaVazia() != true)
			f1.enfileirar(f2.desenfileirar());
		f1.enfileirar(elemento);
	}

	public Object desempilhar() {
		Object dado_desempilado = null;
		// Move para f2 e armazena quem está no topo
		while (f1.estaVazia() != true) {
			dado_desempilado = f1.desenfileirar();
			f2.enfileirar(dado_desempilado);
		}
		// Devolve todos para f1, menos o topo
		while (f2.estaVazia() != true) {
			Object novo_dado_desempilado = f2.desenfileirar();
			if (dado_desempilado != novo_dado_desempilado)
				f1.enfileirar(novo_dado_desempilado);
		}
		return dado_desempilado;
	}

	public Object espiar() {
		Object e = null;
		// Move para f2 e "espia" o topo
		while (f1.estaVazia() != true) {
			e = f1.desenfileirar();
			f2.enfileirar(e);
		}
		// Devolve os elementos para f1
		while (f2.estaVazia() != true) {
			f1.enfileirar(f2.desenfileirar());
		}
		return e;
	}

	public boolean estaCheia() {
		return (f1.estaCheia() || f2.estaCheia());
	}

	public boolean estaVazia() {
		return (f1.estaVazia() && f2.estaVazia());
	}

	public String imprimir() {
		Object topo = this.espiar();
		String impressao = "]";
		// Move para f2 enquanto monta a string
		while (f1.estaVazia() != true) {
			Object auxiliar = f1.desenfileirar();
			impressao = auxiliar + impressao;
			//
			if (auxiliar != topo) {
				impressao = "," + impressao;
			}
			//
			f2.enfileirar(auxiliar);
		}
		// Devolve os elementos para f1
		while (f2.estaVazia() != true) {
			f1.enfileirar(f2.desenfileirar());
		}

		return "[" + impressao;
	}

}
