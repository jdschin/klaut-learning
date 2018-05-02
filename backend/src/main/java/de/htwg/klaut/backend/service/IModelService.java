package de.htwg.klaut.backend.service;

import de.htwg.klaut.backend.model.ModelParams;
import de.htwg.klaut.backend.model.db.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IModelService {
    Page<Model> findAll(Pageable pageable);

    Model createModel(String modelName, String modelDescription, ModelParams modelParams, Set<String> sourceUrls);

    void trainsModel(String modelId, ModelParams modelParams, Set<String> sourceUrls);

    void deleteModel(String modelId);
}
