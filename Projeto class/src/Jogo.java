
import javax.swing.JOptionPane;

public class Jogo {

    int Acerto, Erro;
    int cont = 0;
    String digito;
    int digiton;
    String Corretos = "";
    String digitoString;

    public int Chances(int chances) {
        if (chances < 0 || chances > 20) {
            JOptionPane.showMessageDialog(null, "Valor Invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return -2;
        } else if (chances > 0) {
            JOptionPane.showMessageDialog(null, String.format("Você tem %d chances", chances), "CHANCES !!!",
                    JOptionPane.INFORMATION_MESSAGE);
            return chances;

        }
        JOptionPane.showMessageDialog(null, "Você tem chances Ilimitadas", "CHANCES !!!",
                JOptionPane.INFORMATION_MESSAGE);
        return -1;
    }

    public int GerarCodigo(int cod, int qtd) {

        if (qtd == 4) {
            cod = (int) Math.round(Math.random() * 9999);
            digito = Integer.toString(cod);
            digiton = 4;
            return cod;
        } else if (qtd == 5) {
            cod = (int) Math.round(Math.random() * 99999);
            digito = Integer.toString(cod);
            digiton = 5;
            ;
            return cod;
        } else if (qtd == 6) {
            cod = (int) Math.round(Math.random() * 999999);
            digiton = 6;
            return cod;
        } else {
            JOptionPane.showMessageDialog(null, "Valor Inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return 1;
        }

    }

    public int[] GuardarCodigo(int[] aleatorio, int cod) {

        for (int i = digiton - 1; i >= 0; i--) {
            aleatorio[i] = cod % 10;
            cod = (cod - aleatorio[i]) / 10;

        }

        return aleatorio;
    }

    public boolean VerificarDigitos(String digitoString) {

        if (digitoString.length() < digiton) {

            JOptionPane.showMessageDialog(null, String.format("Você digitou menos de %d digitos", digiton), "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (digitoString.length() > digiton) {

            JOptionPane.showMessageDialog(null, String.format("Você digitou mais de %d digitos", digiton), "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;

    }

    public int[] GuardarDigito(int[] digitada, int digito, String digitoString) {
        cont++;
        for (int i = digiton - 1; i >= 0; i--) {
            digitada[i] = digito % 10;
            digito = (digito - digitada[i]) / 10;

        }
        return digitada;

    }

    public String[] acertos(int[] aleatorio, int[] digitada, String[] acertos) {
        Acerto = 0;
        Erro = 0;
        Corretos = "";
        for (int i = 0; i < digiton; i++) {
            if (aleatorio[i] == digitada[i]) {
                acertos[i] = "✔️  ";
                Corretos += "✔️  ";
                Acerto++;
            } else {
                acertos[i] = "❌  ";
                Corretos += "❌  ";
                Erro++;
            }

        }
        return acertos;
    }

    public void print(int[] digitada, String[] acertos, int chances) {
        for (int i = 0; i < digiton; i++) {
            JOptionPane.showMessageDialog(null, String.format("%d está %s", digitada[i], acertos[i]));

        }
        if (Acerto == digiton) {
            JOptionPane.showMessageDialog(null, "Voce Ganhou");
        } else if (cont == chances) {
            JOptionPane.showMessageDialog(null, "Acabou suas chances", "Perdeu", JOptionPane.INFORMATION_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Tente novamente, voce ainda tem  " + (chances - cont) + "  Chances !");
        }
    }
}
