# Quiz Game Application

This Java application is a quiz game where users can sign up, log in, and participate in quizzes with configurable settings such as category, difficulty, and question type. It utilizes an external API to fetch quiz questions and allows users to submit their scores to a leaderboard.

## Classes Overview

### DatabaseService.java

- Manages user data storage in a mock database file.
- Provides methods for adding users and checking user login credentials.

### UserService.java

- Facilitates user-related operations such as signup and login.
- Utilizes DatabaseService for database interactions.

### Leaderboard.java

- Manages the leaderboard functionality.
- Allows users to submit scores and displays the leaderboard.

### Menu.java

- Handles the user interface for displaying menus and interacting with users.
- Manages navigation between different parts of the application.

### Quiz.java

- Represents a quiz object containing quiz questions and metadata.
- Utilized by QuizGame to fetch and display quiz questions.

### QuizGame.java

- Controls the quiz game logic.
- Fetches quiz questions from an external API based on user settings.
- Quizzes users with fetched questions and calculates scores.

### QuizSettings.java

- Manages the settings for configuring quizzes.
- Allows users to set options such as category, difficulty, and question type.

### Quizzer.java

- Handles the quizzing process by presenting questions to users and processing answers.
- Utilizes Result objects to represent quiz questions.

### Result.java

- Represents a result of a quiz question.
- Contains information such as question text, category, difficulty, correct answer, and incorrect answers.

### User.java

- Represents a user of the application.
- Contains user information such as username and password.

### MessagePrinter.java

- Provides a utility for printing formatted messages to the console in a box format.

## Abstract Explanation:

The Quiz Game Application is designed to provide users with an interactive platform to participate in quizzes with configurable settings. It allows users to sign up, log in, and play quizzes fetched from an external API. The application also features a leaderboard where users can submit their scores.

## Relationships between Classes:

1. **DatabaseService <-> UserService**:
   - `DatabaseService` manages user data storage and provides methods for adding users and checking login credentials.
   - `UserService` utilizes `DatabaseService` for user-related operations such as signup and login.

2. **Leaderboard <-> User**:
   - `Leaderboard` manages the leaderboard functionality, allowing users to submit scores and displaying the leaderboard.
   - `User` represents individual users of the application who can participate in quizzes and submit scores to the leaderboard.

3. **Menu <-> UserService, Leaderboard, QuizGame**:
   - `Menu` handles the user interface, displaying menus and interacting with users.
   - `Menu` interacts with `UserService` for user authentication, `Leaderboard` for displaying scores, and `QuizGame` for starting quizzes.

4. **QuizGame <-> QuizSettings, Quizzer, Quiz**:
   - `QuizGame` controls the quiz logic, fetching quiz questions based on user settings and quizzing users.
   - `QuizSettings` manages quiz configuration settings such as category, difficulty, and question type.
   - `Quizzer` handles the quizzing process by presenting questions to users and processing answers.
   - `Quiz` represents a quiz object containing quiz questions and metadata fetched from an external API.

5. **MessagePrinter**:
   - `MessagePrinter` provides utility for printing formatted messages to the console, enhancing the user experience by presenting information in a visually appealing manner.

Overall, the classes in the Quiz Game Application are designed to work together cohesively, each serving a specific purpose in the application's functionality. The relationships between classes facilitate the flow of data and control, enabling users to seamlessly interact with the application and enjoy the quiz experience.

## Usage

1. Compile the Java files.
2. Run the Main class to start the application.
3. Follow the on-screen prompts to sign up, log in, and participate in quizzes.

## Dependencies

- Gson library for JSON deserialization.
- Java HttpClient library for HTTP requests.

## Contributors

- [John Doe](https://replit.com/@1Anonymous1) - Lead Developer
- 

