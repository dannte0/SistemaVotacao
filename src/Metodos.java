import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Metodos
{
	public Votacao[] fCadastraVotacao(Votacao[] v)
	{
		Random r = new Random();
		//Laço para Candidato
		Candidato[] candidato = new Candidato[301];
		for(int i = 0; i < 300; i++)
		{
			candidato[i] = new Candidato();
			candidato[i].numero = r.nextInt(300);
			candidato[i].quantidadeVotos++;
		}
		//Laço para Seção
		Secao[] secao = new Secao[11];
		for(int i = 0; i < 10; i++)
		{
			secao[i] = new Secao();
			secao[i].numero = r.nextInt(10);
			secao[i].quantidadeVotos++;
		}
		//Laço para Votação
		for(int i = 0; i < 200; i++)
		{
			v[i] = new Votacao();
			v[i].numeroSecao = secao[i].numero;
			v[i].numeroCandidato = candidato[i].numero;
		}
		return v;
	}
	public Secao[] fClassificaSecao(Secao[] secao)
	{
		int aux = 0;
		for(int i = 0; i < secao.length; i++)
		{
			for(int j = i; j < secao.length; j++)
			{
				if(secao[i].quantidadeVotos > secao[j].quantidadeVotos)
				{
					aux = secao[i].quantidadeVotos;
					secao[i].quantidadeVotos = secao[j].quantidadeVotos;
					secao[j].quantidadeVotos = aux;
				}
			}
		}
		return secao;
	}
	
	public Votacao[] fGravaVotacao(Votacao[] v) throws IOException
	{
		String fileName = "Votação2026.txt";
		BufferedWriter gravar = new BufferedWriter( new FileWriter(fileName ));
		for(int i = 0; i < 200; i++)
		{
			gravar.write(v[i].numeroSecao + " ");
			gravar.write(v[i].numeroCandidato);
			gravar.newLine();
		}
		System.out.println("Arquivo gerado!");
		gravar.close();
		return v;
	}
}
