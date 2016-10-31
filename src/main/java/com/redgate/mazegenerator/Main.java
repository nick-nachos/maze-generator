package com.redgate.mazegenerator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

    private static final String PARAM_WIDTH = "w";
    private static final String PARAM_HEIGHT = "h";
    
    public static void main(String[] args) {
        CommandLine cmd = parseCliArgs(args);
        int width = getIntArgValue(cmd, PARAM_WIDTH);
        int height = getIntArgValue(cmd, PARAM_HEIGHT);
        Maze m = new Maze(width, height);
        m.accept(new DfsMazeVisitor());
        System.out.println(m);
    }
    
    private static CommandLine parseCliArgs(String[] args) {
        Options cliOptions = createCliOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine result = null;
        
        try {
            result = parser.parse(cliOptions, args);
        }
        catch (ParseException ex) {
            System.out.println(ex.getMessage());
            new HelpFormatter().printHelp("maze-generator", cliOptions);
            System.exit(1);
        }
        
        return result;
    }

    private static Options createCliOptions() {
        Options options = new Options();
        Option width = new Option(PARAM_WIDTH, "width", true, "the width of the maze");
        width.setRequired(true);
        options.addOption(width);
        Option height = new Option(PARAM_HEIGHT, "height", true, "the height of the maze");
        height.setRequired(true);
        options.addOption(height);
        
        return options;
    }
    
    private static int getIntArgValue(CommandLine cmd, String argName) {
        String rawArgValue = cmd.getOptionValue(argName);
        int result = 0;
        
        try {
            result = Integer.parseInt(rawArgValue);
        }
        catch (NumberFormatException ex) {
            String msg = String.format("Malformed numeric value for arg -%s: %s", argName, rawArgValue);
            System.out.println(msg);
            System.exit(1);
        }
        
        return result;
    }
    
}
