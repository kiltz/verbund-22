package projekt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Validator {
    public int battleship, cruisers, destroyers, submarines;

    public Validator(int battleship, int cruisers, int destroyers, int submarines) {
        this.battleship = battleship;
        this.cruisers = cruisers;
        this.destroyers = destroyers;
        this.submarines = submarines;
    }

    public boolean validate(int[][] field) {
        List<List<int[]>> ships = new ArrayList<>();
        List<int[]> found_ship;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    found_ship = findAllParts(i, j, field);
                    for (int[] ship : found_ship) {
                        if (Arrays.equals(ship, new int[]{-1, -1})) return false;
                    }
                    if (!found_ship.isEmpty() && found_ship.size() <= 4) ships.add(found_ship);
                    else if (found_ship.size() > 4) return false;
                }
            }
        }

        int[] allShips = new int[4];
        for (List<int[]> ship : ships) {
            allShips[ship.size() - 1]++;
        }

        return allShips[0] == submarines && allShips[1] == destroyers &&
                allShips[2] == cruisers && allShips[3] == battleship;
    }

    private List<int[]> findAllParts(int i, int j, int[][] field) {
        List<int[]> ship = new ArrayList<>();
        int found_part;

        field[i][j] = 8;
        ship.add(new int[]{i, j});                                       // add first part  to the ship

        found_part = findNextPart(field, i, j, 0);           // find second part

        while (true) {
            if (found_part == 0) break;
            else if (found_part == -1) {                                // '-1' part has forbidden coordinates
                return Collections.singletonList(new int[]{-1, -1});
            } else {                                                      // find next part
                switch (found_part) {
                    case 1: // has a part on the right side
                        j++;
                        break;
                    case 2: // has a bottom part
                        i++;
                        break;
                    case 3: // has a part on the left side
                        j--;
                        break;
                    case 4: // has a part on top
                        i--;
                        break;
                }

                field[i][j] = 8;
                ship.add(new int[]{i, j});                       // add found part to the ship
                found_part = findNextPart(field, i, j, found_part);
            }
        }

        return ship;
    }

    //previous_part: '0'-no found parts, '1'-left, '2'-up, '3'-right, '4'-down
    //returns: '0'-ship hasn't other parts, '1'-right, '2'-down, '3'-left, '4'-up
    private int findNextPart(int[][] field, int i, int j, int previous_part) {
        int[][] search_coordinates = new int[][]{{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
        int[][] forbidden_coordinates;

        switch (previous_part) {
            case 1: // has a part on the left side
            case 3: // has a part on the right side
                forbidden_coordinates = new int[][]{{i + 1, j + 1}, {i - 1, j - 1}, {i - 1, j + 1},
                        {i + 1, j - 1}, {i + 1, j}, {i - 1, j}};
                break;
            case 2: // has a part on top
            case 4: // has a bottom part
                forbidden_coordinates = new int[][]{{i + 1, j + 1}, {i - 1, j - 1}, {i - 1, j + 1},
                        {i + 1, j - 1}, {i, j + 1}, {i, j - 1}};
                break;
            default: // has no found parts
                forbidden_coordinates = new int[][]{{i + 1, j + 1}, {i - 1, j - 1}, {i - 1, j + 1}, {i + 1, j - 1}};
                break;
        }

        for (int[] c : forbidden_coordinates) {
            try {
                if (field[c[0]][c[1]] == 1) return -1;
            } catch (IndexOutOfBoundsException ignored) {
            }
        }

        for (int[] c : search_coordinates) {
            try {
                if (field[c[0]][c[1]] == 1) {
                    if (c[1] > j) return 1;      // part right
                    else if (c[0] > i) return 2; // part down
                    else if (c[1] < j) return 3; // part left
                    else if (c[0] < i) return 4; // part up
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return 0;
    }
}