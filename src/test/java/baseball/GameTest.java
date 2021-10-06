package baseball;

import baseball.game.domain.Game;
import baseball.game.domain.GameResult;
import baseball.util.StringUtil;
import nextstep.utils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class GameTest {

    private static final String INPUT_DELIMITER = ",";

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:STRIKE,STRIKE,STRIKE",
                        "3,2,1:BALL,STRIKE,BALL",
                        "3,2,4:BALL,STRIKE,MISS",
                        "7,3,2:MISS,BALL,BALL",
                        "7,8,9:MISS,MISS,MISS"}, delimiter = ':')
    void judge_Test_같은_숫자가_같은_자리에_존재(String inputGuessStr, String expectResultStr) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 2, 3)
                    .thenReturn(1, 2, 3)
                    .thenReturn(1, 2, 3)
                    .thenReturn(1, 2, 3)
                    .thenReturn(1, 2, 3);

            Game game = Game.createGame();

            // run
            List<String> guesses = Arrays.asList(inputGuessStr.split(INPUT_DELIMITER));
            List<GameResult> gameResults =
                    game.judge(StringUtil.toIntegers(guesses));


            // verify
            List<String> expectResults = Arrays.asList(expectResultStr.split(INPUT_DELIMITER));
            assertThat(gameResults)
                    .isNotEmpty()
                    .startsWith(GameResult.valueOf(expectResults.get(0)))
                    .doesNotContainNull()
                    .containsSequence(GameResult.valueOf(expectResults.get(1)),
                            GameResult.valueOf(expectResults.get(2)));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE,STRIKE,STRIKE:true",
            "BALL,STRIKE,BALL:false",
            "MISS,MISS,MISS:false"}, delimiter = ':')
    void judgeEndGame(String gameResultStr, String expectEndState) {
        // given
        String[] gameResultSplits = gameResultStr.split(INPUT_DELIMITER);
        List<GameResult> gameResults = new ArrayList<>();
        for (String gameResultSplit : gameResultSplits) {
            gameResults.add(GameResult.valueOf(gameResultSplit));
        }

        // when
        Game game = Game.createGame();
        game.judgeEnd(gameResults);

        // then
        assertThat(Boolean.valueOf(expectEndState))
                .isEqualTo(game.isEnd());
    }
}