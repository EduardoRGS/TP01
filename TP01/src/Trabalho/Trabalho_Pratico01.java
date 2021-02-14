package Trabalho;

import java.util.Scanner;
public class Trabalho_Pratico01 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		int menu;
		int mes,ano,i,qtd_dias;
		float[] dia = new float [200];
		
		qtd_dias = 0;
	
		do{
			menu();
			System.out.println(" ");
			System.out.print("Digite uma opcao do menu: ");
			menu = in.nextInt();
		}while(menu <= 0 || menu >= 6);
			
		switch(menu) {
				case 1:
					System.out.println(" ");
					System.out.println("Entrada das Temperaturas ");
					mes = mes_incializazao();
					ano = ano_inicializacao();
					Entrada_das_temperaturas(qtd_dias,mes,ano,dia);
					break;
					
				case 2:
					System.out.println(" ");
					System.out.println("C�lculo da Temperatura M�dia: ");
					mes = mes_incializazao();
					ano = ano_inicializacao();
					C�lculo_da_temperatura_m�dia(qtd_dias,mes,ano,dia);
					break;
					
				case 3:
					System.out.println(" ");
					System.out.println("C�lculo da Temperatura M�nima: ");
					mes = mes_incializazao();
					ano = ano_inicializacao();
					C�lculo_da_temperatura_m�nima(qtd_dias,mes,ano,dia);
					break;
				case 4:
					System.out.println(" ");
					System.out.println("C�lculo da Temperatura M�xima: ");
					mes = mes_incializazao();
					ano = ano_inicializacao();
					C�lculo_da_temperatura_m�xima(qtd_dias,mes,ano,dia);
					break;
				case 5:
					System.out.println(" ");
					System.out.println("Relat�rio Meteorol�gico: ");
					System.out.println("Para gerar o Relatorio meteorol�gico");
					System.out.println("Informe o M�s e o Ano");
					mes = mes_incializazao();
					ano = ano_inicializacao();
					Entrada_das_temperaturas(qtd_dias,mes,ano,dia);
					Relat�rio_C�lculo_da_temperatura_m�dia(qtd_dias,mes,ano,dia);
					break;
			}
			
	}

static void menu () {
		System.out.println("-- Menu de Op��es --");
		System.out.println("1 - Entrada das Temperaturas: ");
		System.out.println("2 - C�lculo da Temperatura M�dia: ");
		System.out.println("3 - C�lculo da Temperatura M�nima: ");
		System.out.println("4 - C�lculo da Temperatura M�xima: ");
		System.out.println("5 - Relat�rio Meteorol�gico: ");
		System.out.println("Caso opc�es <= 0 ou op�oes > 5 o menu ir� se repetir");
	}
	public static int data_ano_beissexto (int mes,int ano,float dia[]){
		int qtd_dias;
		qtd_dias = 0;
		int i;
		dia[1] = 1;
		//Scanner ee = new Scanner (System.in);
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
            if(dia[1] == 1 && dia[1] <= 31) {
            	
                
                qtd_dias = 31;
            }else {
               
                System.out.println("Data Inv�lida");
            }
            
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if(dia[1] >= 1 && dia[1] <= 30) {
            	
            	
            	qtd_dias = 30;
            } else {
              
                System.out.println("Data Inv�lida");
            }
            
        } else if (mes == 2) {
            if(dia[1] <= 29){
            	 
                if((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)){
                	
                    
                     qtd_dias = 29;
                    
                    
                }else {
                	 qtd_dias = 28;
                   
                }
            }
       
        }
		 return qtd_dias;
	}
	static int mes_incializazao() {
		Scanner in = new Scanner (System.in);
		int meses;
		
		System.out.print("Digite o m�s: ");
		meses = in.nextInt();
		
		while(meses > 12 || meses < 0) {
			
			System.out.println("M�s Invalido,digite novamente.");
			System.out.print("Digite o m�s: ");
			meses = in.nextInt();
		}
		return meses;
	}
	static int ano_inicializacao() {
		Scanner in = new Scanner (System.in);
		int anos;
		
		System.out.print("Digite o ano: ");
		anos = in.nextInt();
		
		while(anos >= 2022 || anos < 0) {
			
			System.out.println("Ano Invalido,digite novamente");
			System.out.print("Digite o ano: ");
			anos = in.nextInt();
		}
		return anos;
	}
	static void Entrada_das_temperaturas(int qtd_dias,int mes, int ano, float dia[]) {
		
		qtd_dias = data_ano_beissexto(mes,ano,dia);
		
		Scanner in = new Scanner (System.in);
		
		float temp_dia,manha,tarde,noite,quant;
		int i;
		temp_dia = 0;
		quant = 0;
	
		for(i=0; i<qtd_dias; i++) {
			System.out.println("Digite a Temperatura do Dia " +(i+1)+ " do m�s "+mes);
			
			System.out.println("Temperatura de Manh�: ");
			manha = in.nextFloat();
			quant++;
			
			System.out.println("Temperatura de Tarde: ");
			tarde = in.nextFloat();
			quant++;
			
			System.out.println("Temperatura de Noite: ");
			noite = in.nextFloat();
			quant++;
			
			temp_dia = (manha + tarde + noite) / quant;
			
			System.out.println("Temperatura media do Dia "+(i+1)+ " - " +temp_dia+ "�C");
			quant= 0;
		}
		for(i=0; i<qtd_dias; i++) {
			dia[i] = 0;
		}
	
		
	}
	static void Relat�rio_C�lculo_da_temperatura_m�dia(int qtd_dias,int mes, int ano,float dia[]) {
		qtd_dias = data_ano_beissexto(mes,ano,dia);
		Scanner in = new Scanner (System.in);
		int i;
		float temp_media;
		float temp_dia,temp_maxima,temp_maxima_dia;
		float temp_minima_dia,temp_minima;
		temp_dia = 0;
		temp_maxima = 0;
		temp_maxima_dia = 0;
		temp_minima_dia = 0;
		temp_minima = 9999;
		
		temp_media = 0;
		for(i=0; i<qtd_dias; i++) {
			System.out.println("Digite a Temperatura do Dia " +(i+1)+ " do m�s "+mes);
			dia[i] = in.nextFloat();
			if(dia[i] > temp_maxima) {
				temp_maxima = dia[i];
				temp_maxima_dia = i;
			}
			if(dia[i] < temp_minima) {
				temp_minima = dia[i];
				temp_minima_dia = i;
			}
			
			temp_media = temp_media + dia[i];
		}
		temp_media = temp_media / qtd_dias;
		System.out.println("Temperatura M�dia: "+temp_media+ "�C");
		System.out.println("Temperatura Manima do M�s/ano: " +temp_maxima+ "�C - " +(temp_maxima_dia+1)+ "/" +mes+ "/" +ano);
		System.out.println("Temperatura M�nima do M�s/ano: " +temp_minima+ "�C - " +(temp_minima_dia+1)+ "/" +mes+ "/" +ano);
	}
	static void C�lculo_da_temperatura_m�nima(int qtd_dias,int mes, int ano,float dia[]) {
		Scanner in = new Scanner (System.in);
		int i,j,cont,mesmo_dia;
		float temp_minima_dia,temp_minima;
		float temp_repet_mini = 0;
		int[] dias = new int [31];
		temp_minima_dia = 0;
		temp_minima = 9999;
		
		j = 0;
		
		if(qtd_dias >= 0) {
			
			qtd_dias = data_ano_beissexto(mes,ano,dia);
			
			for(i=0; i<qtd_dias; i++) {
				System.out.println("Digite a Temperatura do Dia " +(i+1)+ " do m�s "+mes);
				j = i;
				dia[i] = in.nextFloat();
				
			
				if(dia[i] < temp_minima) {
					temp_minima = dia[i];
					temp_minima_dia = i;
					
					
					
					
				}
				if(temp_minima == dia[i]) {
						System.out.println("Data com a mesma Temperatura M�nima Dia "+(j+1)+ "/" +mes+ "/" +ano);
					
				}
				
				
				
			}
				
			System.out.println("Temperatura M�nima do M�s/ano: " +temp_minima+ "�C - " +(temp_minima_dia+1)+ "/" +mes+ "/" +ano);
			
		}
	}
	static void C�lculo_da_temperatura_m�xima(int qtd_dias,int mes, int ano,float dia[]) {
		Scanner in = new Scanner (System.in);
		int i,j;
		float temp_dia,temp_maxima,temp_maxima_dia;
	
		temp_dia = 0;
		temp_maxima = 0;
		temp_maxima_dia = 0;
		j = 0;
		
		if(qtd_dias >= 0) {
			qtd_dias = data_ano_beissexto(mes,ano,dia);
			for(i=0; i<qtd_dias; i++) {
				System.out.println("Digite a Temperatura do Dia " +(i+1)+ " do m�s "+mes);
				j = i;
				dia[i] = in.nextFloat();
				
				if(dia[i] > temp_maxima) {
					temp_maxima = dia[i];
					temp_maxima_dia = i;
				}
				if(temp_maxima == dia[i]) {
					System.out.println("Data com a mesma Temperatura Maxima Dia "+(j+1)+ "/" +mes+ "/" +ano);
				}
			
			}
				
			System.out.println("Temperatura Maxima do M�s/ano: " +temp_maxima+ "�C - " +(temp_maxima_dia+1)+ "/" +mes+ "/" +ano);
			
		}
	}
	static void C�lculo_da_temperatura_m�dia(int qtd_dias,int mes, int ano,float dia[]) {
		qtd_dias = data_ano_beissexto(mes,ano,dia);
		Scanner in = new Scanner (System.in);
		int i;
		float temp_media;
		temp_media = 0;
		for(i=0; i<qtd_dias; i++) {
			System.out.println("Digite a Temperatura do Dia " +(i+1)+ " do m�s "+mes);
			dia[i] = in.nextFloat();

			temp_media = temp_media + dia[i];
		}
		temp_media = temp_media / qtd_dias;
		System.out.println("Temperatura M�dia: "+temp_media+ "�C");
	}
}