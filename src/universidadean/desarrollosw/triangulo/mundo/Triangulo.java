/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudio: Desarrollo de Software
 * Ejercicio: Triangulo
 * Fecha: Agosto 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.triangulo.mundo;

/**
 * Clase que representa un triángulo.
 */
public class Triangulo {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del triángulo.
     */
    private Punto punto1;

    /**
     * Segundo punto del triángulo.
     */
    private Punto punto2;

    /**
     * Tercer punto del triángulo.
     */
    private Punto punto3;

    /**
     * Color de las líneas.
     */
    private Color colorLineas;

    /**
     * Color del relleno.
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el triángulo
     */
    public Triangulo() {
        // Inicializa los puntos

        punto1 = new Punto(200, 50);
        punto2 = new Punto(300, 200);
        punto3 = new Punto(100, 200);

        // Inicializa los colores
        colorRelleno = new Color(60, 168, 56);
        colorLineas = new Color(0, 83, 24);
    }

    /**
     * Retorna el punto 1 del triángulo.
     */
    public Punto darPunto1() {
        return punto1;
    }

    /**
     * Retorna el punto 2 del triángulo.
     */
    public Punto darPunto2() {
        return punto2;
    }

    /**
     * Retorna el punto 3 del triángulo.
     */
    public Punto darPunto3() {
        return punto3;
    }

    /**
     * Retorna el color de las líneas del triángulo.
     */
    public Color darColorLineas() {
        return colorLineas;
    }

    /**
     * Retorna el color del relleno del triángulo.
     */
    public Color darColorRelleno() {
        return colorRelleno;
    }

    /**
     * Retorna el perímetro del triángulo.
     */
    public double darPerimetro() {
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();
        return lado1 + lado2 + lado3;
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br>
     */
    public double darArea() {
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();
        double semiperimetro = darPerimetro() / 2.0;
        double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
        return area;
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     */
    public double darAltura() {
        double base = calcularLado1();
        double area = darArea();
        double altura = (2.0 * area) / base;
        return altura;
    }

    private double calcularDistanciaEntrePuntos(Punto inicio, Punto fin)
    {
        double x1 = inicio.darX();
        double y1 = inicio.darY();
        double x2 = fin.darX();
        double y2 = fin.darY();
        double distancia = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     */
    private double calcularLado1() {
        double distancia = calcularDistanciaEntrePuntos(punto1, punto2);
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     */
    private double calcularLado2() {
        double distancia = calcularDistanciaEntrePuntos(punto2, punto3);
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     */
    private double calcularLado3() {
        double distancia = calcularDistanciaEntrePuntos(punto3, punto1);
        return distancia;
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     */
    public double calcularAnguloOpuesto(double pX1, double pY1, double pX2, double pY2, double pX3, double pY3) {
        // Ángulo 1
        double angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1);

        // Ángulo 2
        double angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1);

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }

        // Calcula el ángulo opuesto
        double anguloOpuesto = (angulo1 + angulo2) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % (2.d * Math.PI);
        return anguloOpuesto;
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     */
    public void cambiarPunto1(double pX, double pY) {
        punto1.cambiarX(pX);
        punto1.cambiarY(pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     */
    public void cambiarPunto2(double pX, double pY) {
        punto2.cambiarX(pX);
        punto2.cambiarY(pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     */
    public void cambiarPunto3(double pX, double pY) {
        punto3.cambiarX(pX);
        punto3.cambiarY(pY);
    }

    /**
     * Cambia el color de relleno del triángulo.
     */
    public void cambiarColorRelleno(int pRojo, int pVerde, int pAzul) {
        colorRelleno.cambiarRojo(pRojo);
        colorRelleno.cambiarVerde(pVerde);
        colorRelleno.cambiarAzul(pAzul);
    }

    /**
     * Cambia el color de la líneas del triángulo.
     */
    public void cambiarColorLineas(int pRojo, int pVerde, int pAzul) {
        colorLineas.cambiarRojo(pRojo);
        colorLineas.cambiarVerde(pVerde);
        colorLineas.cambiarAzul(pAzul);
    }

    /**
     * Obtener el tipo de triángulo. Este puede ser:
     * - equilatero: los tres lados iguales
     * - isosceles: solo dos lados iguales
     * - escaleno: todos los lados diferentes.
     */
    public String tipo() {
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        if(lado1 == lado2 && lado1 == lado3)
        {
            return "equilatero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "isosceles";
        } else {
            return "escaleno";
        }
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 1 y el lado 2.
     * Use la ley del coseno para tal fin
     */
    public double angulo1() {
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double numerador = Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(lado3, 2);
        double denominador = 2.0 * lado1 * lado2;
        double angulo1 = Math.acos(numerador/denominador);

        return angulo1;
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 2 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo2() {
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double numerador = Math.pow(lado3, 2) + Math.pow(lado2, 2) - Math.pow(lado1, 2);
        double denominador = 2.0 * lado3 * lado2;
        double angulo2 = Math.acos(numerador/denominador);

        return angulo2;
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 1 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo3() {
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double numerador = Math.pow(lado1, 2) + Math.pow(lado3, 2) - Math.pow(lado2, 2);
        double denominador = 2.0 * lado1 * lado3;
        double angulo3 = Math.acos(numerador/denominador);

        return angulo3;
    }

}
