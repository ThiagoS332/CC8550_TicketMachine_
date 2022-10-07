package br.calebe.ticketmachine.tests;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class TicketMachine_Test {

    TicketMachine t = new TicketMachine(4);

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void TicketMachineConstructor_Test(){
        int valor_bilhete = 8;

        TicketMachine ticket_machine = new TicketMachine(valor_bilhete);

        Assert.assertEquals(0, ticket_machine.getSaldo());

    }

    @Test
    public void setSaldo_and_getSaldo_Test() {
        // Arrange
        final int expected = 25;
        final int novo_saldo = 25;
    
        // Act
        t.setSaldo(novo_saldo);
        final int actual = t.getSaldo();
    
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inserir_2_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 20;
        final int novo_saldo = 20;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_5_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 20;
        final int novo_saldo = 20;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_10_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 20;
        final int novo_saldo = 20;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_20_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 20;
        final int novo_saldo = 20;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_50_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 50;
        final int novo_saldo = 50;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_100_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 100;
        final int novo_saldo = 100;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_200_Test() throws PapelMoedaInvalidaException {
        // Arrange
        final int expected = 200;
        final int novo_saldo = 200;
    
        // Act
        t.inserir(novo_saldo);
    
        // Assert
        Assert.assertEquals(expected, t.getSaldo());
    }

    @Test
    public void inserir_14_Test() throws PapelMoedaInvalidaException {
            // Arrange
            final int novo_saldo = 14;
        
            // Act
            try {
                t.inserir(novo_saldo);
            } catch (Exception e){
                Assert.assertEquals(PapelMoedaInvalidaException.class, e.getClass());
            }
    }

    @Test
    public void inserir_8_Test() throws PapelMoedaInvalidaException {
            // Arrange
            final int novo_saldo = 8;
        
            // Act
            try {
                t.inserir(novo_saldo);
            } catch (Exception e){
                Assert.assertEquals(PapelMoedaInvalidaException.class, e.getClass());
            }

    }

    public void imprimir_valido_Test() throws SaldoInsuficienteException {
        // Arrange
        String expected = "*****************\n";
        expected += "*** R$ 100,00 ****\n";
        expected += "*****************\n";
        final int novo_saldo = 100;

        // Act
        t.setSaldo(novo_saldo);
        final String actual = t.imprimir();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    public void imprimir_invalido_Test() throws PapelMoedaInvalidaException  {
        // Arrange
        final int valor_inserir = 100;

        // Act
        t.inserir(valor_inserir);
        try{
            t.imprimir();
        } catch (Exception e){
            Assert.assertEquals(SaldoInsuficienteException.class, e.getClass());
        }
        

        
        
    }
}
