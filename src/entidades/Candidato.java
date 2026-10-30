package entidades;

public class Candidato 
{
	public int numero;
	public int quantidadeVotos;
	
	public Candidato()
	{
		this(0, 0);
	}
	
	public Candidato(int num, int qtdVotos)
	{
		this.numero = num;
		this.quantidadeVotos = qtdVotos;
	}
	
}