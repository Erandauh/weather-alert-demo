package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.logging.Logger;

@Named("EndDelegate")
public class EndDelegate implements JavaDelegate {

    private final Logger log = Logger.getLogger(EndDelegate.class.getName());
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("NO RISK BASED ON CURRENT EVALUATION!");
    }
}
