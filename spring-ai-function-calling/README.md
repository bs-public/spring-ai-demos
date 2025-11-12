# spring-ai-function-calling

### Travel Planner Request
```
curl --location 'http://localhost:8080/v1/chat/completions' \
--header 'Content-Type: application/json' \
--data '{
  "message": "Plan a 3-day vacation in a Test city including weather, tourist places and estimated budget.",
  "systemPrompt": "You are a helpful travel planner."
}'
```
