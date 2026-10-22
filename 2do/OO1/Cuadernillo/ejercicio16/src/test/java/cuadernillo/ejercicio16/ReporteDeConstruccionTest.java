package cuadernillo.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	
	PrismaRectangular prisma;
	Cilindro cilindro;
	Esfera esfera;
	ReporteDeConstruccion reporte;

	@BeforeEach
	void setUp() throws Exception {
		cilindro = new Cilindro(10,5,"Rojo","Madera");
		esfera = new Esfera(5,"Rojo","Metal");
		prisma = new PrismaRectangular(9,5,12,"Verde","Metal");
		reporte = new ReporteDeConstruccion();
		reporte.agregarPieza(cilindro);
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(prisma);
	}
	
	@Test
	void superficieDeColorTest() {
		assertEquals(785.4,reporte.superficieDeColor("Rojo"),0.01);
		assertEquals(0,reporte.superficieDeColor("Azul"),0.01);
		assertEquals(426,reporte.superficieDeColor("Verde"),0.1);
	}
	
	@Test
	void volumenDeMaterialTest() {
		assertEquals(1063.6,reporte.volumenDeMaterial("Metal"),0.1);
		assertEquals(0,reporte.volumenDeMaterial("Plastico"),0.1);
		assertEquals(785.40,reporte.volumenDeMaterial("Madera"),0.1);
	}
	
}
