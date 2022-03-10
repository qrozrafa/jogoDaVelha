package tictac;

public class TicTac {

    private String[][] matriz = new String[3][3];
    private int iniciante;
    private int jogadas = 0;

    public TicTac(int iniciante) {
        super();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = " ";
            }
        }
        this.iniciante = iniciante;
        if (iniciante == 1) {
            jogadaPC();
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%S | %S | %S\n",
                    matriz[i][0],
                    matriz[i][1],
                    matriz[i][2]);
            if (i != 2) {
                System.out.println("--------");
            }
        }
    }

    private void jogadaPC() {
        int jogadasRestantes = 9 - jogadas;
        int posicao = (int) (Math.random() * jogadasRestantes) + 1;
        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j].equals(" ")) {
                    contador++;
                    if (contador == posicao) {
                        matriz[i][j] = "X";
                        jogadas++;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean jogadaPlayer(int x, int y){
        if (x<0 || x>2 || y<0 || y>2) {
            return false;
        }
        if (matriz[x][y].equals(" ") == false) {
         return false;   
        }
        matriz[x][y] = "O";
        jogadas++;
        if (situacao() == 0) {
            jogadaPC();
        }
        return true;
    }
    
    public int situacao(){
//        0 - andamento
//        1 - velha
//        2 - jogador ganhou
//        3 - computador ganhou
        
        if ( (matriz[0][0].equals("O")&&
              matriz[0][1].equals("O")&&
              matriz[0][2].equals("O")) || 
             (matriz[1][0].equals("O")&&
              matriz[1][1].equals("O")&&
              matriz[1][2].equals("O")) ||
             (matriz[2][0].equals("O")&&
              matriz[2][1].equals("O")&&
              matriz[2][2].equals("O")) ||
             (matriz[0][0].equals("O")&&
              matriz[1][0].equals("O")&&
              matriz[2][0].equals("O")) ||
             (matriz[0][1].equals("O")&&
              matriz[1][1].equals("O")&&
              matriz[2][1].equals("O")) ||
             (matriz[0][2].equals("O")&&
              matriz[1][2].equals("O")&&
              matriz[2][2].equals("O")) ||
             (matriz[0][0].equals("O")&&
              matriz[1][1].equals("O")&&
              matriz[2][2].equals("O")) ||
             (matriz[0][2].equals("O")&&
              matriz[1][1].equals("O")&&
              matriz[2][0].equals("O"))  
            ) {
            return 2;
        }
        if ( (matriz[0][0].equals("X")&&
              matriz[0][1].equals("X")&&
              matriz[0][2].equals("X")) || 
             (matriz[1][0].equals("X")&&
              matriz[1][1].equals("X")&&
              matriz[1][2].equals("X")) ||
             (matriz[2][0].equals("X")&&
              matriz[2][1].equals("X")&&
              matriz[2][2].equals("X")) ||
             (matriz[0][0].equals("X")&&
              matriz[1][0].equals("X")&&
              matriz[2][0].equals("X")) ||
             (matriz[0][1].equals("X")&&
              matriz[1][1].equals("X")&&
              matriz[2][1].equals("X")) ||
             (matriz[0][2].equals("X")&&
              matriz[1][2].equals("X")&&
              matriz[2][2].equals("X")) ||
             (matriz[0][0].equals("X")&&
              matriz[1][1].equals("X")&&
              matriz[2][2].equals("X")) ||
             (matriz[0][2].equals("X")&&
              matriz[1][1].equals("X")&&
              matriz[2][0].equals("X"))  
            ) {
            return 3;
        }
        if (jogadas == 9) {
            return 1;
        }
        return 0;
    }
}
