package connvertexC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SuggestionsBuilder {

	public static void main(String[] args) {
		String stopWords[] = { "is", "a", "can", "the", "The" };
		String tokenStrings[] = { "The", "beautiful", "girl", "from", "the",
				"farmers", "market", ".", "I", "like", "chewing", "gum", "." };

		List<String> stopWordsList = Arrays.asList(stopWords);
		List<String> tokenStringsList = Arrays.asList(tokenStrings);

		Set<String> suggestions = new SuggestionsBuilder()
				.retrieveSuggestionsList(stopWordsList, tokenStringsList);

		System.out.println("Suggestions List is: " + suggestions.toString());
	}

	/**
	 * used to retrieve list of suggestions from the given list of "Stop Words"
	 * and "Token Stream" resp.
	 * 
	 * @param stopWordsList
	 *            represents list of "Stop Words"
	 * @param tokenStringsList
	 *            represents list of "Token Stream"
	 * @return suggestionsList represents list of possible suggestions
	 */
	Set<String> retrieveSuggestionsList(List<String> stopWordsList,
			List<String> tokenStringsList) {
		LinkedHashMap<Integer, List<String>> stopWordsDelimiterMap = new LinkedHashMap<Integer, List<String>>();
		int index = 0;

		for (String token : tokenStringsList) {
			if (stopWordsList.contains(token) || token.length() == 1) {
				index++;
				continue;
			}
			if (stopWordsDelimiterMap.get(index) == null) {
				List<String> tempList = new ArrayList<>();
				tempList.add(token);
				stopWordsDelimiterMap.put(index, tempList);
			} else {
				stopWordsDelimiterMap.get(index).add(token);
			}
		}

		LinkedHashSet<String> suggestionsList = new LinkedHashSet<>();

		Collection<List<String>> stopWordsDelimiterValueSet = stopWordsDelimiterMap
				.values();

		for (List<String> list : stopWordsDelimiterValueSet) {
			Object[] arr = list.toArray();
			for (int i = 0; i < arr.length - 1; i++) {
				StringBuilder str = new StringBuilder((String) arr[i]);
				suggestionsList.add(str.toString());
				for (int j = i + 1; j < arr.length; j++) {
					str.append(" " + arr[j]);
					suggestionsList.add(str.toString());
				}
				suggestionsList.add(str.toString());
			}
			suggestionsList.add((String) arr[arr.length - 1]);
		}

		return suggestionsList;
	}

}
