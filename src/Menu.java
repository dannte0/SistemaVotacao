import java.io.IOException;

import javax.swing.JOptionPane;

import entidades.Votacao;
import metodos.Funcoes;
import metodos.Procedimentos;

public final class Menu
{
	private Menu(){}
	
	public static void menuPrincipal() throws IOException
	{
		  int opc=0;
		  Votacao[] votacao = new Votacao[200];
		  Funcoes metodo = new Funcoes();
	      while(opc!=9)
	      {
	          opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Carregar Seção/Número Candidato\n2 - Classificar por Seção\n3 – Gravar Registros\n4 – Mostrar Indicadores\n9 - Finalizar"));
			  switch (opc) 
			  {
                case 1 : votacao = metodo.fCadastraVotacao(votacao);
                        break;
                case 2 : votacao = metodo.fClassificaSecao(votacao);
                       	break;
                case 3 : votacao = metodo.fGravaVotacao(votacao);
                		break;
                case 4 : menuIndicadores(votacao);
                		break;
                case 9 : JOptionPane.showMessageDialog(null,"FINALIZADO");
                        break;
               default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
			  } 
	      }  
	}
	
	public static void menuIndicadores(Votacao[] v)
	{
		int opc = 0;
		Procedimentos metodo = new Procedimentos();
		while(opc != 9)
		{
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Quantidade Eleitores por Seção\n2 – Seção com Maior e Menor número de Eleitores\n3 - Quantidade de votos por candidato \n4 – 10 primeiros colocadas (nro cand. e qtd votos)\n9 - Finaliza consulta"));
			  switch (opc) 
			  {
				case 1 : metodo.quantidadeEleitoresSecao(v);
				        break;
				case 2 : metodo.maiorMenorSecao(v);
				       	break;
				case 3 : metodo.quantidadeEleitoresCandidato(v);
						break;
				case 4 : metodo.top10Candidatos(v);
						break;
				case 9 : JOptionPane.showMessageDialog(null,"FINALIZADO");
				            break;
				   default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
			  } 
		}
	}
}
