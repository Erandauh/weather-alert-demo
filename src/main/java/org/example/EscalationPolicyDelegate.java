package org.example;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.example.ColorConstants.ANSI_RED;
import static org.example.ColorConstants.ANSI_RESET;
import static org.example.ProcessConstants.*;

@Slf4j
public class EscalationPolicyDelegate implements JavaDelegate {

    private static Logger logger = LoggerFactory.getLogger(AlertSystemDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        boolean[] randoms = getBooleanCombination();

        // Set escalation policy variables
        delegateExecution.setVariable(KEY_OIC_INDUTY, randoms[0]);
        delegateExecution.setVariable(KEY_SUPERVISOR_AVAILABLE, randoms[1]);
        delegateExecution.setVariable(KEY_ALERT_ERR, randoms[2]);

        if (randoms[0]) {
            logger.info("To be alerted to >> Officer in Charge");

        } else if (randoms[1]) {
            logger.info("To be alerted to >> SUPERVISOR");
        } else {
            logger.info("System failure should be recorded!");
        }
    }

    private boolean[] getBooleanCombination() {
        Map<Integer, boolean[]> r = new HashMap(3);
        Random random = new Random();

        r.put(0, new boolean[]{true, false, false});
        r.put(1, new boolean[]{true, false, false});
        r.put(2, new boolean[]{false, true, false});
        r.put(3, new boolean[]{false, false, true});

        return r.get(random.nextInt(4));
    }
}
