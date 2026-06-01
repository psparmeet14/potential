### Prompts

1. Interacting with the model for asking questions
2. Interpreting messages to get important information
3. Populating Java classes from natural language
4. Structuring input



### Terminologies

1. **Temperature**: A parameter that controls the randomness of the model's output. Lower values make the output more deterministic, while higher values increase creativity and variability.

    The temperature parameter typically ranges from 0.0 to 2.0.
   - The lowest value is 0.0 (most deterministic, least random).
   - The highest value is 2.0 (most creative, most random).
   Values outside this range may not be accepted by the API.

2. **Max Tokens**: The maximum number of tokens (words or word pieces) that the model can generate in a single response. This limits the length of the output.

3. **Several Advisors**:
   - MessageChatMemoryAdvisor: To maintain chat history
   - QuestionAnswerAdvisor: When working with RAG
   - SimpleLoggerAdvisor: To log the outgoing and incoming messages
   - SafeGuardAdvisor: To prevent the model from generating offensive content

4. **Embeddings**:
   - A vector representation of a word or phrase.
   - Numerical representations of text capturing semantic meaning.
   - Used to compare words or phrases for similarity.
   - We can measure cosine similarity between two embeddings to determine their similarity.
   - High similarity indicates that the words or phrases are semantically related, while low similarity suggests they are different in meaning.
   - Use cases: Document similarity, Search Engines, Recommendation Systems, Language Translation, etc.