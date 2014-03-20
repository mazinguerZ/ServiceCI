/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sonoa.services.messaging.component.primitive.javacallout.spi.MessageContext;

import es.tid.neosdp.callouts.ApigeeConstants;
import es.tid.neosdp.callouts.NeosdpVariables;
import es.tid.neosdp.contextfake.MessageContextFake;
import es.tid.neosdp.logger.Logger.Level;

/**
 * Unit test for Logger
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class LoggerTest {

    /**
     * Invalid log level
     */
    @Test
    public void testExecute_invalidLevel() {
        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");
            String message = "This is a debug message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}";
            Logger.log(messageContext, Level.DEBUG, message);
            Logger.customLog(messageContext, Level.DEBUG, message);
            Logger.logHttpMessage(messageContext, Level.DEBUG, message);
            String logTraces = messageContext.getFlowVariableAsString(Logger.VAR_LOG_TRACES);
            Assert.assertNull(logTraces);
        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * Two log levels (one of them, debug, is invalid)
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testExecute_2Levels() {
        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");

            Logger.log(messageContext, Level.WARN,
                "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.log(messageContext, Level.DEBUG,
                "This is a debug message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().endsWith(
                "Bluevia 111-222-33 appTest / OBID WARN [This is a warning message with name: neoSDP and value test]"));

            Logger.customLog(messageContext, Level.WARN, "[${" + NeosdpVariables.VAR_TX_ID + "} ${"
                + ApigeeConstants.APIGEE_APPLICATION_NAME + "}] "
                + "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.customLog(messageContext, Level.DEBUG, "[${" + NeosdpVariables.VAR_TX_ID + "} ${"
                + ApigeeConstants.APIGEE_APPLICATION_NAME + "}] "
                + "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().endsWith(
                "[111-222-33 appTest] This is a warning message with name: neoSDP and value test"));

            messageContext.setFlowVariable(ApigeeConstants.APIGEE_FLOW_MESSAGEBYTES, "{\"json\": \"test\"}");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_MESSAGE_STATE, ApigeeConstants.APIGEE_VALUE_REQUEST);
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_CLIENT_REQUEST_FIRST_LINE, "GET /testPath HTTP/1.1");
            Logger.logHttpMessage(messageContext, Level.ERROR,
                "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.logHttpMessage(messageContext, Level.DEBUG,
                "This is a debug message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert
                .assertTrue(logTraces
                    .toString()
                    .endsWith(
                        "Bluevia 111-222-33 appTest / OBID ERROR [This is a warning message with name: neoSDP and value test] GET /testPath HTTP/1.1"));

        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * A flow variable is not present
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testExecute_withoutVariable() {

        String appIdVarDefault = "_flow.msgvar.neosdp.tx.appid";
        String servIdVarDefault = "_flow.msgvar.neosdp.tx.servid";
        String obIdVarDefault = "_flow.msgvar.neosdp.tx.obid";

        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");

            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");

            // for logs
            messageContext.setFlowVariable(Logger.VAR_VAR_APPID_LOGS, appIdVarDefault);
            messageContext.setFlowVariable(Logger.VAR_VAR_SERVID_LOGS, servIdVarDefault);
            messageContext.setFlowVariable(Logger.VAR_VAR_OBID_LOGS, obIdVarDefault);
            messageContext.setFlowVariable(servIdVarDefault, "1");
            messageContext.setFlowVariable(appIdVarDefault, "18299");
            messageContext.setFlowVariable(obIdVarDefault, "63612");

            Logger.log(messageContext, Level.WARN,
                "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert
                .assertTrue(logTraces
                    .toString()
                    .endsWith(
                        "Bluevia 111-222-33 appTest 1/18299 63612 WARN [This is a warning message with name:  and value test]"));

            Logger.customLog(messageContext, Level.WARN,
                "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().endsWith("This is a warning message with name:  and value test"));

            messageContext.setFlowVariable(ApigeeConstants.APIGEE_FLOW_MESSAGEBYTES, "{\"json\": \"test\"}");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_MESSAGE_STATE, ApigeeConstants.APIGEE_VALUE_RESPONSE);
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_HTTP_RESPONSE_CODE, 200);
            Logger.logHttpMessage(messageContext, Level.WARN,
                "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert
                .assertTrue(logTraces
                    .toString()
                    .endsWith(
                        "Bluevia 111-222-33 appTest 1/18299 63612 WARN 200 [This is a warning message with name:  and value test]"));

        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * Several log traces
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testExecute_severalTraces() {
        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");
            messageContext.setFlowVariable(Logger.VAR_UNICACORRELATOR_HEADER, "12345 A");

            Logger.log(messageContext, Level.WARN,
                "This is a message (1) with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.log(messageContext, Level.ERROR,
                "This is a message (2) with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().contains(
                "111-222-33#(12345 A) appTest / OBID WARN [This is a message (1) with name: neoSDP and value test]"));
            Assert.assertTrue(logTraces.toString().contains(
                "111-222-33#(12345 A) appTest / OBID ERROR [This is a message (2) with name: neoSDP and value test]"));

            Logger.customLog(messageContext, Level.WARN,
                "This is a warning message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.customLog(messageContext, Level.ERROR,
                "This is an error message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().contains(
                "This is a warning message with name: neoSDP and value test"));
            Assert.assertTrue(logTraces.toString()
                .endsWith("This is an error message with name: neoSDP and value test"));

            messageContext.setFlowVariable(ApigeeConstants.APIGEE_FLOW_MESSAGEBYTES, "{\"json\": \"test\"}");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_MESSAGE_STATE, ApigeeConstants.APIGEE_VALUE_REQUEST);
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_CLIENT_REQUEST_FIRST_LINE, "GET /testPath HTTP/1.1");
            Logger.logHttpMessage(messageContext, Level.WARN,
                "This is a message (1) with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.logHttpMessage(messageContext, Level.ERROR,
                "This is a message (2) with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");

            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertFalse(logTraces.toString().contains(
                "111-222-33#(12345 A) appTest / OBID WARN [This is a message (1) with name: neoSDP and value test]"
                    + " GET /testPath HTTP/1.1\n\n{\"json\": \"test\"}"));
            Assert
                .assertTrue(logTraces
                    .toString()
                    .contains(
                        "111-222-33#(12345 A) appTest / OBID ERROR [This is a message (2) with name: neoSDP and value test] GET /testPath HTTP/1.1"));

            // change log level to DEBUG
            messageContext.setFlowVariable(Logger.VAR_LOG_LEVEL, "DEBUG");
            Logger.logHttpMessage(messageContext, Level.DEBUG,
                "This is a message (3) with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().endsWith(
                "111-222-33#(12345 A) appTest / OBID DEBUG [This is a message (3) with name: neoSDP and value test]"
                    + " GET /testPath HTTP/1.1\n{\"json\": \"test\"}"));
        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * Several log traces with no default log level
     */
    @Test
    public void testExecute_noDefaultLevel() {

        String appIdVar = "_flow.msgvar.neosdp.logs.appId";
        String servIdVar = "_flow.msgvar.neosdp.logs.servId";
        String obIdVarDefault = "_flow.msgvar.neosdp.tx.obid";

        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");
            messageContext.setFlowVariable(Logger.VAR_LOG_LEVEL, "INFO");
            messageContext.setFlowVariable(Logger.VAR_UNICACORRELATOR_HEADER, "12345 A");

            // for logs
            messageContext.setFlowVariable(Logger.VAR_VAR_APPID_LOGS, appIdVar);
            messageContext.setFlowVariable(Logger.VAR_VAR_SERVID_LOGS, servIdVar);
            messageContext.setFlowVariable(Logger.VAR_VAR_OBID_LOGS, obIdVarDefault);
            messageContext.setFlowVariable(servIdVar, "1");
            messageContext.setFlowVariable(appIdVar, "18299");
            messageContext.setFlowVariable(obIdVarDefault, "63612");

            Logger.log(messageContext, Level.DEBUG,
                "This is a debug message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.log(messageContext, Level.INFO,
                "This is a info message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.log(messageContext, Level.WARN,
                "This is a warn message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            Logger.log(messageContext, Level.ERROR,
                "This is a error message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");
            @SuppressWarnings("unchecked")
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert
                .assertFalse(logTraces
                    .toString()
                    .contains(
                        "111-222-33#(12345 A) appTest 1/18299 63612 DEBUG [This is a debug message with name: neoSDP and value test]"));
            Assert
                .assertTrue(logTraces
                    .toString()
                    .contains(
                        "111-222-33#(12345 A) appTest 1/18299 63612 INFO [This is a info message with name: neoSDP and value test]"));
            Assert
                .assertTrue(logTraces
                    .toString()
                    .contains(
                        "111-222-33#(12345 A) appTest 1/18299 63612 WARN [This is a warn message with name: neoSDP and value test]"));
            Assert
                .assertTrue(logTraces
                    .toString()
                    .contains(
                        "111-222-33#(12345 A) appTest 1/18299 63612 ERROR [This is a error message with name: neoSDP and value test]"));
        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * Log trace with exception message
     */
    @Test
    public void testExecute_exception() {
        try {
            // Prepare exception
            Exception exception = new Exception("This is a test");

            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");
            messageContext.setFlowVariable(Logger.VAR_LOG_LEVEL, "INFO");

            Logger.log(messageContext, Level.ERROR,
                "This is a error message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}", exception);
            @SuppressWarnings("unchecked")
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert.assertTrue(logTraces.toString().contains(
                "Bluevia 111-222-33 appTest / OBID ERROR [This is a error message with name: neoSDP and value test]"));
            Assert.assertTrue(logTraces.toString().contains("This is a test"));
        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * Statistics log level
     */
    @Test
    public void testExecute_statistics() {

        String appIdVar = "_flow.msgvar.neosdp.logs.appId";
        String servIdVar = "_flow.msgvar.neosdp.logs.servId";
        String obIdVar = "_flow.msgvar.neosdp.tx.obid";

        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");

            // for logs
            messageContext.setFlowVariable(Logger.VAR_DATETIME_REQUEST, Logger.dateFormat.format(new Date()));
            messageContext.setFlowVariable(Logger.VAR_VAR_APPID_LOGS, appIdVar);
            messageContext.setFlowVariable(Logger.VAR_VAR_SERVID_LOGS, servIdVar);
            messageContext.setFlowVariable(Logger.VAR_VAR_OBID_LOGS, obIdVar);
            messageContext.setFlowVariable(servIdVar, "1");
            messageContext.setFlowVariable(appIdVar, "18299");
            messageContext.setFlowVariable(obIdVar, "63612");
            messageContext.setFlowVariable(Logger.VAR_CATEGORY_LOGS, "FE");

            Logger.logHttpMessage(messageContext, Level.INFOSTATS,
                "This is a statistics message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");

            @SuppressWarnings("unchecked")
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert
                .assertTrue(logTraces
                    .toString()
                    .contains(
                        "Bluevia 111-222-33 FE appTest 1/18299 63612 INFOSTATS [This is a statistics message with name: neoSDP and value test]"));
        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

    /**
     * Statistics log level (BE)
     */
    @Test
    public void testExecute_statisticsBE() {

        String appIdVar = "_flow.msgvar.neosdp.logs.appId";
        String servIdVar = "_flow.msgvar.neosdp.logs.servId";
        String obIdVar = "_flow.msgvar.neosdp.tx.obid";

        try {
            MessageContext messageContext = new MessageContextFake();
            messageContext.setFlowVariable("_flow.msgvar.neosdp.name", "neoSDP");
            messageContext.setFlowVariable(Logger.VAR_DOMAINNAME, "Bluevia");
            messageContext.setFlowVariable("testVar", "test");
            messageContext.setFlowVariable(ApigeeConstants.APIGEE_APPLICATION_NAME, "appTest");
            messageContext.setFlowVariable(NeosdpVariables.VAR_TX_ID, "111-222-33");

            Map<String, Object> mapStatsMessage = new HashMap<String, Object>();
            Map<String, String> mapInfo = new HashMap<String, String>();
            mapInfo.put("key", "valor");
            mapInfo.put("key2", "valor2");
            mapStatsMessage.put("Payment", mapInfo);
            messageContext.setFlowVariable(Logger.STATS_LOGS_MESSAGE, mapStatsMessage);

            // for logs
            messageContext.setFlowVariable(Logger.VAR_DATETIME_REQUEST, Logger.dateFormat.format(new Date()));
            messageContext.setFlowVariable(Logger.VAR_VAR_APPID_LOGS, appIdVar);
            messageContext.setFlowVariable(Logger.VAR_VAR_SERVID_LOGS, servIdVar);
            messageContext.setFlowVariable(Logger.VAR_VAR_OBID_LOGS, obIdVar);
            messageContext.setFlowVariable(servIdVar, "1");
            messageContext.setFlowVariable(appIdVar, "18299");
            messageContext.setFlowVariable(obIdVar, "63612");
            messageContext.setFlowVariable(Logger.VAR_CATEGORY_LOGS, "BE");

            Logger.logHttpMessage(messageContext, Level.INFOSTATS,
                "This is a statistics message with name: ${_flow.msgvar.neosdp.name} and value ${testVar}");

            @SuppressWarnings("unchecked")
            List<String> logTraces = (List<String>) messageContext.getFlowVariable(Logger.VAR_LOG_TRACES);
            Assert
                .assertTrue(logTraces
                    .toString()
                    .contains(
                        "Bluevia 111-222-33 BE appTest 1/18299 63612 INFOSTATS [{\"Payment\":{\"key2\":\"valor2\",\"key\":\"valor\"}}]"));
        } catch (Throwable t) {
            Assert.fail("Failed logging: " + t.getMessage());
        }
    }

}
