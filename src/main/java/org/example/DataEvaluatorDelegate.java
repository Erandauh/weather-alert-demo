package org.example;

import com.google.gson.Gson;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.example.model.Example;

import java.util.logging.Logger;

import static org.example.ProcessConstants.KEY_INRISK;
import static org.example.ProcessConstants.KEY_WEATHER;

public class DataEvaluatorDelegate implements JavaDelegate {

    private final Logger log = Logger.getLogger(DataEvaluatorDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TypedValue exampleT = delegateExecution.getVariableLocalTyped(KEY_WEATHER);

        Example e = new Gson().fromJson(exampleT.getValue().toString(), Example.class);

        boolean inRisk = (e.getMain().getPressure() > 1000
                && e.getMain().getHumidity() > 75
                && e.getWind().speed > 3
                && e.getClouds().all >= 40);

            delegateExecution.setVariable(KEY_INRISK, inRisk);
    }
}
