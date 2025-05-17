package org.anasantana.service;

import org.anasantana.model.Client;
import org.anasantana.service.util.CsvExporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceMethodComplexityTest {

    private static final int[] SCALES = {1000, 5000, 10000, 20000};
    private final CsvExporter exporter = new CsvExporter("client_service_complexity.csv");

    @Test
    void runAllComplexityMeasurementsAndExportCsv() {
        for (int scale : SCALES) {
            ClientService service = new ClientService();

            // ADD
            long startAdd = System.nanoTime();
            for (int i = 0; i < scale; i++) {
                service.addClient(new Client(String.valueOf(i), "Name" + i, "email" + i + "@mail.com"));
            }
            long endAdd = System.nanoTime();
            exporter.addRecord("addClient", scale, (endAdd - startAdd) / 1_000_000);

            // GET
            long startGet = System.nanoTime();
            for (int i = 0; i < scale; i++) {
                assertNotNull(service.getClient(String.valueOf(i)));
            }
            long endGet = System.nanoTime();
            exporter.addRecord("getClient", scale, (endGet - startGet) / 1_000_000);

            // REMOVE
            long startRemove = System.nanoTime();
            for (int i = 0; i < scale; i++) {
                assertNotNull(service.removeClient(String.valueOf(i)));
            }
            long endRemove = System.nanoTime();
            exporter.addRecord("removeClient", scale, (endRemove - startRemove) / 1_000_000);

            // CLEAR (após reinserção)
            for (int i = 0; i < scale; i++) {
                service.addClient(new Client(String.valueOf(i), "Name" + i, "email" + i + "@mail.com"));
            }
            long startClear = System.nanoTime();
            service.clearClients();
            long endClear = System.nanoTime();
            exporter.addRecord("clearClients", scale, (endClear - startClear) / 1_000_000);
        }

        exporter.export();
    }
}
