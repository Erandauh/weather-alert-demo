package org.example;

import junit.framework.TestCase;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class EvaluatorTest extends TestCase {

    DataEvaluatorDelegate evaluator = new DataEvaluatorDelegate();
    String weather =  "{\n" +
            "    \"coord\": {\n" +
            "        \"lon\": 79.8541,\n" +
            "        \"lat\": 6.9387\n" +
            "    },\n" +
            "    \"weather\": [\n" +
            "        {\n" +
            "            \"id\": 803,\n" +
            "            \"main\": \"Clouds\",\n" +
            "            \"description\": \"broken clouds\",\n" +
            "            \"icon\": \"04d\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"base\": \"stations\",\n" +
            "    \"main\": {\n" +
            "        \"temp\": 302.14,\n" +
            "        \"feels_like\": 306.62,\n" +
            "        \"temp_min\": 302.14,\n" +
            "        \"temp_max\": 302.14,\n" +
            "        \"pressure\": 1009,\n" +
            "        \"humidity\": 74,\n" +
            "        \"sea_level\": 1009,\n" +
            "        \"grnd_level\": 1008\n" +
            "    },\n" +
            "    \"visibility\": 10000,\n" +
            "    \"wind\": {\n" +
            "        \"speed\": 4.36,\n" +
            "        \"deg\": 319,\n" +
            "        \"gust\": 4.8\n" +
            "    },\n" +
            "    \"clouds\": {\n" +
            "        \"all\": 78\n" +
            "    },\n" +
            "    \"dt\": 1674733387,\n" +
            "    \"sys\": {\n" +
            "        \"type\": 1,\n" +
            "        \"id\": 9098,\n" +
            "        \"country\": \"LK\",\n" +
            "        \"sunrise\": 1674694730,\n" +
            "        \"sunset\": 1674737212\n" +
            "    },\n" +
            "    \"timezone\": 19800,\n" +
            "    \"id\": 1248991,\n" +
            "    \"name\": \"Colombo\",\n" +
            "    \"cod\": 200\n" +
            "}";
    @Test
    public void testExecute() throws Exception {
        DelegateExecution delegateExecution = mock(DelegateExecution.class);
        TypedValue typedValue = mock(TypedValue.class);

        when(delegateExecution.getVariableLocalTyped(anyString())).thenReturn(typedValue);
        when(typedValue.getValue()).thenReturn(weather);

        evaluator.execute(delegateExecution);

        verify(delegateExecution, times(1)).setVariable(anyString(), any());
    }
}