package de.htwg.klaut.backend.service;

import de.htwg.klaut.backend.model.ModelParams;
import de.htwg.klaut.backend.model.db.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IModelService {
    Page<Model> getModels(Pageable pageable);

    Model createModel(String modelName, String modelDescription, ModelParams modelParams, Set<String> sourceUrls);

    void trainModel(String modelId, Set<String> sourceUrls);

    void trainModel(String modelId, ModelParams modelParams);

    void trainModel(String modelId, ModelParams modelParams, Set<String> sourceUrls);

    void deleteModel(String modelId);
}
