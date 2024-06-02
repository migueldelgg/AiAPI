# Spring Open AI API

## Installation
Install the Maven dependency manager using the following tutorial:
[Maven Tutorial](https://www.youtube.com/watch?v=rfhTnfbBQcY).

Install IntelliJ IDEA Community Edition to run the project:
[IntelliJ IDEA Community Edition Download](https://www.youtube.com/watch?v=3h46Tsql8t4).

Install Git and clone the project using Git Bash:
[Git Installation and Project Cloning Tutorial](https://www.youtube.com/watch?v=_hZf1teRFNg&t=1676s&pp=ygUZaW5zdGFsZSBvIGdpdCBuZWxpbyBhbHZlcw%3D%3D).

## API Endpoints

The application has a single endpoint:
GET /startupidea/chat

## Usage
To make the application work, you need to include your OpenAI API license key. To do this, access the application.properties file in the project. Navigate to the root project directory and follow the path:

`spring-boot-chatgpt → src → main → resources → application.properties`



In the file, open it with a text editor and include the code:
spring.ai.openai.api-key= your api key

To run the application, with the project open in IntelliJ, navigate to the class SpringBootChatgptApplication by following this path:
`src -> java -> br.com.migueldelgado.spring_boot_chatgpt -> SpringBootChatgptApplication`

Once you're in the SpringBootChatgptApplication class, press Shift+F10 to run the application.

The question to be asked in the chat should be provided in the URL using the format:
- http://localhost:8080/startupidea/chat/?userPrompt=[QUESTION_TO_BE_ASKED]

## Swagger
For easier usage of the application, an endpoint using the Swagger documentation tool has been provided:
[Swagger UI Endpoint](http://localhost:8080/swagger-ui/index.html#/).

On the page, scroll down to the "Try it out" section, click on it, and in the query parameter field, enter your input for the chat.
![image](https://github.com/migueldelgg/spring-ai-api/assets/150628051/66ae2bfa-713b-4412-9b5f-974ecfac6583)
