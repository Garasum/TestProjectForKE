package behavioral;

/**
 * https://www.baeldung.com/chain-of-responsibility-pattern
 * <p>
 * Wikipedia defines Chain of Responsibility as a design pattern consisting of “a source of command objects and a series of processing objects”.
 * Each processing object in the chain is responsible for a certain type of command, and the processing is done,
 * it forwards the command to the next processor in the chain.
 * * The Chain of Responsibility pattern is handy for:
 * * Decoupling a sender and receiver of a command
 * * Picking a processing strategy at processing-time
 */
public class ChainOfResponsibility {
    class AuthenticationProvider {
    }

    class OAuthTokenProvider {
    }

    //Let's first create an abstract base class for our processors:
    public abstract class AuthenticationProcessor {
        public AuthenticationProcessor nextProcessor;

        // standard constructors
        public abstract boolean isAuthorized(AuthenticationProvider authProvider);
    }

    //Next, let's create concrete processors which extend AuthenticationProcessor:
    public class OAuthProcessor extends AuthenticationProcessor {

        public OAuthProcessor(AuthenticationProcessor nextProcessor) {
            super(nextProcessor);
        }

        @Override
        public boolean isAuthorized(AuthenticationProvider authProvider) {
            if (authProvider instanceof OAuthTokenProvider) {
                return true;
            } else if (nextProcessor != null) {
                return nextProcessor.isAuthorized(authProvider);
            }

            return false;
        }
    }

    public class UsernamePasswordProcessor extends AuthenticationProcessor {

        public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
            //super(nextProcessor);
        }

        @Override
        public boolean isAuthorized(AuthenticationProvider authProvider) {
            if (authProvider instanceof UsernamePasswordProvider) {
                return true;
            } else if (nextProcessor != null) {
                return nextProcessor.isAuthorized(authProvider);
            }
            return false;
        }
    }


    public static void main(String[] args) {
        ChainOfResponsibility chain = new ChainOfResponsibility();

//        private static AuthenticationProcessor getChainOfAuthProcessor() {
//            AuthenticationProcessor oAuthProcessor = new OAuthProcessor(null);
//            return new UsernamePasswordProcessor(oAuthProcessor);
//        }

        //The example above creates a chain of authentication processors: UsernamePasswordProcessor -> OAuthProcessor.

    }
}
