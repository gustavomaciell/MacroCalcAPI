package com.gusta.nutriweb.service;

import com.gusta.nutriweb.model.AlimentoModel;
import com.gusta.nutriweb.util.NumeroUtil;
import com.opencsv.CSVReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.gusta.nutriweb.util.NumeroUtil.converterDouble;

@Service
public class AlimentoService {

    public List<AlimentoModel> alimentosTacoCSV(String csvPath) {
        List<AlimentoModel> alimentos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream(csvPath)))) {

            List<String[]> linhas = reader.readAll();
            linhas.remove(0);
            for (String[] partes : linhas) {
                long id = Long.parseLong(partes[0]);
                String nome = partes[1];
                double proteina = NumeroUtil.arredondarUmaCasa(converterDouble(partes[5]).orElse(0.0));
                double carboidrato = NumeroUtil.arredondarUmaCasa(converterDouble(partes[8]).orElse(0.0));
                double lipidio = NumeroUtil.arredondarUmaCasa(converterDouble(partes[6]).orElse(0.0));
                double caloria = NumeroUtil.arredondarUmaCasa((converterDouble(partes[3]).orElse(0.0)));

                alimentos.add(new AlimentoModel(id, nome, proteina, carboidrato, lipidio, caloria));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alimentos;
    }

    public ResponseEntity<AlimentoModel> buscarAlimentosPorId(Long id) {
        return alimentosTacoCSV("/alimentos.csv")
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}

