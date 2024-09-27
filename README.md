# test-lab-example

This is an example of using the [**UITAF**](https://uitaf.org) open-source project for UI testing.

Prerequisites:

1. Install JDK 11 or higher
2. Install Git
3. Ensure that the Chrome browser is installed on the machine where the test will be executed.
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

The test will launch 5 Chrome browser instances and execute 5 different test cases in parallel. Upon completion, a report with the execution results will be opened in the default browser.

The test automation framework used in this example is designed to provide a comprehensive solution for automating the validation of enterprise business applications. It employs a component-based, data-driven, and business-oriented approach to address the complexities of web page and element interactions.

A key feature of the framework is its focus on business-oriented validations, enabling a more efficient and streamlined test automation process. It addresses data-related challenges by implementing Separation of Concerns (SOC) principles, ensuring that test logic is cleanly separated from data management. This allows for the creation of well-structured tests that can be reused with numerous datasets.

The datasets used in this framework can include both static and dynamically generated data supplied during test execution, with the ability to alter the test flow based on the provided data. The framework also utilizes the Page Object design pattern, allowing for automatic population of all components on a page with a single line of code. Page Object classes are made serializable to and from datasets, and the framework can generate datasets from test assets, reducing the need for manual data entry.

Another standout feature is the framework’s capability to perform implicit testing during web component population and to automatically retry operations if data insertion fails due to web application, browser, or OS instability. This simulates realistic human interaction with the application, enhancing the accuracy of the testing process.

These features are enabled by the introduction of “Page Components,” which are more advanced than traditional Selenium web elements. A Page Component is a reusable test artifact written in Java, designed to supply data to the application under test, regardless of the component’s complexity. The complexity and logic are encapsulated within the component itself, ensuring they remain separate from the test code.

To learn more about this framework, visit https://uitaf.org.