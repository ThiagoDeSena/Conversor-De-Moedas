package Main;

import Models.ConsumoDaApi;
import Models.ConversaoDeValores;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ConsumoDaApi consumoDaApi = new ConsumoDaApi();
        consumoDaApi.comunicacaoApi();

        String menu = "****************************************\n"+
                "Seja Bem vindo ao Conversor de Moedas =)\n\n"+
                "1) Dólar =>> Peso Argentino\n" +
                "2) Peso Argentino =>> Dólar\n" +
                "3) Dólar =>> Real Brasileiro\n" +
                "4) Real Brasileiro =>> Dólar\n" +
                "5) Dólar =>> Peso Colombiano\n" +
                "6) Peso Colombiano =>> Dólar\n" +
                "7) Sair\n" +
                "Escolha uma opção válida:\n" +
                "****************************************\n\n";

        int resposta = 0;

        do {
            System.out.println(menu);
            resposta = scan.nextInt();

            double valor = 0;
            if (!(resposta==7)){
                System.out.print("Digite o valor que deseja converter:");
                 valor = scan.nextDouble();
            }

            switch (resposta){
                case 1:
                    consumoDaApi.usdParaArs(valor);
                    break;
                case 2:
                    consumoDaApi.arsParaUsd(valor);
                    break;
                case 3:
                    consumoDaApi.usdParaBrl(valor);
                    break;
                case 4:
                    consumoDaApi.brlParaUsd(valor);
                    break;
                case 5:
                    consumoDaApi.usdParaCop(valor);
                    break;
                case 6:
                    consumoDaApi.copParaUsd(valor);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Valor inválido! Digite um valor válido");
            }

        }while (!(resposta==7));

        System.out.println("Fim do programa!");
    }
}