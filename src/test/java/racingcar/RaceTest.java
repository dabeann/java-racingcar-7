package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.race.Race;

class RaceTest {

    private Race race;
    private String[] carNames;

    @BeforeEach
    void setUp() {
        carNames = new String[]{"car1", "car2", "car3"};
        race = new Race(carNames);
    }

    @Test
    void raceInitializationTest() {
        assertThat(race).isNotNull();
    }

    @Test
    void raceStartTest() {
        race.start(5);
        assertThat(race.getCars()).hasSize(carNames.length);
    }

    @Test
    void raceCarPositionUpdateTest() {
        int initialPosition = race.getCars().get(0).getPosition();
        race.start(1);
        assertThat(race.getCars().get(0).getPosition())
                .isGreaterThanOrEqualTo(initialPosition);
    }

    @Test
    void raceInvalidInputTest() {
        String[] invalidNames = {"", " ", "carWithVeryLongName"};
        assertThatThrownBy(() -> new Race(invalidNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
