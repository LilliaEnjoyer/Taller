public class ReciboNomina {
    private Empleado empleado;
    private double horasExtra;
    private double bonificacion;
    private double auxilioTransporte;
    private double descuentoLibranza;

    public ReciboNomina(Builder b) {
        this.empleado = b.empleado;
        this.horasExtra = b.horasExtra;
        this.bonificacion = b.bonificacion;
        this.auxilioTransporte = b.auxilioTransporte;
        this.descuentoLibranza = b.descuentoLibranza;
    }

    public double totalPagar() {
        return empleado.calcularSalario() + horasExtra + bonificacion
                + auxilioTransporte - descuentoLibranza;
    }

    public String getNombreEmpleado() {
        return empleado.getNombre();
    }

    public static class Builder(){
        private Empleado empleado;
        private double horasExtra;
        private double bonificacion;
        private double auxilioTransporte;
        private double descuentoLibranza;

        public Builder(Empleado e) { 
            this.empleado = e; 
        }

        public Builder horasExtra(double v) {
            this.horasExtra = v;
            return this;
        }

        public Builder bonificacion(double v) {
            this.bonificacion = v;
            return this;
        }

        public Builder auxilioTransporte(double v) {
            this.auxilioTransporte = v;
            return this;
        }

        public Builder descuentoLibranza(double v) {
            this.descuentoLibranza = v;
            return this;
        }

        public ReciboNomina build() {
            return new ReciboNomina(this);
        }
    }
}
