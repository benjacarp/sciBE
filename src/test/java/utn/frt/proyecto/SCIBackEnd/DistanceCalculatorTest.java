package utn.frt.proyecto.SCIBackEnd;

import org.junit.Test;

public class DistanceCalculatorTest {

    @Test
    public void facuALaPlaza() throws Exception {
        String distancia = calcularDistancia(-26.819274,-65.202682,-26.816823,-65.198991);
        System.out.println(distancia);
    }
    @Test
    public void facuAMiCasa() throws Exception {
        String distancia = calcularDistancia(-26.800391,-65.246799,-26.816823,-65.198991);
        System.out.println(distancia);
    }

    private String calcularDistancia(double x1, double y1, double x2, double y2) {
        double distanceKM = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double distanciaMts = distanceKM * 100000;
        String distancia = String.format("%.0f", distanciaMts);

        if (distanciaMts > 1000) {
            distanciaMts = (float) distanciaMts / 1000;
            return String.format("%.1f", distanciaMts) + " Km.";
        }
        return distancia + " Mts.";
    }
}
