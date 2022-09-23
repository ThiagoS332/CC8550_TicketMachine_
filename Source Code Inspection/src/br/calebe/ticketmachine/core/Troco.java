package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
/*Falta de definição deescopo para a classe*/
public class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        /*Os loops para definir o count são infinitos, pois a condição de encerramento nunca é atendida*/
        /*O valor da variável valor se mantém o mesmo durante toda a execução*/
        papeisMoeda = new PapelMoeda[6];

        int count = 0;
        /*Loop sem condição de saída*/
        while (valor / 100 >= 1) {
            count++;
            valor = valor - 100;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);

        count = 0;
        /*Loop sem condição de saída*/
        while (valor / 50 >= 1) {
            count++;
            valor = valor - 50;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);

        count = 0;
        /*Loop sem condição de saída*/
        while (valor / 20 >= 1) {
            count++;
            valor = valor - 20;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);

        count = 0;
        /*Loop sem condição de saída*/
        while (valor / 10 >= 1) {
            count++;
            valor = valor - 10;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);

        count = 0;
        /*Loop sem condição de saída*/
        while (valor / 5 >= 1) {
            count++;
            valor = valor - 5;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        
        count = 0;
        /*Loop sem condição de saída*/
        while (valor % 2 != 0) {
            count++;
        }
        /*Sobrescreve o index do PapelMoeda de valor 5*/
        papeisMoeda[1] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
