package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    /*Não há atributos na classe TicketMachine de acordo com a documentação*/
    protected int precoDoBilhete;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int precoDoBilhete) {
        this.precoDoBilhete = precoDoBilhete;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) { /*Nessa condição está sendo utilizado um valor fixo na lista papelMoeda*/
                achou = true;               /*Porém deveria ser utilizado a variavel i, que é o iterador */
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        return null;
    }

    /*Em nenhum ponto da documentação é definido o que essa função deveria imprimir*/
    /*Devido a isso é difícil dizer o que exatamente está errado*/
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < precoDoBilhete) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
