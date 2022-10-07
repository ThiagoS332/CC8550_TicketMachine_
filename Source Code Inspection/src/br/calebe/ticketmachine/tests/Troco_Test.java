package br.calebe.ticketmachine.tests;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.Troco;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Troco_Test {
    Troco t = new Troco(384);

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void TrocoConstructor_Test(){
        int valor_troco = 395;

        Troco troco = new Troco(valor_troco);

        var iterator = troco.getIterator();

        ArrayList<Integer> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            PapelMoeda papelMoeda = iterator.next();
            actual.add(papelMoeda.getQuantidade());
        }

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1); // 1 * 200 = 200
        expected.add(1); // 1 * 100 = 100
        expected.add(1); // 1 * 50 = 50
        expected.add(2); // 2 * 20 = 40
        expected.add(0); // 0 * 10 = 0
        expected.add(1); // 1 * 5 = 5
        expected.add(0); // 0 * 2 = 0
        // 200 +100 + 50 + 40 + 5 = 395

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void TrocoRemover_Test() {
        var iterator = t.getIterator();

        ArrayList<Integer> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            PapelMoeda papelMoeda = iterator.next();
            actual.add(papelMoeda.getQuantidade());
            iterator.remove();
        }

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(0);
        expected.add(2); 


        Assert.assertEquals(expected, actual);
        Assert.assertEquals(iterator.hasNext(), false);

        try {
            iterator.next();
        } catch (Exception e){
            Assert.assertEquals(e.getClass(), ArrayIndexOutOfBoundsException.class);}
    }

}
