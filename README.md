# MLS

/** 
 * Derives a list of suggestions from the given token stream. The given list of tokens reflect a sorted list of tokens of a text. Each token reflects either a single word or a punctuation mark like :.? A suggestion is either a single word or a combination of following words  (delimited by a single space) and does not include any stopWord or a single character. 
Combined word suggestions can maximal include MAX_COMBINED_TOKENS of following words. 

Example: Stop Words = {"is", "a", "can", "the"} 

Token Stream = {"The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I", "like", "chewing", "gum", "." }

Suggestions:
"beautiful",
"beautiful girl",
"beautiful girl from",
"girl",
"girl from",
"from",
"farmers",
"farmers market",
"market",
"like",
"like chewing",
"like chewing gum",
"chewing",
"chewing gum",
"gum"
  */