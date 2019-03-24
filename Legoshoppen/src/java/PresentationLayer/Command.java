package PresentationLayer;



import DBacces.OrderException;
import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register());
        commands.put("makeorder", new MakeOrder());
        commands.put("saveorder", new saveOrder());
        commands.put("logout", new Logout());
        commands.put("goback", new GoBack());
        
        
        
        
            
                }
        
        
    

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws OrderException, LoginSampleException;

}
