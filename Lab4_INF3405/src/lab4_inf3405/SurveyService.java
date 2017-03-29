/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_inf3405;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Simel
 */


public class SurveyService implements Runnable {

    private Socket socket_;
    private Scanner in_;
    private PrintWriter out_;
    private Survey survey_;

    /**
     * Construct a service object that processes commands
     * from a socket for a survey
     * @param socket the socket
     * @param survey the survey
     */
    SurveyService(Socket socket, Survey survey) {
        
        socket_ = socket;
        survey_ = survey;
    }
    
    @Override
    public void run() {
        
        try {
            
            in_ = new Scanner(socket_.getInputStream());
            out_ = new PrintWriter(socket_.getOutputStream());
            doService();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }

    private void doService() {
        
        while (true) {            
            
            if(!in_.hasNext()) 
                return;
            
            String command = in_.next();
            
            if ( command.equals("CLOSE"))
                return;
            else
                processCommand(command);
            
        }
    }

    private void processCommand(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
