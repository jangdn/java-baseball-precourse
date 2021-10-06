package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.util.StringUtil;

class GameHintTest {

	private static final String INPUT_DELIMITER = ",";

	@ParameterizedTest
	@CsvSource(value = {"STRIKE,STRIKE,STRIKE:3,0,0",
			"BALL,STRIKE,BALL:1,2,0",
			"BALL,STRIKE,MISS:1,1,1",
			"MISS,BALL,BALL:0,2,1",
			"MISS,MISS,MISS:0,0,3"}, delimiter = ':')
	void calculate_test_GameResults_따른_count(String gameResultStr, String expectCountListStr) {
		// given
		String[] gameResultSplits = gameResultStr.split(INPUT_DELIMITER);
		List<GameResult> gameResults = new ArrayList<>();
		for (String gameResultSplit : gameResultSplits) {
			gameResults.add(GameResult.valueOf(gameResultSplit));
		}

		// when
		GameHint hintBy = GameHint.createBy(gameResults);

		// then
		List<Integer> expectCounts = StringUtil.toIntegers(Arrays.asList(expectCountListStr.split(INPUT_DELIMITER)));
		assertThat(expectCounts)
				.isNotEmpty()
				.startsWith(hintBy.getStrikeCount())
				.doesNotContainNull()
				.containsSequence(hintBy.getBallCount(), hintBy.getMissCount());

	}
}