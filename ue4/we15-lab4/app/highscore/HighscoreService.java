package highscore;

import javax.xml.soap.*;
import models.Category;
import models.JeopardyDAO;
import models.JeopardyGame;
import models.JeopardyUser;
import javax.xml.namespace.QName;
import play.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class HighscoreService {

    private static SOAPConnectionFactory soapConnectionFactory;
    private static MessageFactory messageFactory;
    private static String highscoreURL = "http://playground.big.tuwien.ac.at:8080/highscoreservice";
    private static String userKey = "3ke93-gue34-dkeu9";
    private static String dataNamespace = "http://big.tuwien.ac.at/we/highscore/data";
    private static String requiredDateFormat = "yyyy-MM-dd";

    public HighscoreService() throws HighscoreException {
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
            messageFactory = MessageFactory.newInstance();
        } catch (SOAPException e) {
            throw new HighscoreException("Could not initializue SOAPConnection");
        } catch (UnsupportedOperationException e) {
            throw new HighscoreException("Unsupported Operation");
        }
    }

    public static String postToBoard(JeopardyGame game) throws HighscoreException {

        SOAPConnection soapConnection = null;
        String UUID = "";

        try {
            soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage soapMessage = messageFactory.createMessage();



            System.out.println("DEBUG 1");
            SOAPPart soapPart = soapMessage.getSOAPPart();

            System.out.println("DEBUG 2");

            // SOAP Envelope
            SOAPEnvelope soapEnv = soapPart.getEnvelope();

            soapEnv.addNamespaceDeclaration("data", dataNamespace);

            System.out.println("DEBUG 3");

            SOAPBody soapBody = soapEnv.getBody();
            System.out.println("DEBUG 4");

            fillBody(soapBody, game);
            System.out.println("DEBUG 31");

            try {
                System.out.println();
                System.out.println("SOAP Message:");
                soapMessage.writeTo(System.out);
                System.out.println();
                System.out.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println("DEBUG 1213331");
            SOAPMessage response = soapConnection.call(soapMessage, highscoreURL);
            //System.out.println("Reponse looks like this:\n"+response.toString());
            System.out.println("BLABLA");
            
            try {
                UUID = getUuidFromResponse(response);
            } catch(Exception e) {
                throw new HighscoreException("exception 1");
            }

        } catch(SOAPException e) {
            throw new HighscoreException("exception 2");
        } finally {
            if(soapConnection != null) {
                try {
                    soapConnection.close();
                } catch(SOAPException e) {
                    throw new HighscoreException("Connection couldn't be closed!");
                }
            }
        }

        return UUID;
    }

    private static String getUuidFromResponse(SOAPMessage soapMessage) {
        return "test";
    }

    public static void fillBody(SOAPBody soapBody, JeopardyGame game) throws SOAPException {

        // SOAP Envelope
        //SOAPEnvelope envelope = soapPart.getEnvelope();

        /*
        * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:data="http://big.tuwien.ac.at/we/highscore/data">
        <soapenv:Header/>
            <soapenv:Body>
                <data:HighScoreRequest>
                    <data:UserKey>3ke93-gue34-dkeu9</data:UserKey>
                    <data:UserData>
                        <Loser Gender="male" BirthDate="1990-01-12">
                            <FirstName>Hans</FirstName>
                            <LastName>Mustermann</LastName>
                            <Password></Password>
                            <Points>12</Points>
                        </Loser>
                        <Winner Gender="female" BirthDate="1981-01-12">
                            <FirstName>Gerda</FirstName>
                            <LastName>Haydn</LastName>
                            <Password></Password>
                            <Points>12</Points>
                        </Winner>
                    </data:UserData>
                </data:HighScoreRequest>
            </soapenv:Body>
        </soapenv:Envelope>
        * */

        SOAPElement highscorerequestElem = soapBody.addChildElement("HighScoreRequest", "data");
        System.out.println("DEBUG 5");
        SOAPElement userkeyElem = highscorerequestElem.addChildElement("UserKey", "data");
        System.out.println("DEBUG 6");
        userkeyElem.addTextNode("3ke93-gue34-dkeu9");
        System.out.println("DEBUG 7");

        SOAPElement userDataElem = highscorerequestElem.addChildElement(new QName(dataNamespace, "UserData", "data"));
        System.out.println("DEBUG 8");
        SOAPElement loserElem = userDataElem.addChildElement("Loser");
        System.out.println("DEBUG 9");
        SOAPElement winnerElem = userDataElem.addChildElement("Winner");
        System.out.println("DEBUG 10");

        JeopardyUser loser = game.getLoser().getUser();
        System.out.println("DEBUG 11");
        String loserBirthdate  = loser.getBirthDate() == null ? "" : (new SimpleDateFormat(requiredDateFormat)).format(loser.getBirthDate());
        System.out.println("DEBUG 12");
        loser.setFirstName(loser.getFirstName() == null ? "" : loser.getFirstName());
        System.out.println("DEBUG 13");
        loser.setLastName(loser.getLastName() == null ? "" : loser.getLastName());
        System.out.println("DEBUG 14");

        JeopardyUser winner = game.getWinner().getUser();
        System.out.println("DEBUG 15");
        String winnerBirthdate  = winner.getBirthDate() == null ? "" : (new SimpleDateFormat(requiredDateFormat)).format(winner.getBirthDate());
        System.out.println("DEBUG 16");
        winner.setFirstName(winner.getFirstName() == null ? "" : winner.getFirstName());
        System.out.println("DEBUG 17");
        winner.setLastName(winner.getLastName() == null ? "" : winner.getLastName());
        System.out.println("DEBUG 18");

        loserElem.addAttribute(new QName("Gender"), loser.getGender().name());
        System.out.println("DEBUG 19");
        loserElem.addAttribute(new QName("BirthDate"), loserBirthdate);
        System.out.println("DEBUG 20");
        SOAPElement loserFirstname = loserElem.addChildElement("FirstName").addTextNode(loser.getFirstName());
        System.out.println("DEBUG 21");
        SOAPElement loserLastName = loserElem.addChildElement("LastName").addTextNode(loser.getLastName());
        System.out.println("DEBUG 22");
        SOAPElement loserPassword = loserElem.addChildElement("Password").addTextNode("");
        System.out.println("DEBUG 23");
        SOAPElement loserPoints = loserElem.addChildElement("Points").addTextNode(Integer.toString(game.getLoser().getProfit()));
        System.out.println("DEBUG 24");

        winnerElem.addAttribute(new QName("Gender"), winner.getGender().name());
        System.out.println("DEBUG 25");
        winnerElem.addAttribute(new QName("BirthDate"), winnerBirthdate);
        System.out.println("DEBUG 26");
        SOAPElement winnerFirstname = winnerElem.addChildElement("FirstName").addTextNode(winner.getFirstName());
        System.out.println("DEBUG 27");
        SOAPElement winnerLastName = winnerElem.addChildElement("LastName").addTextNode(winner.getLastName());
        System.out.println("DEBUG 28");
        SOAPElement winnerPassword = winnerElem.addChildElement("Password").addTextNode("");
        System.out.println("DEBUG 29");
        SOAPElement winnerPoints = winnerElem.addChildElement("Points").addTextNode(Integer.toString(game.getWinner().getProfit()));

        System.out.println("DEBUG 30");
        //MimeHeaders headers = soapMessage.getMimeHeaders();

        //Logger.info(soapMessage.toString());
    }
}