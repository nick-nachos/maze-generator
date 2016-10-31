# maze-generator

This is a simple maze generator implemented with a DFS approach. The generator gets the dimentions of the maze via parameters and produces the corresponding maze in the standard output.
To run the binary, execute:
```sh
java -jar maze-generator-1.0.jar -w some_width -h some_height
```
The executable can be found as-is in the /dist directory of this repository.

Note that if your maze is too large to fit the console, you can always redirect output to a text file as such:
```sh
java -jar maze-generator-1.0.jar -w some_width -h some_height > my_maze_file.txt
```

Enjoy!

## Run requirements
1. JRE 1.7 or latter.

## Build requirements
To build from source you will need the following:
1. JDK 1.7 or latter.
2. Maven 3.3.9 or latter.

You can build by executing the following command:
```sh
mvn clean package
```

