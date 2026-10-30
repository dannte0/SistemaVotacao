package metodos;
import javax.swing.JOptionPane;

import entidades.Candidato;
import entidades.Votacao;

public class Procedimentos 
{
	public void quantidadeEleitoresSecao(Votacao[] v)
	{
		String mensagem = "";
		for(int x = 0; x < v.length; x++)
		{
			for(int y = 0; y < v[x].secao.length; y++)
			{
				if(y == x)
				{
					mensagem += "Numero da Secao: "+ x +" | Quantidade de votos: "+ v[x].secao[y].quantidadeVotos + "\n";
					break;
				}
			}
		}
		JOptionPane.showMessageDialog(null, mensagem);
		System.out.println(mensagem);
	}
	
	public void maiorMenorSecao(Votacao[] v)
	{
		int maisVotos = 0, menosVotos = 0, 
		maior = v[0].secao[0].quantidadeVotos, 
		menor = v[0].secao[0].quantidadeVotos;
		
		for(int x = 0; x < v.length;)
		{
			for(int y = 0; y < v[x].secao.length; y++)
			{
				if(v[x].secao[y].quantidadeVotos > maior)
				{
					maisVotos = y;
					maior = v[x].secao[y].quantidadeVotos;
					
				}
				else if(v[x].secao[y].quantidadeVotos < menor)
				{
					menosVotos = y;
					menor = v[x].secao[y].quantidadeVotos;
				}
			}
			break;
		}
		JOptionPane.showMessageDialog(null, "Seção com a maior quantidade de votos: " + maisVotos + 
											"\nSeção com a menor quantidade de votos: "+ menosVotos);
	}
	
	public void quantidadeEleitoresCandidato(Votacao[] v)
	{
		for(int x = 0; x < v.length;)
		{
			for(int y = 0; y < v[x].candidato.length; y++)
			{
				System.out.println(y + 1 +": Numero do Candidato: "+ y +" | Quantidade de votos: "+ v[x].candidato[y].quantidadeVotos) ;
			}
			break;
		}
	}
	
	public void top10Candidatos(Votacao[] v)
	{
		Candidato[] c = new Candidato[300];
		Candidato[] aux = new Candidato[1];
		//Copia vetor de candidatos
		for(int x = 0; x < v.length;)
		{
			for(int y = 0; y < v[x].candidato.length; y++)
			{
				c[y] = new Candidato();
				c[y] = v[x].candidato[y];
			}
			break;
		}
		//Bubble sort

		for(int y = 0; y < c.length; y++)
		{
			for(int z = y; z < c.length; z++)
			{							
				if(c[y].quantidadeVotos > c[z].quantidadeVotos)
				{
					aux[0] = c[y];
					c[y] = c[z];
					c[z] = aux[0];
				}
			}
		}
		String mensagem = "";
		//Exibe os 10 mais votados
		for(int i = 299; i >= 290; i--)
		{
			mensagem += "Candidato: "+ c[i].numero +" | Qtd votos: "+ c[i].quantidadeVotos+ "\n";
		}
		
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
