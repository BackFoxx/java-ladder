package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {

    public static final int MAX_LENGTH = 5;
    public static final String LENGTH_OVER_MAX_ERROR_MESSAGE = "5글자 이하를 입력해주세요.";
    public static final String LENGTH_BLACK_ERROR_MESSAGE = "한글자 이상 입력해주세요.";
    private final String name;

    private Player(final String name) {
        this.name = name;
    }

    public static Player of(final String name) {
        validateName(name);
        return new Player(name);
    }

    public static List<Player> ofMultiple(final List<String> names) {
        return names.stream().map(Player::of)
                .collect(Collectors.toList());
    }

    private static void validateName(final String name) {
        validateBlank(name);
        validateMaxLength(name);
    }

    private static void validateMaxLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_OVER_MAX_ERROR_MESSAGE);
        }
    }

    private static void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(LENGTH_BLACK_ERROR_MESSAGE);
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object name) {
        if (this == name) return true;
        if (name == null || getClass() != name.getClass()) return false;
        Player anotherPlayer = (Player) name;
        return this.name.equals(anotherPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
