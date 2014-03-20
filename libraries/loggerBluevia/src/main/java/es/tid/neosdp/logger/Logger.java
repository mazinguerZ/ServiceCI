/*
 * neoSDP (API management layer for Telefonica enablers) Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sonoa.services.messaging.component.primitive.javacallout.spi.MessageContext;
import com.sonoa.services.messaging.component.primitive.javacallout.spi.MessagingException;

import es.tid.neosdp.callouts.ApigeeConstants;
import es.tid.neosdp.callouts.context.NeosdpContext;
import es.tid.neosdp.representations.Map2Json;

/**
 * Logger for Apigee gateway which collects log traces into a flow variable: _flow.msgvar.neosdp.logger.traces. <br>
 * The valid log levels are: DEBUG, INFO, WARN, ERROR It is possible to configure the log level, under which no log
 * message is traced, with the flow variable: _flow.msgvar.neosdp.logger.level. By default, the log level is INFO. <br>
 * The predefined format of a log trace is: ${date}T${time} ${domainName} {_flow.msgvar.neosdp.transaction.id}
 * ${_flow.applicationame} ${serviceId}/${appId} ${obId} ${logLevel}#(${unicaCorrelator}) [${logMessage}] where
 * #(${correlator}) is taken from the optional NeosdpCorrelator header <br>
 * For example: 2013/02/04-07:15:38.288 111-222-33 appTest WARN [This is a log message without correlator header]
 * 2013/02/04-07:15:38.288 111-222-33#(1234567890) appTest WARN [This is a log message with correlator header]
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 * @author rps (rps@tid.es)
 * @author juanc352 (jchernandez@full-on-net.com)
 */
public class Logger {

    /**
     * Enumeration of log levels
     */
    public enum Level {
        DEBUG, INFO, INFOSTATS, WARN, ERROR
    };

    /**
     * Configured log level (lower log level will not be traced)
     */
    public final static String VAR_LOG_LEVEL = "logLevel";

    /**
     * Flow variable containing the log traces
     */
    public final static String VAR_LOG_TRACES = "_flow.msgvar.neosdp.logger.traces";

    /**
     * Flow variable containing the datetime of the original request
     */
    public final static String VAR_DATETIME_REQUEST = "_flow.msgvar.neosdp.logger.datetimeRequest";

    /**
     * Variable that contains the category of the application of logs for statistics
     */
    public final static String VAR_CATEGORY_LOGS = "_flow.msgvar.neosdp.logger.category";

    /**
     * Variable that contains the name of the variable that contains the value of the applicationId
     */
    public final static String VAR_VAR_APPID_LOGS = "_flow.msgvar.neosdp.logger.appIdVar";

    /**
     * Variable that contains the name of the variable that contains the value of the serivcenId
     */
    public final static String VAR_VAR_SERVID_LOGS = "_flow.msgvar.neosdp.logger.servIdVar";

    /**
     * Variable that contains the name of the variable that contains the value of the obId
     */
    public final static String VAR_VAR_OBID_LOGS = "_flow.msgvar.neosdp.logger.obIdVar";

    /**
     * Map with the message of BEs for statistics
     */
    public final static String STATS_LOGS_MESSAGE = "_flow.msgvar.neosdp.logger.statsMessage";

    /**
     * Default log level (if a log level is not configured in the system)
     */
    public final static Level DEFAULT_LOG_LEVEL = Level.INFO;

    /**
     * Value of log level that statistics uses
     */
    public final static Level STATISTICS_LEVEL = Level.INFOSTATS;

    /**
     * Formatter for dates
     */
    public final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss.SSS");

    /**
     * Use this apiGee variable to get domainName
     */
    public final static String VAR_DOMAINNAME = "_flow.domainname";

    /**
     * Use this flow variable if flow is in a ServiceCallout
     */
    public final static String VAR_NEOTRANSACTIONID4LOG = "neoTransactionId4log";

    /**
     * Use this flow variable if flow is in a FrontEnd
     */
    public final static String VAR_TRANSACTIONID = "transactionId";

    /**
     * NeosdpCorrelator header variable
     */
    public final static String VAR_UNICACORRELATOR_HEADER = "_flow.client.request.header.Unica-Correlator";

    /**
     * NeosdpCorrelator header variable
     */
    public final static String VAR_RESPONSE_CODE = "_flow.responsecode";

    /**
     * Space char
     */
    private final static char sp = ' ';

    /**
     * Value of the category call 'Backend'
     */
    public final static String CATEGOY_BACKEND = "BE";

    /**
     * Log a message at a specific level
     * 
     * @param messageContext
     * @param level
     * @param message
     */
    public static void log(MessageContext messageContext, Level level, String message) {

        Logger.log(messageContext, level, message, null);
    }

    /**
     * Log a message at a specific level with an exception. If exception is null, the exception is ignored
     * 
     * @param messageContext
     * @param level
     * @param level
     * @param message
     * @param t
     */
    public static void log(MessageContext messageContext, Level level, String message, Throwable t) {

        try {
            Level configuredLevel = Logger.getConfiguredLevel(messageContext);
            // Check if the log level is equal or superior than the configured log level
            if (level.ordinal() >= configuredLevel.ordinal()) {
                // Replace the message with the flow variables
                message = NeosdpContext.replaceFlowVariables(messageContext, message);

                // Get the previous log traces list
                List<String> logTraces = Logger.getLogTraces(messageContext);

                // applicationId for logs
                String appIdVar = (String) messageContext.getFlowVariable(VAR_VAR_APPID_LOGS);
                String appIdValue = "";
                if (appIdVar != null && !appIdVar.isEmpty()) {
                    appIdValue = (String) messageContext.getFlowVariable(appIdVar);
                }

                // serviceId for logs
                String servIdVar = (String) messageContext.getFlowVariable(VAR_VAR_SERVID_LOGS);
                String servIdValue = "";
                if (servIdVar != null && !servIdVar.isEmpty()) {
                    servIdValue = (String) messageContext.getFlowVariable(servIdVar);
                }

                // obId for logs
                String obIdVar = (String) messageContext.getFlowVariable(VAR_VAR_OBID_LOGS);
                String obIdValue = "OBID";
                if (obIdVar != null && !obIdVar.isEmpty() && messageContext.getFlowVariable(obIdVar) != null) {
                    obIdValue = (String) messageContext.getFlowVariable(obIdVar);
                }

                // Format the log trace and add it to the log traces list
                logTraces.add(Logger.formatLogTrace(Logger.getDomainName(messageContext),
                    Logger.getTransactionId(messageContext), Logger.getUnicaCorrelator(messageContext),
                    Logger.getApplicationName(messageContext), level, Logger.getResponseCode(messageContext), message,
                    t, appIdValue, servIdValue, obIdValue));

                // Store the log traces in the flow variable
                NeosdpContext.setFlowVariable(messageContext, VAR_LOG_TRACES, logTraces);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Log a formated message at a specific level
     * 
     * @param messageContext
     * @param level
     * @param message
     */
    public static void customLog(MessageContext messageContext, Level level, String message) {

        Logger.customLog(messageContext, level, message, null);
    }

    /**
     * Log a formated message at a specific level with an exception. If exception is null, the exception is ignored
     * 
     * @param messageContext
     * @param level
     * @param message
     * @param t
     */
    public static void customLog(MessageContext messageContext, Level level, String message, Throwable t) {

        try {
            Level configuredLevel = Logger.getConfiguredLevel(messageContext);
            // Check if the log level is equal or superior than the configured log level
            if (level.ordinal() >= configuredLevel.ordinal()) {
                // Replace the message with the flow variables
                message = NeosdpContext.replaceFlowVariables(messageContext, message);

                // Get the previous log traces list
                List<String> logTraces = Logger.getLogTraces(messageContext);
                // Format the log trace and add it to the log traces list
                logTraces.add(Logger.formatLogTrace(message, t));

                // Store the log traces in the flow variable
                NeosdpContext.setFlowVariable(messageContext, VAR_LOG_TRACES, logTraces);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Log a HTTP message of messageContext
     * 
     * @param messageContext
     * @param level
     * @param responseCode
     * @param message
     */
    public static void logHttpMessage(MessageContext messageContext, Level level, String message) {

        try {
            Level configuredLevel = Logger.getConfiguredLevel(messageContext);
            // Check if the log level is equal or superior than the configured log level
            if (level.ordinal() >= configuredLevel.ordinal()) {
                // Replace the message with the flow variables
                message = NeosdpContext.replaceFlowVariables(messageContext, message);

                // Get the previous log traces list
                List<String> logTraces = Logger.getLogTraces(messageContext);

                // applicationId for logs
                String appIdVar = (String) messageContext.getFlowVariable(VAR_VAR_APPID_LOGS);
                String appIdValue = "";
                if (appIdVar != null && !appIdVar.isEmpty()) {
                    appIdValue = (String) messageContext.getFlowVariable(appIdVar);
                }

                // serviceId for logs
                String servIdVar = (String) messageContext.getFlowVariable(VAR_VAR_SERVID_LOGS);
                String servIdValue = "";
                if (servIdVar != null && !servIdVar.isEmpty()) {
                    servIdValue = (String) messageContext.getFlowVariable(servIdVar);
                }

                // obId for logs
                String obIdVar = (String) messageContext.getFlowVariable(VAR_VAR_OBID_LOGS);
                String obIdValue = "OBID";
                if (obIdVar != null && !obIdVar.isEmpty() && messageContext.getFlowVariable(obIdVar) != null) {
                    obIdValue = (String) messageContext.getFlowVariable(obIdVar);
                }

                // Format the log trace and add it to the log traces list
                if (Level.INFOSTATS.equals(level)) {
                    String datetimeRequest = (String) messageContext.getFlowVariable(VAR_DATETIME_REQUEST);

                    String category = (String) messageContext.getFlowVariable(VAR_CATEGORY_LOGS);

                    // backend apps will show a json with relevant variables
                    if (category != null && CATEGOY_BACKEND.equalsIgnoreCase(category)) {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> logStatsMessage = (Map<String, Object>) messageContext
                            .getFlowVariable(STATS_LOGS_MESSAGE);
                        message = new Map2Json(false).generate(logStatsMessage);

                    }

                    // Format the log trace and add it to the log traces list
                    logTraces.add(Logger.formatLogStatisticsMessageTrace(Logger.getDomainName(messageContext),
                        Logger.getTransactionId(messageContext), Logger.getUnicaCorrelator(messageContext),
                        Logger.getApplicationName(messageContext), Logger.getResponseCode(messageContext), message,
                        Logger.getRawHttpMessage(messageContext, STATISTICS_LEVEL), category, datetimeRequest,
                        appIdValue, servIdValue, obIdValue));
                } else {
                    logTraces.add(Logger.formatLogHttpMessageTrace(Logger.getDomainName(messageContext),
                        Logger.getTransactionId(messageContext), Logger.getUnicaCorrelator(messageContext),
                        Logger.getApplicationName(messageContext), level, Logger.getResponseCode(messageContext),
                        message, Logger.getRawHttpMessage(messageContext, level), appIdValue, servIdValue, obIdValue));
                }

                // Store the log traces in the flow variable
                NeosdpContext.setFlowVariable(messageContext, VAR_LOG_TRACES, logTraces);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the log level configured in the Apigee application (optional). This value is available in the flow variable:
     * logLevel. If this flow variable is not set, then it is considered the default log level: INFO.
     * 
     * @param messageContext
     * @return
     */
    protected static Level getConfiguredLevel(MessageContext messageContext) {

        Level configuredLevel = DEFAULT_LOG_LEVEL;
        String logLevel = NeosdpContext.getFlowVariableAsString(messageContext, VAR_LOG_LEVEL);
        if (logLevel != null) {
            try {
                configuredLevel = Level.valueOf(logLevel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return configuredLevel;
    }

    /**
     * Gets the previous log traces list in messageContext
     * 
     * @return
     * @throws MessagingException
     */
    @SuppressWarnings("unchecked")
    protected static List<String> getLogTraces(MessageContext messageContext) {

        List<String> logTraces = null;
        try {
            // Get the previous log traces list (null if no previous log trace)
            logTraces = (List<String>) messageContext.getFlowVariable(VAR_LOG_TRACES);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if (logTraces == null)
            logTraces = new LogArrayList();
        return logTraces;
    }

    /**
     * Creates new message line (without predefined format) with an optional exception text line
     * 
     * @param previousLogTraces
     * @param message
     * @param t
     * @return
     */
    protected static String formatLogTrace(String message, Throwable t) {

        StringBuilder logBuilder = new StringBuilder(message);
        if (t != null) {
            logBuilder.append(' ').append(t.toString());
        }
        return logBuilder.toString();
    }

    /**
     * Format a new log trace according to the following format: ${date}-${time} ${domainName}
     * ${_flow.msgvar.neosdp.transaction.id}#(${correlator}) ${_flow.applicationame} ${serviceId}/${appId} ${obId}
     * ${logLevel} [${logMessage}] Appends and an optional exception text line.
     * 
     * @param domainName
     * @param transactionId
     * @param applicationName
     * @param level
     * @param responseCode
     * @param message
     * @param t
     * @param appId
     *            applicationId
     * @param servId
     *            serviceId
     * @param obId
     * @return
     */
    protected static String formatLogTrace(String domainName, String transactionId, String correlator,
        String applicationName, Level level, String responseCode, String message, Throwable t, String appId,
        String servId, String obId) {

        StringBuilder logBuilder = Logger.formatLogTraceBegining(domainName, transactionId, correlator,
            applicationName, level, responseCode, appId, servId, obId);
        logBuilder.append(" [").append(message).append("]");
        if (t != null) {
            logBuilder.append(' ').append(t.toString());
        }
        return logBuilder.toString();
    }

    /**
     * Appends a new message line and the http message to previous log trace. Format the log trace according to the
     * following format: ${date}-${time} ${domainName} ${_flow.msgvar.neosdp.transaction.id}#(${correlator})
     * ${_flow.applicationame} ${serviceId}/${appId} ${obId} ${logLevel} [${logMessage(optional)}] ${httpMessage}
     * 
     * @param domainName
     * @param transactionId
     * @param applicationName
     * @param level
     * @param responseCode
     * @param message
     * @param httpMessage
     * @param appId
     *            applicationId
     * @param servId
     *            serviceId
     * @param obId
     * @return
     */
    protected static String formatLogHttpMessageTrace(String domainName, String transactionId, String correlator,
        String applicationName, Level level, String responseCode, String message, String httpMessage, String appId,
        String servId, String obId) {

        StringBuilder logBuilder = Logger.formatLogTraceBegining(domainName, transactionId, correlator,
            applicationName, level, responseCode, appId, servId, obId);
        if (message != null && message.length() > 0)
            logBuilder.append(" [").append(message).append("]");
        // log httpMessage
        if (httpMessage != null && !httpMessage.isEmpty()) {
            logBuilder.append(" ").append(httpMessage);
        }
        return logBuilder.toString();
    }

    /**
     * Appends a new message line with information for statistics to previous log trace. Format the log trace according
     * to the following format: ${datetimeRequest} ${datetime_response} ${domainName}
     * ${_flow.msgvar.neosdp.transaction.id}#(${correlator}) ${category=FE|BE} ${_flow.applicationame}
     * ${serviceId}/${appId} ${obId} ${logLevel} [${logMessage(optional)}] ${httpMessage}
     * 
     * @param domainName
     * @param transactionId
     * @param correlator
     *            unica correlator
     * @param applicationName
     * @param responseCode
     * @param message
     * @param httpMessage
     * @param category
     *            FE or BE
     * @param datetimeRequest
     *            date and time of the original request
     * @param appId
     *            applicationId
     * @param servId
     *            serviceId
     * @param obId
     * @return
     */
    protected static String formatLogStatisticsMessageTrace(String domainName, String transactionId, String correlator,
        String applicationName, String responseCode, String message, String httpMessage, String category,
        String datetimeRequest, String appId, String servId, String obId) {

        StringBuilder logBuilder = new StringBuilder(datetimeRequest);
        logBuilder.append(sp).append(dateFormat.format(new Date()));
        logBuilder.append(sp).append(domainName);
        logBuilder.append(sp).append(transactionId);
        if (correlator != null && !correlator.isEmpty())
            logBuilder.append("#(").append(correlator).append(')');
        logBuilder.append(sp).append(category).append(sp).append(applicationName).append(sp).append(servId).append("/")
            .append(appId).append(sp).append(obId).append(sp).append(STATISTICS_LEVEL);
        if (responseCode != null && !responseCode.isEmpty())
            logBuilder.append(sp).append(responseCode);

        if (message != null && message.length() > 0)
            logBuilder.append(" [").append(message).append("]");
        // log httpMessage
        logBuilder.append(" ").append(httpMessage);
        return logBuilder.toString();
    }

    /**
     * Returns a StringBuilder with the following format: ${date}-${time} ${domainName}
     * ${_flow.msgvar.neosdp.transaction.id}#(${unicaCorrelator}) ${_flow.applicationame} ${serviceId}/${appId} ${obId}
     * ${logLevel}
     * 
     * @param previousLogTraces
     * @param domainName
     * @param transactionId
     * @param correlator
     * @param applicationName
     * @param level
     * @param responseCode
     * @param appId
     *            applicationId
     * @param servId
     *            serviceId
     * @param obId
     * @return
     */
    protected static StringBuilder formatLogTraceBegining(String domainName, String transactionId, String correlator,
        String applicationName, Level level, String responseCode, String appId, String servId, String obId) {

        // Prepare the log date
        StringBuilder logBuilder = new StringBuilder(dateFormat.format(new Date()));
        logBuilder.append(sp).append(domainName);
        logBuilder.append(sp).append(transactionId);
        if (correlator != null && !correlator.isEmpty())
            logBuilder.append("#(").append(correlator).append(')');
        logBuilder.append(sp).append(applicationName).append(sp).append(servId).append("/").append(appId).append(sp)
            .append(obId).append(sp).append(level);
        if (responseCode != null && !responseCode.isEmpty())
            logBuilder.append(sp).append(responseCode);
        return logBuilder;
    }

    /**
     * Returns domainName in messageContext
     * 
     * @param messageContext
     * @return
     */
    protected static String getDomainName(MessageContext messageContext) {

        return NeosdpContext.getFlowVariableAsString(messageContext, VAR_DOMAINNAME);

    }

    /**
     * Returns transactionId from messageContext if present or from neoTransactionId4log flow variable
     * 
     * @param messageContext
     * @return
     */
    protected static String getTransactionId(MessageContext messageContext) {

        String transactionId = NeosdpContext.getTransactionId(messageContext);
        if (transactionId == null || transactionId.isEmpty()) {
            transactionId = NeosdpContext.getFlowVariableAsString(messageContext, VAR_NEOTRANSACTIONID4LOG);
            if (transactionId == null || transactionId.isEmpty()) {
                transactionId = NeosdpContext.getFlowVariableAsString(messageContext, VAR_TRANSACTIONID);
            }
        }
        return transactionId;
    }

    /**
     * Returns correlator from Unica-Correlator header in messageContext
     * 
     * @param messageContext
     * @return
     */
    protected static String getUnicaCorrelator(MessageContext messageContext) {

        return NeosdpContext.getFlowVariableAsString(messageContext, VAR_UNICACORRELATOR_HEADER);
    }

    /**
     * Returns correlator from Unica-Correlator header in messageContext
     * 
     * @param messageContext
     * @return
     */
    protected static String getResponseCode(MessageContext messageContext) {

        return NeosdpContext.getFlowVariableAsString(messageContext, VAR_RESPONSE_CODE);
    }

    /**
     * Returns Application name from messageContext
     * 
     * @param messageContext
     * @return
     */
    protected static String getApplicationName(MessageContext messageContext) {

        return NeosdpContext.getFlowVariableAsString(messageContext, ApigeeConstants.APIGEE_APPLICATION_NAME);
    }

    /**
     * Returns a String with the http message including first line, headers and body
     * 
     * @param messageContext
     * @param level
     * @return
     */
    protected static String getRawHttpMessage(MessageContext messageContext, Level level) {

        // HttpMessage logging
        // message state (Request|Response|Error)
        String messagestate = NeosdpContext.getFlowVariableAsString(messageContext,
            ApigeeConstants.APIGEE_MESSAGE_STATE);

        StringBuilder httpMessageBuilder;
        if (messagestate != null) {
            if (messagestate.equals(ApigeeConstants.APIGEE_VALUE_REQUEST)) {
                // Request logging (first line)
                String firstLine = NeosdpContext.getFlowVariableAsString(messageContext,
                    ApigeeConstants.APIGEE_CLIENT_REQUEST_FIRST_LINE);
                if (firstLine != null) {
                    httpMessageBuilder = new StringBuilder(firstLine);
                    // httpMessageBuilder.append("\n");
                } else {
                    httpMessageBuilder = new StringBuilder();
                }
            } else {
                httpMessageBuilder = new StringBuilder();
            }
        } else
            httpMessageBuilder = new StringBuilder();

        // for DEBUG level it show the headers and the body
        if (Level.DEBUG.equals(level)) {
            // TODO -> pending of a bug of Apigee
            // String headers = NeosdpContext.getFlowVariableAsString(messageContext, VAR_HEADERS);
            // if (headers != null) httpMessageBuilde.append("\n");
            httpMessageBuilder.append("\n").append(
                NeosdpContext.getFlowVariableAsString(messageContext, ApigeeConstants.APIGEE_FLOW_MESSAGEBYTES));
            // httpMessageBuilder.append("\n").append(NeosdpContext.getMessageContent(messageContext));
        }

        return httpMessageBuilder.toString();
    }

}
