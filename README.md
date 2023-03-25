# DevQATask

## Requirements

For building and running the application you need:

- [JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
- [Chrome Driver](https://chromedriver.chromium.org/)
- [Intellij](https://www.jetbrains.com/idea/)


## Running the application locally
Before running the application, make sure you have right version of a chrome driver. I have used version 11.
If you need another version put it in
```
.\DevQATask\src\test\resources
```

## Usage
Using Selenium, this program opens ```https://www.playtech.ee``` in web browser. Clicks on the internship tab (using coordinates), verifies if "Development QA Engineer (Intern)" position is shown on the page and writes the result into ```.\DevQATask\src\test\resources\output.txt``` file
```
