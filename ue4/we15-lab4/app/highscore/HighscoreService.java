package highscore;

import models.JeopardyGame;
import models.JeopardyUser;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class HighscoreService {

    private static SOAPConnectionFactory soapConnectionFactory;
    private static MessageFactory messageFactory;
    private static String highscoreURL = "http://playground.big.tuwien.ac.at:8080/highscoreservice/PublishHighScoreService?wsdl";
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

            SOAPPart soapPart = soapMessage.getSOAPPart();

            // SOAP Envelope
            SOAPEnvelope soapEnv = soapPart.getEnvelope();
            soapEnv.addNamespaceDeclaration("data", dataNamespace);

            SOAPBody soapBody = soapEnv.getBody();

            fillBody(soapBody, game);

            try {
                System.out.println("SOAP Message:");
                soapMessage.writeTo(System.out);
                System.out.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            SOAPMessage response = soapConnection.call(soapMessage, highscoreURL);

            UUID = getUuidFromResponse(response);

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

    private static String getUuidFromResponse(SOAPMessage soapMessage) throws SOAPException {
        String val = "";

        try {
            SOAPBody body = soapMessage.getSOAPBody();
            Iterator it = body.getChildElements();
            while (it.hasNext()) {
                SOAPBodyElement elem = (SOAPBodyElement) it.next();
                val = elem.getValue();
            }
        } catch (SOAPException e) {
            throw new SOAPException("ERROR getting UUID");
        }
        return val;
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
        SOAPElement userkeyElem = highscorerequestElem.addChildElement("UserKey", "data");
        userkeyElem.addTextNode("3ke93-gue34-dkeu9");

        SOAPElement userDataElem = highscorerequestElem.addChildElement(new QName(dataNamespace, "UserData", "data"));
        SOAPElement loserElem = userDataElem.addChildElement("Loser");
        SOAPElement winnerElem = userDataElem.addChildElement("Winner");

        JeopardyUser loser = game.getLoser().getUser();
        String loserBirthdate  = loser.getBirthDate() == null ? "1990-01-12" : (new SimpleDateFormat(requiredDateFormat)).format(loser.getBirthDate());
        loser.setFirstName(loser.getFirstName() == null || loser.getFirstName().length() == 0 ? "Jane" : loser.getFirstName());
        loser.setLastName(loser.getLastName() == null || loser.getLastName().length() == 0 ? "Doe" : loser.getLastName());

        JeopardyUser winner = game.getWinner().getUser();
        String winnerBirthdate  = winner.getBirthDate() == null ? "1990-01-12" : (new SimpleDateFormat(requiredDateFormat)).format(winner.getBirthDate());
        winner.setFirstName(winner.getFirstName() == null || winner.getFirstName().length() == 0 ? "Jane" : winner.getFirstName());
        winner.setLastName(winner.getLastName() == null || winner.getLastName().length() == 0 ? "Doe" : winner.getLastName());

        loserElem.addAttribute(new QName("Gender"), loser.getGender().name());
        loserElem.addAttribute(new QName("BirthDate"), loserBirthdate);
        SOAPElement loserFirstname = loserElem.addChildElement("FirstName").addTextNode(loser.getFirstName());
        SOAPElement loserLastName = loserElem.addChildElement("LastName").addTextNode(loser.getLastName());
        SOAPElement loserPassword = loserElem.addChildElement("Password").addTextNode("");
        SOAPElement loserPoints = loserElem.addChildElement("Points").addTextNode(Integer.toString(game.getLoser().getProfit()));

        winnerElem.addAttribute(new QName("Gender"), winner.getGender().name());
        winnerElem.addAttribute(new QName("BirthDate"), winnerBirthdate);
        SOAPElement winnerFirstname = winnerElem.addChildElement("FirstName").addTextNode(winner.getFirstName());
        SOAPElement winnerLastName = winnerElem.addChildElement("LastName").addTextNode(winner.getLastName());
        SOAPElement winnerPassword = winnerElem.addChildElement("Password").addTextNode("");
        SOAPElement winnerPoints = winnerElem.addChildElement("Points").addTextNode(Integer.toString(game.getWinner().getProfit()));
    }
}