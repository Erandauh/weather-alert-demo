package org.example;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class AlertSystemFailureDelegate implements JavaDelegate {


    private static Logger logger = LoggerFactory.getLogger(AlertSystemFailureDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.error("CRITICAL FALIURE IN ALERTING!!!");

    }
}
