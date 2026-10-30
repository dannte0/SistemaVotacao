package entidades;

public class Secao 
{
	public int numero;
	public int quantidadeVotos;
	
	public Secao()
	{
		this(0,0);
	}
	
	public Secao(int num, int qtdVotos)
	{
		this.numero = num;
		this.quantidadeVotos = qtdVotos;
	}
}
