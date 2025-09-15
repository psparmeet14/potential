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