# 🔴🔴🔴🔴 __CONNECT 4__ 🟡🟡🟡🟡
## A digital version of the classic 2 player game with the same name [(wiki/Connect_Four)](https://en.wikipedia.org/wiki/Connect_Four). Learning project in Java.
___

![GitHub contributors](https://img.shields.io/github/contributors/DRBondyaleJuez/Connect4)
![GitHub repo size](https://img.shields.io/github/repo-size/DRBondyaleJuez/Connect4)
___

## __DESCRIPTION__
This code was used as a training exercise to practice coding in java. 

The design pattern followed by the code is based on the Model-View-Controller [(MVC)](https://developer.mozilla.org/en-US/docs/Glossary/MVC) or more precisely Model-View-ViewController-Controller pattern.

The view is managed using the JavaFXML framework [(MVN repository link)](https://mvnrepository.com/artifact/org.openjfx/javafx-fxml).

<div style="text-align: center;">

![Imagen1](https://user-images.githubusercontent.com/98281752/224577245-0db6b552-275c-49cd-9773-451bf4beb88b.png)

</div>

___
___

## __USAGE__
This is a simple game designed while learning how to code with Java. Two players are needed to play this game of connect four no single player mode has been implemented. To play they must click on simple visual interface representation of the grided vertical board.

The program detects the column where the player clicked and places chip in the lowest possible row similar to the analogue game. then changes the player's turn until it detects either player has won. Then the game can be restarted.

<div style="text-align: center;">

![connect4](https://user-images.githubusercontent.com/98281752/223207146-a2792d5b-106d-44d3-85e7-239f6720590e.gif)

</div>

___
___

## __INSTALLATION INSTRUCTIONS__
### __For IDE:__
<!-- OL -->
1. Clone the repository in your local server
2. Run the project's Main Class in your IDE
 
### __For Ubuntu (In terminal):__
<!-- OL -->
1. If necessary [install java version 11 or higher](https://stackoverflow.com/questions/52504825/how-to-install-jdk-11-under-ubuntu)


    ```bash 
        sudo apt-get install openjdk-11-jdk
    ```


2. If necessary [install maven version 3.6.3 or higher](https://phoenixnap.com/kb/install-maven-on-ubuntu)

	```bash 
    	sudo apt install maven
    ``` 

3. If necessary [install git](https://www.digitalocean.com/community/tutorials/how-to-install-git-on-ubuntu-20-04)

	```bash 
        apt install git
    ```

4. Clone the repository	

	```bash 
        git clone https://github.com/DRBondyaleJuez/Connect4.git
    ```

5. Go to the project folder. Make sure the [pom.xml](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) is there.

6.  Create [.jar file](https://en.wikipedia.org/wiki/JAR_(file_format)) executable in target folder using the following code:

    ```bash
		mvn install 
    ```

7. This code uses javafxml so we recommend the use of the following code  to run the program :

    ([*Source*](https://github.com/openjfx/javafx-maven-plugin))

	```bash 
        mvn javafx:run
    ```

___
___
## __INSTRUCTIONS FOR CONTRIBUTORS__
The objective of the project was to practice and apply java knowledge. No further contributions will be need all of this is just a training excercise.  

Hope you may find the code useful and please acknowledge its origin and authorship if use for any other purpose.
