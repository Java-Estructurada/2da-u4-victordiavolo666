public class LoteBerry {
    String idLote;
    String variedad;
    double temperaturaActual;
    int diasAlmacenado;
    boolean aptoExportacion;
    public LoteBerry(String idLote, String variedad, double temperaturaActual, int diasAlmacenado) {
        this.idLote = idLote;
        this.variedad = variedad;
        this.temperaturaActual = temperaturaActual;
        this.diasAlmacenado = diasAlmacenado;
        this.aptoExportacion = true;
    }
    public static void main(String[] args) {
        LoteBerry[] lotes = {
    new LoteBerry("LOTE-401", "Arándano", 2.2, 4),
    new LoteBerry("LOTE-402", "Frambuesa", 0.8, 5),
    new LoteBerry("LOTE-403", "Zarzamora", 3.1, 9),
    new LoteBerry("LOTE-404", "Fresa", 1.8, 3)
};
        System.out.println("  Logistica de frio ");
        System.out.println(" Ejecutando auditoria en tiempo real :");
        for (int i = 0; i < 4; i++) {
            String motivo = "";
            if (lotes[i].temperaturaActual < 1.0 || lotes[i].temperaturaActual > 4.5) {
                lotes[i].aptoExportacion = false;
                motivo = "Falla de Temperatura";
            } else if (lotes[i].diasAlmacenado > 7) {
                lotes[i].aptoExportacion = false;
                motivo = "Exceso de Días";
}
        System.out.print("ID: " + lotes[i].idLote +  lotes[i].variedad  );
        System.out.print("Temperatura: " + lotes[i].temperaturaActual + "°C  Días: " + lotes[i].diasAlmacenado);
            
        if (lotes[i].aptoExportacion == true) {
        System.out.println(" | Estado:  APTO PARA EXPORTACIÓN");
        } else {
        System.out.println(" | Estado: RECHAZADO: " + motivo );
}
}
        System.out.println("Mapa de inventario en camaras frías:");
        System.out.println("Arándano Frambuesa Zarzamora Fresa");
        int[][] palesAlmacenados = {
            {12, 8, 15, 20},
            {5, 14, 10, 12},
            {18, 9, 7, 22}
        };
        int vTotal = 0;
        int mPales = 0;
        int cOcupada = 0;
        for (int i = 0; i < 3; i++) {
        System.out.print("Cámara " + (i + 1) + ":   ");
        int sumaCamara = 0;
        for (int j = 0; j < 4; j++) {
        System.out.print(palesAlmacenados[i][j]);
        vTotal = vTotal + palesAlmacenados[i][j];
        sumaCamara = sumaCamara + palesAlmacenados[i][j];
}
        System.out.println();
        if (sumaCamara > mPales) {
        mPales = sumaCamara;
        cOcupada = i + 1;
}
}
    System.out.println(" Metricas finales de inventario:");
    System.out.println("+ Volumen total en stock: " + vTotal + " palés de fruta.");
    System.out.println("+ Sector más ocupado: Cámara #" + cOcupada + " (Total: " + mPales + " pales).");
    System.out.println("Auditoría completada. Alerta enviada al área de embarques.");
    } 
}