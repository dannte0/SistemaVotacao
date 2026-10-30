package entidades;

public class Votacao 
{
	public int numeroSecao;
	public int numeroCandidato;
	public Secao[] secao;
	public Candidato[] candidato;
	
	public Votacao()
	{
		this(0, 0, null, null);
	}
	
	public Votacao(int numSec, int numCand, Secao[] s, Candidato[] c)
	{
		this.numeroSecao = numSec;
		this.numeroCandidato = numCand;
		this.secao = s;
		this.candidato = c;
	}
	
}
