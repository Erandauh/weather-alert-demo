package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.example.ProcessConstants.*;

public class EscalationPolicyDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        boolean[] randoms = getBooleanCombination();

        // Set escalation policy variables
       /* delegateExecution.setVariable(KEY_OIC_INDUTY, randoms[0]);
        delegateExecution.setVariable(KEY_SUPERVISOR_AVAILABLE, randoms[1]);
        delegateExecution.setVariable(KEY_ALERT_ERR, randoms[2]);*/

        delegateExecution.setVariable(KEY_OIC_INDUTY, false);
        delegateExecution.setVariable(KEY_SUPERVISOR_AVAILABLE, true);
        delegateExecution.setVariable(KEY_ALERT_ERR, false);
    }

    private boolean[] getBooleanCombination() {
        Map<Integer, boolean[]> r = new HashMap(3);
        Random random = new Random();

        r.put(0, new boolean[]{true, false, false});
        r.put(1, new boolean[]{true, false, false});
        r.put(2, new boolean[]{false, true, false});
        r.put(3, new boolean[]{false, false, true});

        return r.get(random.nextInt(3));
    }
}
