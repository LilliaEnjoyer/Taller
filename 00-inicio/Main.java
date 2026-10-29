public class Main {
    public static void main(String[] args) {
        // --- Configuración (síntoma de Singleton) ---
        ConfiguracionNomina.getConfiguracionNomina().setPorcentajeSalud(0.05);
        new GestorNomina().imprimirSalud();
        new ExportadorCSV().imprimirSalud();

        // --- Carga desde texto (síntoma de Factory) ---
        GestorNomina gestor = new GestorNomina();
        String[] lineas = {
            "FIJO;Ana Ruiz;3500000",
            "HORAS;Luis Gómez;120;18000",
            "CONTRATISTA;Marta Díaz;4200000"
        };
        gestor.cargar(lineas);
        System.out.println();
        gestor.imprimirNomina();

        // --- Recibos (síntoma de Builder) ---
        Empleado ana = new EmpleadoFijo("Ana Ruiz", 3500000);
        Empleado luis = new EmpleadoPorHoras("Luis Gómez", 120, 18000);
        ReciboNomina r1 = new ReciboNomina.Builder(ana).bonificacion(250000).build();
        ReciboNomina r2 = new ReciboNomina.Builder(luis).horasExtra(180000).descuentoLibranza(120000).build();
        System.out.println();
        System.out.println("Recibo " + r1.getNombreEmpleado() + ": " + String.format("%.0f", r1.totalPagar()));
        System.out.println("Recibo " + r2.getNombreEmpleado() + ": " + String.format("%.0f", r2.totalPagar()));

        Empleado juan = FabricaEmpleados.crear("PRACTICANTE;Juan Mora;1300000");
        ReciboNomina r3 = new ReciboNomina.Builder(juan).auxilioTransporte(200000).build();
        System.out.println("Recibo " + r3.getNombreEmpleado() + ": " + String.format("%.0f", r3.totalPagar()));
    }
}
