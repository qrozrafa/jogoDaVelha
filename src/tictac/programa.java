
package tictac;

import java.util.Scanner;

public class programa {
    public static void main(String[]args){
        Scanner leitor = new Scanner(System.in);
        
        System.out.print("Quem inicia? 0 - Jogador/ 1 - Computador: ");
        int iniciante = leitor.nextInt();
        
        TicTac jogo = new TicTac(iniciante);
        
        while(jogo.situacao()== 0){
            jogo.print();
            
            System.out.println("Qual linha: ");
            int linha = leitor.nextInt();
            System.out.println("Qual coluna: ");
            int coluna = leitor.nextInt();
            if (jogo.jogadaPlayer(linha, coluna)== false) {
                System.out.println("Jogada invalida, tente novamente !!");
            }
            
        }
        jogo.print();
        int situacao = jogo.situacao();
        switch (situacao){
//        1 - velha
//        2 - jogador ganhou
//        3 - computador ganhou
            case 1:
                System.out.println("Velha");
                break;
            case 2:
                System.out.println("Voce ganhou, parabéns!!");
                break;
            case 3:
                System.out.println("Perdeu :/");
                break;
        }
               
    }
}
