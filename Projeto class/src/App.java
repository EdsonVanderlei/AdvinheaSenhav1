
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // variaveis
        Jogo c1 = new Jogo();
        String AleatorioString;
        int cod = 1;
        int digito;
        int qtd;
        int Acerto = 0;
        boolean erro = false;
        int chances;
        String Correto = "";
        String digitoString = "";
        Object[] dificuldade = {"Facil", "Normal", "Dificil"};
        ImageIcon dab = new ImageIcon("Projeto class/src/download.jpg");
        JOptionPane.showMessageDialog(null, "", "By Edson Vanderlei", JOptionPane.INFORMATION_MESSAGE, dab);

        do {
            chances = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Digite chances de 1 a 20  ou 0 para chances infinitas",
                            "CHANCES", JOptionPane.INFORMATION_MESSAGE));
            chances = c1.Chances(chances);
        } while (chances == -2);
            qtd = JOptionPane.showOptionDialog(null,"Selecione um nivel de dificuldade :","AdvinheaSenha",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificuldade,dificuldade[2]);
            cod = c1.GerarCodigo(cod, qtd);
            System.out.println(cod);
        AleatorioString = Integer.toString(cod);
        String[] acertos = new String[AleatorioString.length()];
        int[] digitada = new int[AleatorioString.length()];
        int[] aleatorio = new int[AleatorioString.length()];

        aleatorio = c1.GuardarCodigo(aleatorio, cod);

        int cont = 0;

        do {
            cont++;
            digitoString = JOptionPane.showInputDialog(null,
                    String.format("Digite uma senha : \n%s\n%s", digitoString, Correto), "Senha",
                    JOptionPane.INFORMATION_MESSAGE);
            erro = c1.VerificarDigitos(digitoString);

            if (erro == true) {
                cont--;
                continue;
            } else {
                digito = Integer.parseInt(digitoString);
                digitada = c1.GuardarDigito(digitada, digito, digitoString);

                acertos = c1.acertos(aleatorio, digitada, acertos);
                Acerto = c1.Acerto;
                Correto = c1.Corretos;

                System.out.println(Acerto);
                c1.print(digitada, acertos, chances);
                if (Acerto == AleatorioString.length()) {
                    break;
                }

            }
            if (cont == chances) {
                break;
            }

        } while (cont < chances);

    }
}
