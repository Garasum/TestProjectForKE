package creational;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Orest on 2/22/2017.
 */
public class FactoryMethod {

    public enum LoggingProviders{
        Enterprise,
        Log4Net
    }

    public interface ILogger{
        public void LogMessage(String message);
        public void LogError(String message);
        public void LogVerboseInformation(String message);
    }

    public class EnterpriseLogger implements ILogger{

       public void LogMessage(String message) {
           System.out.println(String.format("%1$s : %2$s ", "Enterprise", message));
       }

       public void LogError(String message) {
            throw new NotImplementedException();
       }

       public void LogVerboseInformation(String message) {
           throw new NotImplementedException();
       }
   }

    public class Log4NetLogger implements ILogger{

        public void LogMessage(String message) {
            System.out.println(String.format("%1$s : %2$s ", "Log4Net", message));
        }

        public void LogError(String message) {
            throw new NotImplementedException();
        }

        public void LogVerboseInformation(String message) {
            throw new NotImplementedException();
        }
    }

    public class LoggerProviderFactory {

        public ILogger GetLoggingProvider(LoggingProviders loggingProviders){
            switch (loggingProviders){
                case  Enterprise:
                    return new EnterpriseLogger();
                case Log4Net:
                    return new Log4NetLogger();
                default:
                    return new EnterpriseLogger();
            }
        }
    }

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        LoggingProviders providerType = GetTypeOfLoggingProviderFromConfigFile();
        ILogger logger = factoryMethod.new LoggerProviderFactory().GetLoggingProvider(providerType);
        logger.LogMessage("Hello Factory Method Design Pattern.");
       // logger.LogError("123");
        logger = factoryMethod.new LoggerProviderFactory().GetLoggingProvider(LoggingProviders.Enterprise);
        logger.LogMessage("Hello Factory Method Design Pattern.");

    }

    private static LoggingProviders GetTypeOfLoggingProviderFromConfigFile() {
        return LoggingProviders.Log4Net;
    }

}

