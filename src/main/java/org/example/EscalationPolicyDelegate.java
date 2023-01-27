package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class EscalationPolicyDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // Set escalation policy variables
        delegateExecution.setVariable("oicInDuty", false);
        delegateExecution.setVariable("supervisorAvailable", false);
        delegateExecution.setVariable("errAlert", true);
    }
}
