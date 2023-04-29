package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		
	}

	@Override
	public void listarTodas() {
		//Através do Laço de Repetição for...each, percorremos toda a Collection listaContas.
		/*var: É uma palavra reservada do Java, que tem o objetivo de criar variáveis locais, 
		sem a definição do tipo. O tipo da variável é definido por inferência, ou seja, 
		a palavra reservada var define o tipo da variável através do valor de inicialização da variável.*/
		for (var conta: listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		
	}

	@Override
	public void deletar(int numero) {
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
	}

	public int gerarNumero() {
		return ++ numero;
	}
	
}
