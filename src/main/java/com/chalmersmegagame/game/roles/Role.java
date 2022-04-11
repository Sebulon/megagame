package com.chalmersmegagame.game.roles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum Role {
    Captain("captain.md");

    private String description = "";
    private String miniGame = "";

    Role(String file) {
        try {
            File descriptionFile = new File("./src/main/resources/roles/description/" + file);
            Scanner scanner = new Scanner(descriptionFile);

            String title = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (title == null) {
                    title = getTitle(line);
                    continue;
                }

                if (line.length() == 0 || line.charAt(0) == '\n') {
                    title = null;
                    continue;
                }

                addTextToRightAttribute(title, line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public String getMiniGameDescription() {
        return miniGame;
    }

    private String getTitle(String string) {
        return string.toLowerCase().replaceAll("[#: ]", "");
    }

    private void addTextToRightAttribute(String title, String text) {
        switch (title) {
            case "description":
                description += text;
                break;
            case "mini-game":
                miniGame += text;
                break;
            default:
                throw new IllegalArgumentException("The title " + title + " has not been implemented");
        }
    }
}
