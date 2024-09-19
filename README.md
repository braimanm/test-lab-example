# test-lab-example

This is a test automation example using the **UITAF** open source project for UI testing. The test is designed to test the Vehicle Insurance Quote application located at https://uitaf.org/test/ using the Chrome browser.

The test assumes that Chrome browser is installed on the target machine where this test should run and it supported by Java 8 only!

Prerequisites:

1. Install JDK version 8
2. Install Git
3. Ensure Chrome browser is installed on the machine where the test will run.
4. Optionally you can install IntelliJ and open this project as maven project

To build and execute the solution just follow these steps:

1. **Clone the repository to your machine:**
   ```bash
   git clone https://github.com/braimanm/test-lab-example.git
    ```
2. **Navigate to project folder:** 
    ```bash 
    cd test-lab-example
    ```
3. **Build the solution:**

   - **For Linux/macOS:** 
   ```bash
   ./mvnw clean package
   ```
   - **For Windows:**
   ```bash 
   mvnw.cmd clean package
   ```
4. **Execute the solution by invoking:** 
   ```bash
   java -jar target/example.jar
   ```

The test will invoke 5 Chrome browser instances and execute 5 different test cases in parallel.
At the end of the test, report with execution results will be launched in the default browser.

The test automation framework used in this example is designed to provide a comprehensive solution for automating the validation of enterprise business applications. It utilizes a component-based, data-driven, and business-oriented approach to address the complexities of web page interactions and web element interactions.

One of the key features of the framework is its focus on solving business-oriented validations, which allows for a more efficient and streamlined test automation process. Additionally, the framework addresses data-related issues by implementing separation of concerns (SOC) principles, which ensures that the test code logic is clean and completely separated from the data facilities. This allows for well-crafted tests to be written once and then used with a large number of different datasets.

The datasets that are used in this framework can contain both static and dynamically generated data supplied to the test during execution, and can alter the flow of the test depending on the supplied data. The framework also utilizes the "page object" design pattern, which allows for automatic population of all components on a page in a single line of code. Furthermore, page object classes are made serializable to and from datasets, and the framework is also capable of generating datasets from test assets, eliminating the need for manual data input.

Another notable feature of the framework is its ability to provide implicit testing during web component population and automatic retry in case data is inserted incorrectly due to issues with the web application, web browser, or underlying operating system instability. This mimics human interaction with the web application and allows for a more realistic and accurate testing process.

All of the features mentioned here are made possible by the introduction of "page components," which are much more sophisticated than traditional Selenium web elements. A page component is a reusable test artifact written in Java that is designed to provide supplied data to the application under test, regardless of the complexity of the component. The complexity and logic of the component are encapsulated within the component itself, ensuring that they do not leak into the test code.
