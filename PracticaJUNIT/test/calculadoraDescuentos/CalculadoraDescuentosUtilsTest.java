package calculadoraDescuentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class CalculadoraDescuentosUtilsTest {

    @Test
    public void testRopaConVipDescuento20() {
		
    	Producto producto = new Producto("ropa",59.90,5);
    	double resultado=CalculadoraDescuentosUtils.calcularTotalConDescuento(List.of(producto),true);
    	assertEquals(239.6,resultado); //59.90 * 5 *(1 - 0.2)
    			
    	}
    @Test
    public void testElectronicaSinVipDescuento20() {
    	Producto producto = new Producto("electronica",105,8);
    	double resultado=CalculadoraDescuentosUtils.calcularTotalConDescuento(List.of(producto),false);
    	assertEquals(672,resultado);  //105 * 8 * (1 - 0.2) 
    	
    }
    @Test
    public void testHogarConVipDescuento5() {
    	Producto producto = new Producto("hogar",14.90,1);
    	double resultado=CalculadoraDescuentosUtils.calcularTotalConDescuento(List.of(producto),true);
    	assertEquals(14.16,resultado,0.01);  //14.90 * 1 * (1 - 0.05) 
    	
    }
    @Test
    public void testAlimentacionSinVipDescuento5() {
    	Producto producto = new Producto("alimentacion",23,4);
    	double resultado=CalculadoraDescuentosUtils.calcularTotalConDescuento(List.of(producto),false);
    	assertEquals(87.4,resultado);  //23 * 4 * (1 - 0.05) 
    	
    }
  
    @Test
    void testCategoriaInvalidaLanzaExcepcion() {
        Producto producto = new Producto("juguetes", 100, 2); // categoría no válida
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraDescuentosUtils.calcularTotalConDescuento(List.of(producto), false);
        });
        assertEquals("Categoría no válida", exception.getMessage());
    }
    @Test
    void testPrecioProductoNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	Producto producto = new Producto("hogar",-95.4 , 3); // Precio no válido
        });
        assertEquals("Precio o cantidad no pueden ser negativos", exception.getMessage());
    }
  
    
}
