package com.racloop.ti.poc.name;

import com.optimaize.anythingworks.common.host.Host;
import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.lib.NameApiModeFactory;
import org.nameapi.client.lib.NameApiPortUrlFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.parser.personnameparser.PersonNameParserCommand;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.context.ContextBuilder;
import org.nameapi.ontology5.input.context.Priority;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.nameapi.ontology5.input.entities.person.name.builder.NameBuilders;
import org.nameapi.ontology5.services.parser.personnameparser.ParsedPerson;
import org.nameapi.ontology5.services.parser.personnameparser.ParsedPersonMatch;
import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;

import java.util.List;

public class NameParser {

    private final String apiKey;
    private final String hostName;
    private final String port;
    private final Context context;
    private final CommandExecutor executor;
    private final Mode mode;

    public NameParser(String apiKey, String hostName, String port) {
        this.apiKey = apiKey;
        this.hostName = hostName;
        this.port = port;
        context = new ContextBuilder()
                .priority(Priority.REALTIME)
                .build();
        executor = NameApiRemoteExecutors.get();
        mode = NameApiModeFactory.withContext(
                "8d27c0030fe2ea1b5a01538cc3f96a1f-user1",
                context,
                //the default and live server is "api.nameapi.org"
                //we're using the latest release candidate with latest features here:
                new Host("api.nameapi.org", 80), NameApiPortUrlFactory.versionLatestStable()
        );
    }

    public NameParser() {
        this("8d27c0030fe2ea1b5a01538cc3f96a1f-user1", "api.nameapi.org", "80");
    }

    public PersonNameParserResult parseName(String nameString) throws Exception {
        InputPersonName name = NameBuilders.western().fullname(nameString).build();
        InputPerson inputPerson = new NaturalInputPersonBuilder().name(name).build();

        PersonNameParserCommand command = new PersonNameParserCommand();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        return result;
    }

    public static void printName(PersonNameParserResult result) {
        ParsedPersonMatch personMatch = result.getBestMatch();
        print(personMatch);
    }

    public static void printNames(PersonNameParserResult result) {
        List<ParsedPersonMatch> persons = result.getMatches();
        for (ParsedPersonMatch person : persons) {
            print(person);
        }
    }

    private static void print(ParsedPersonMatch personMatch) {
        System.out.println("Confidence : "  + personMatch.getConfidence());
        System.out.println("Likeliness : "  + personMatch.getLikeliness());
        ParsedPerson parsedPerson = personMatch.getParsedPerson();
        System.out.println("Given Name : "  + parsedPerson.getAddressingGivenName());
        System.out.println("Surname : "  + parsedPerson.getAddressingSurname());

    }
}
