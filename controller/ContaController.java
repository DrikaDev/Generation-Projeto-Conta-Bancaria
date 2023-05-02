package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("A conta número: " + numero + " não foi encontrada!");
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
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else
			System.out.println("A conta numero: " + conta.getNumero() + " não foi encontrada!");
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("A conta numero: " + numero + " foi deletada com sucesso!");
		}else
			System.out.println("A conta numero: " + numero + " não foi encontrada!");
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if( conta != null ) {
			if (conta.sacar(valor) == true)
				System.out.println("O saque na conta número: " + numero + " foi efetuado com sucesso!");
		}else
			System.out.println("A conta numero: " + numero + " não foi encontrada.");
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("O depósito na conta número: " + numero + " foi efetuado com sucesso!");
		}else
			System.out.println("A conta numero: " + numero + "não foi encontrada ou a Conta destino não é uma Conta corrente!");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("A transferência foi efetuada com sucesso!");
			}
		}else
			System.out.println("A conta de Origem e/ou Destino não foram encontradas!");
	}

	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
	public int retornaTipo(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}
	
	
	
}
