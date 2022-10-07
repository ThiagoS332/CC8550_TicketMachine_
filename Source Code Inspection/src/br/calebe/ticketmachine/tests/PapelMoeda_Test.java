package br.calebe.ticketmachine.tests;

import br.calebe.ticketmachine.core.PapelMoeda;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class PapelMoeda_Test {

    private PapelMoeda p = new PapelMoeda(50, 6);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void getValor_Test() {
      // Arrange
      final int expected = 50;
  
      // Act
      final int actual = p.getValor();
  
      // Assert
      Assert.assertEquals(expected, actual);
    }    
    @Test
    public void getQuantidade_Test() {
      // Arrange
      final int expected = 6;
  
      // Act
      final int actual = p.getQuantidade();
  
      // Assert
      Assert.assertEquals(expected, actual);
    }        
}