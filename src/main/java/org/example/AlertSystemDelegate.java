package org.example;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.ProcessConstants.KEY_OIC_INDUTY;
import static org.example.ProcessConstants.KEY_SUPERVISOR_AVAILABLE;


@Slf4j
public class AlertSystemDelegate implements JavaDelegate {


    private static Logger logger = LoggerFactory.getLogger(AlertSystemDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        if (Boolean.getBoolean(delegateExecution.getVariableLocalTyped(KEY_OIC_INDUTY).getValue().toString())) {
            logger.error("Officer Alerted!");
        } else if (Boolean.getBoolean(delegateExecution.getVariableLocalTyped(KEY_SUPERVISOR_AVAILABLE)
                .getValue().toString())) {
            logger.error("Supervisor Alerted!");
        } else {
            logger.error("CRITICAL FAILURE IN ALERTING!!!");
        }

    }
}
