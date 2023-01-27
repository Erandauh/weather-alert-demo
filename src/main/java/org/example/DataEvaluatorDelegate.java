package org.example;

import com.google.gson.Gson;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.example.model.Weather;

import java.util.logging.Logger;

public class DataEvaluatorDelegate implements JavaDelegate {

    private final Logger log = Logger.getLogger(DataEvaluatorDelegate.class.getName());

    private final static String KEY_WEATHER = "weather";
    private static String KEY_INRISK = "inRisk";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TypedValue weatherT = delegateExecution.getVariableLocalTyped(KEY_WEATHER);

        Weather weather = new Gson().fromJson(weatherT.getValue().toString(), Weather.class);

        if (weather.getMain().getPressure() > 1000) {
            delegateExecution.setVariable(KEY_INRISK, true);

            log.info("IN RISK!!!");
        }
    }
}
