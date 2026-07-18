
package Model;

public enum Calidad {
    SD(1.0), HD(1.5), UHD_4K(2.0);
    
    private final double multiplicador;
    
    Calidad(double multiplicador) {
        this.multiplicador = multiplicador;
    }
    public double getMultiplicador() {
        return multiplicador; 
    }
}
