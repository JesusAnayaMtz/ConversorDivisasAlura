public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {

    @Override
    public String toString() {
        return "{" +
                " Moneda Origen='" + base_code + '\'' +
                ", Moneda Cambio='" + target_code + '\'' +
                ", Valor Actual=" + conversion_rate +
                ", Resultado Total=" + conversion_result +
                '}';
    }
}
