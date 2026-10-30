package metodos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import entidades.Candidato;
import entidades.Secao;
import entidades.Votacao;


public class Funcoes
{
	public Votacao[] fCadastraVotacao(Votacao[] v)
	{
		Random r = new Random();
		
		//Laço para Candidato
		Candidato[] candidato = new Candidato[300];
		for(int x = 0; x < 300; x++)
		{
			candidato[x] = new Candidato();
			candidato[x].numero = x;			
		}
		//Laço para Seção
		Secao[] secao = new Secao[10];
		for(int y = 0; y < 10; y++)
		{
			secao[y] = new Secao();
			secao[y].numero = y;				
		}
		//Laço para Votação
		for(int z = 0; z < 200; z++)
		{
			v[z] = new Votacao();
			v[z].numeroSecao = r.nextInt(10);
			v[z].numeroCandidato = r.nextInt(300);
			for(int y = 0; y < 10; y++)
			{				
				if(v[z].numeroSecao == secao[y].numero)
				{				
					secao[y].quantidadeVotos++;
				}
			}
			for(int x = 0; x < 300; x++)
			{
				if(v[z].numeroCandidato == candidato[x].numero)
				{				
					candidato[x].quantidadeVotos++;
				}				
			}
		}
		
		for(int i = 0; i < v.length; i ++)
		{
			v[i].secao = secao;
			v[i].candidato = candidato;
		}
		
		System.out.println("Votos registrados com sucesso!");
		return v;
	}
	
	public Votacao[] fClassificaSecao(Votacao[] v)
	{
		Votacao[] aux = new Votacao[1];
		for(int i = 0; i < v.length; i++)
		{
			for(int j = i; j < v.length; j++)
			{
				if(v[i].numeroSecao > v[j].numeroSecao)
				{
					aux[0] = v[i];
					v[i] = v[j];
					v[j] = aux[0];
				}
			}
		}
		System.out.println("Dados classificados");
		return v;
	}
	
	public Votacao[] fGravaVotacao(Votacao[] v) throws IOException
	{
		String fileName = "Votação2026.txt";
		BufferedWriter gravar = new BufferedWriter( new FileWriter(fileName ));
		for(int i = 0; i < 200; i++)
		{
			gravar.write("Seção:" + Integer.toString(v[i].numeroSecao) + " ");
			gravar.write("Candidato: "+ Integer.toString(v[i].numeroCandidato));
			gravar.newLine();
		}
		System.out.println("Arquivo gerado!");
		gravar.close();
		return v;
	}
	
	
}
