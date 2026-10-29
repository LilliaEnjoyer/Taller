import java.util.ArrayList;

public class GestorNomina {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ConfiguracionNomina config = ConfiguracionNomina.getConfiguracionNomina();

    public ConfiguracionNomina getConfig() {
        return config;
    }

    public void cargar(String[] lineas) {
        for (String linea : lineas) {
            empleados.add(FabricaEmpleados.crear(linea));
        }
    }

    public void imprimirSalud() {
        System.out.println("Salud en GestorNomina:  " + config.getPorcentajeSalud() * 100 + " %");
    }

    public void imprimirNomina() {
        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + ": " + String.format("%.0f", e.calcularSalario()));
        }
    }
}
