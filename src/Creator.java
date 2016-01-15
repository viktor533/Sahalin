import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Viktor on 09.10.2015.
 */

public class Creator {
    private Game game;

    public Creator() {
        game = new Game();
    }

    private static void menu() {
        System.out.println("0. Exit");
        System.out.println("1. Add resource");
        System.out.println("2. Add land");
        System.out.println("3. Add build");
        System.out.println("4. Settings");
        System.out.println("5. Out buildings");

        System.out.print("Input command: ");
    }

    public void speaker() {
        int command=-1;
        while (command != 0) {
            menu();
            Scanner in = new Scanner(System.in);
            command = in.nextInt();
            switch (command) {
                case 1:
                    System.out.print("Set resource name: ");
                    game.addResource(in.next());
                    break;
                case 2:
                    System.out.print("Set land name: ");
                    game.addLand(in.next());
                    break;
                case 3:
                    System.out.print("Set build name: ");
                    String name = in.next();
                    game.addBuild(name);
                    System.out.print("Input cost? (y/n): ");
                    char c;
                    if (Character.lowSurrogate(in.nextInt()) == 'y') {
                        Iterator<Resource> iterator = game.getResourceIterator();
                        Resource courentResource;
                        while (iterator.hasNext()) {
                            courentResource = iterator.next();
                            System.out.print("Number of " + courentResource.getName() + " : ");
                            game.setBuildCost(name, courentResource, in.nextInt());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Isn't now");
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Incorrect command! Try again.");
                    System.out.println();
                    break;
            }
        }
    }

}
